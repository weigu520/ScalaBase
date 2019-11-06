package com.briup.bd1903.chapter16.akka.actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
//当继承Actor后,就是一个Actor,核心方法Receive 方法重写
class SayHelloActor extends Actor{
  //1.receive方法,会被该Actor的MailBox(实现了Runnable接口)调用
  //2.当Actor的MailBox接收到消息时,就会调用receive方法
  override def receive: Receive = {
    case "hello" => println("收到hello,回应hello too:")
    case "ok" => println("收到ok,回应ok too:")
    case "exit" => {
      println("接收到exit指令,退出系统")
      context.stop(self)  //停止当前ActorRef
      context.system.terminate()  //退出ActorSystem
    }
    case "quit" => {
      println("接收到exit指令,退出系统")
      context.stop(self)  //停止当前ActorRef
      context.system.terminate()  //退出ActorSystem
    }
    case _ => println("匹配不到")
  }
}

object SayHelloActorDemo {

  //1.先创建一个ActorSystem,专门用于创建Actor
  private val actorFactory = ActorSystem("actorFactory")
  //2.创建一个Actor的同时,返回Actor的ActorRef
  //Props[SayHelloActor]创建了一个SayHelloActor实例,使用反射
  //"sayHelloActor"给actor取名
  //sayHelloActorRef: ActorRef就是Props[SayHelloActor]的Actor的引用
  //创建的SayHelloActor实例被ActorSystem管理
  private val sayHelloActorRef: ActorRef = actorFactory.actorOf(Props[SayHelloActor],"sayHelloActor")

  def main(args: Array[String]): Unit = {
    //给SayHelloActor发消息(MailBox)
    sayHelloActorRef ! "hello"
    sayHelloActorRef ! "ok"
    sayHelloActorRef ! "ok~"
    sayHelloActorRef ! "exit"
    //如何退出ActorSystem
  }
}
