package com.briup.bd1903.chapter16.akka.actors

import akka.actor.Actor

class BActor extends Actor{
  override def receive: Receive = {
    case "我打" => {
      println("BActor(乔峰) 好厉害 看我降龙十八掌")
      Thread.sleep(1000)
      //通过sender() 可以获取到发送消息的actorref
      sender() ! "我打"
    }
  }
}
