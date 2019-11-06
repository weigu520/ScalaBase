package com.briup.bd1903.chapter16.sparkmasterworker.master

import akka.actor.{Actor, ActorSystem, Props}
import com.briup.bd1903.chapter16.sparkmasterworker.common.{HeartBeat, RegisterWorkerInfo, RegisteredWorkerInfo, RemoveTimeOutWorker, StartTimeOutWorker, WorkerInfo}
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._
import scala.collection.mutable

class SparkMaster extends Actor {
  //定义一个HashMap管理worker
  val workers = mutable.Map[String, WorkerInfo]()

  override def receive: Receive = {
    case "start" => {
      println("master启动了...")
      //给自己发一个消息StartTimeOutWorker
      self ! StartTimeOutWorker
    }
    case RegisterWorkerInfo(id, cpu, ram) => {
      //接收worker注册信息
      if (!workers.contains(id)) {
        //创建WorkerInfo对象
        val workerInfo = new WorkerInfo(id, cpu, ram)
        //放入到workers
        workers += ((id, workerInfo))
        println("workers= " + workers)
        //回复一个消息,表示注册成功
        sender() ! RegisteredWorkerInfo
      }
    }
    case HeartBeat(id) => {
      //更新对应的worker的心跳时间
      //1.从workers取出WorkerInfo
      val workerInfo = workers(id)
      workerInfo.lastHeartBeat = System.currentTimeMillis()
      println("master更新了" + id + "的心跳时间...")
    }
    case StartTimeOutWorker => {
      println("开始了定时检测worker心跳的任务")
      import context.dispatcher
      context.system.scheduler.schedule(0 millis, 9000 millis, self, RemoveTimeOutWorker)
    }
    //对RemoveTimeOutWorker消息处理
    //需要检测哪些worker心跳超时(now - lastHeartBeat > 6000 millis),并从map中删除
    case RemoveTimeOutWorker => {
      //首先将所有的workers的WorkerInfo拿出来
      val workerInfos = workers.values
      //获取当前时间
      val nowTime = System.currentTimeMillis()
      //先把超时的所有workerInfo删除即可
      workerInfos
        .filter(workerInfo => (nowTime - workerInfo.lastHeartBeat) > 6000) //过滤超时的
        .foreach(workerInfo => workers.remove(workerInfo.id)) //删除超时的
      println("当前有" + workers.size + "个worker存活...")
    }
  }
}

object SparkMaster {
  def main(args: Array[String]): Unit = {

    //有三个参数host port sparkMasterActor
    if(args.length !=3){
      println("请输入参数 host port sparkMasterActor名字")
      sys.exit()
    }
    val host =args(0)
    val port =args(1)
    val name =args(2)


    val config = ConfigFactory.parseString(
      s"""
         |akka.actor.provider="akka.remote.RemoteActorRefProvider"
         |akka.remote.netty.tcp.hostname=${host}
         |akka.remote.netty.tcp.port=${port}
            """.stripMargin)
    //创建ActorSystem对象
    val sparkMasterSystem = ActorSystem("SparkMaster", config)
    //创建SparkMaster-Actor
    val sparkMasterRef = sparkMasterSystem.actorOf(Props[SparkMaster], s"${name}")
    //启动SparkMaster
    sparkMasterRef ! "start"
  }
}