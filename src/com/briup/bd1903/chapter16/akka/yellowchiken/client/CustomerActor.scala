package com.briup.bd1903.chapter16.akka.yellowchiken.client

import akka.actor.{Actor, ActorRef, ActorSelection, ActorSystem, Props}
import com.briup.bd1903.chapter16.akka.yellowchiken.common.{ClientMessage, ServerMessage}
import com.typesafe.config.ConfigFactory

import scala.io.StdIn

class CustomerActor(serverHost: String, serverPort: Int) extends Actor {
  //定义一个YellowChickenServerRef
  var serverActorRef: ActorSelection = _

  //在Actor中有一个preStart方法,会在actor运行前执行
  //在Akka的开发中,通常将初始化的工作,放在preStart方法
  override def preStart(): Unit = {
    println("preStart()方法执行")
    serverActorRef = context.actorSelection(s"akka.tcp://Server@${serverHost}:${serverPort}/user/YellowChickenServer")
    println("serverActorRef=" + serverActorRef)
  }

  override def receive: Receive = {
    case "start" => println("客户端运行,可以咨询问题")
    case mes: String => {
      //发送给服务器
      serverActorRef ! ClientMessage(mes) //使用case class ClientMessage的apply方法
    }
      //如果接收到服务器端的回复
    case ServerMessage(mes) => println(s"小黄鸡客服(Server): ${mes}")

  }
}

object CustomerActor extends App {
  val (clientHost, clientPort, serverHost, serverPort) = ("127.0.0.1", 9990, "127.0.0.1", 9999)
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$clientHost
       |akka.remote.netty.tcp.port=$clientPort
        """.stripMargin)

  //创建ActorSystem
  val clientActorSystem = ActorSystem("client", config)
  //创建CustomerActor的实例和引用
  val customerActorRef: ActorRef = clientActorSystem.actorOf(Props(new CustomerActor(serverHost, serverPort)), "CustomerActor")

  customerActorRef ! "start"

  //客户端可以发送消息给服务器
  while (true) {
    println("请输入你要咨询的问题:")
    val mes = StdIn.readLine()
    customerActorRef ! mes
  }

}
