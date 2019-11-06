# 并发编程模型 Akka

## Akka 介绍

1. Akka是JAVA虚拟机JVM平台上构建高并发、分布式和容错应用的工具包和运行时，你可以理解成Akka是编写并发程序的框架。
2. Akka用Scala语言写成，同时提供了Scala和JAVA的开发接口。
3. Akka主要解决的问题是：可以轻松的写出高效稳定的并发程序，程序员不再过多的考虑线程、锁和资源竞争等细节。

![1572318609554](C:\Users\weigu\AppData\Roaming\Typora\typora-user-images\1572318609554.png)

## Akka 中 Actor 模型

### Actor 模型用于解决什么问题

1. 处理并发问题关键是要保证共享数据的一致性和正确性，因为程序是多线程时，多个线程对同一个数据进行修改，若不加同步条件，势必会造成数据污染。但是当我们对关键代码加入同步条件synchronized 后，实际上大并发就会阻塞在这段代码，对程序效率有很大影响。
2. 若是用单线程处理，不会有数据一致性的问题，但是系统的性能又不能保证。
3. Actor 模型的出现解决了这个问题，简化并发编程，提升程序性能。 你可以这里理解：Actor 模型是一种处理并发问题的解决方案，很牛!

### Actor模型及其说明

![1572318701899](C:\Users\weigu\AppData\Roaming\Typora\typora-user-images\1572318701899.png)

1. Akka 处理并发的方法基于 Actor 模型。(示意图)
2. 在基于 Actor 的系统里，所有的事物都是 Actor，就好像在面向对象设计里面所有的事物都是对象一样。
3. Actor 模型是作为一个并发模型设计和架构的。Actor 与 Actor 之间只能通过消息通信，如图的信封

4. Actor 与 Actor 之间只能用消息进行通信，当一个 Actor 给另外一个 Actor发消息，消息是有顺序的(消息队列)，只需要将消息投寄的相应的邮箱即可。
5. 怎么处理消息是由接收消息的Actor决定的，发送消息Actor可以等待回复，也可以异步处理(ajax)
6. ActorSystem 的职责是负责创建并管理其创建的 Actor， ActorSystem 是单例的(可以ActorSystem是一个工厂，专门创建Actor)，一个 JVM 进程中有一个即可，而 Acotr 是可以有多个的。
7. Actor模型是对并发模型进行了更高的抽象。
8. Actor模型是异步、非阻塞、高性能的事件驱动编程模型。[案例: 说明 什么是异步、非阻塞, 最经典的案例就是ajax异步请求处理 ]
9. Actor模型是轻量级事件处理（1GB 内存可容纳百万级别个 Actor），因此处理大并发性能高.

### Actor模型工作机制说明

#### 工作机制示意图

![1572319105389](C:\Users\weigu\AppData\Roaming\Typora\typora-user-images\1572319105389.png)

A Actor 如果想给自己发消息，就通过A ActorRef

A Actor 想给B Actor 发消息，就需要有(持有)B  ActorRef , 通过B ActorRef 发消息

B Actor 中
receive 方法 {

 //1.消息接收和处理
 //2. 通过sender() 方法可以得到发送消息的Actor的ActorRef, 通过这个ActorRef  ，B Actor 也可以回复消息
}

#### Actor模型工作机制说明

1. ActorySystem创建Actor
2. ActorRef:可以理解成是Actor的代理或者引用。消息是通过ActorRef来发送,而不能通过Actor 发送消息，通过哪个ActorRef 发消息，就表示把该消息发给哪个Actor
3. 消息发送到Dispatcher Message (消息分发器)，它得到消息后，会将消息进行分发到对应的MailBox。(注: Dispatcher Message 可以理解成是一个线程池, MailBox 可以理解成是消息队列，可以缓冲多个消息，遵守FIFO)
4. Actor 可以通过 receive方法来获取消息，然后进行处理

#### Actor间传递消息机制

1. 每一个消息就是一个Message对象。Message 继承了Runable， 因为Message就是线程类。
2. 从Actor模型工作机制看上去很麻烦，但是程序员编程时只需要编写Actor就可以了，其它的交给Actor模型完成即可。
3. A Actor要给B Actor 发送消息，那么A Actor 要先拿到(也称为持有) B Actor 的 代理对象ActorRef 才能发送消息 

### Actor模型快速入门

#### 应用实例需求

1. 编写一个Actor, 比如SayHelloActor
2. SayHelloActor 可以给自己发送消息 ,如图
3. 要求使用Maven的方式来构建项目,这样可以很好的解决项目开发包的依赖关系。[scala 和 akka]

![1572435770971](C:\Users\weigu\AppData\Roaming\Typora\typora-user-images\1572435770971.png)

```scala
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
```

#### 小结和说明

当程序执行 aActorRef = actorFactory.actorOf(Props[AActor], "aActor") ，会完成如下任务 [这是非常重要的方法]

1. actorFactory 是 ActorSystem("ActorFactory") 这样创建的。
2. 这里的 Props[AActor] 会使用反射机制，创建一个AActor 对象，如果是actorFactory.actorOf(Props(new AActor(bActorRef)), "aActorRef") 形式，就是使用new 的方式创建一个AActor对象, 注意Props() 是小括号
3. 会创建一个AActor 对象的代理对象 aActorRef , 使用aActorRef 才能发送消息
4. 会在底层创建 Dispather Message ，是一个线程池，用于分发消息， 消息是发送到对应的Actor的 MailBo
5. 会在底层创建AActor 的MailBox 对象，该对象是一个队列，可接收Dispatcher Message 发送的消息
6. MailBox 实现了Runnable 接口，是一个线程，一直运行并调用Actor的receive 方法，因此当Dispather 发送消息到MailBox时，Actor 在receive 方法就可以得到信息.
7. aActorRef !  "hello", 表示把hello消息发送到A Actor 的mailbox （通过Dispatcher Message 转发）

### Actor模型应用实例-Actor间通讯

#### 应用实例需求

编写2个 Actor , 分别是  AActor 和 BActor
AActor和BActor之间可以相互发送消息.
加强对Actor传递消息机制的理解。

```scala
package com.briup.bd1903.chapter16.akka.actors

import akka.actor.{Actor, ActorRef}

class AActor(actorRef: ActorRef) extends Actor {
  val bActorRef: ActorRef = actorRef

  override def receive: Receive = {
    case "start" => {
      println("AActor 出招了")
      self ! "我打"
    }
    case "我打" => {
      //这里需要持有BActor的引用(BActorRef)
      println("AActor(黄飞鸿) 厉害 看我佛山无影脚")
      Thread.sleep(1000)
      //给BActor 发出消息
      bActorRef ! "我打"
    }
  }
}
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
package com.briup.bd1903.chapter16.akka.actors

import akka.actor.{ActorRef, ActorSystem, Props}

object ActorGame extends App {
  //创建ActorSystem
  val actorFactory = ActorSystem("actorFactory")
  //先创建BActor引用/代理
  val bActorRef: ActorRef = actorFactory.actorOf(Props[BActor],"bActor")
  //创建AActor的引用
  val aActorRef: ActorRef = actorFactory.actorOf(Props(new AActor(bActorRef)),"aActor")

  //aActor出招
  aActorRef ! "start"
}
```

#### 小结和说明

1. 两个Actor通讯机制和Actor 自身发消息机制基本一样，只是要注意如下
2. 如果A Actor 在需要给B Actor 发消息，则需要持有B Actor 的 ActorRef，可以通过创建时，传入 B Actor的 代理对象(ActorRef)
3. 当B Actor 在receive 方法中接收到消息，需要回复时，可以通过sender() 获取到发送Actor的 代理对象。

**如何理解Actor 的receive 方法被调用?**

1. 每个Actor对应MailBox
2. MailBox 实现了Runnable 接口，处于运行的状态
3. 当有消息到达MailBox,就会去调用Actor的receive方法，将消息推送给receive 

## Akka网络编程

### 基本介绍

Akka支持面向大并发后端服务程序，网络通信这块是服务端程序重要的一部分。
网络编程有两种:
TCP socket编程，是网络编程的主流。之所以叫Tcp socket编程，是因为底层是基于Tcp/ip协议的. 比如: QQ聊天 [示意图]
b/s结构的http编程，我们使用浏览器去访问服务器时，使用的就是http协议，而http底层依旧是用tcp socket实现的。 比如: 京东商城 【属于 web 开发范畴 】

### Akka网络编程-小黄鸡客服

#### 需求分析

1. 服务端进行监听(9999)
2. 客户端可以通过键盘输入，发送咨询问题给小黄鸡客服(服务端)
3. 小黄鸡(服务端) 回答客户的问题

![1572524924207](C:\Users\weigu\AppData\Roaming\Typora\typora-user-images\1572524924207.png)

#### 服务器

```scala
package com.briup.bd1903.chapter16.akka.yellowchiken.server

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.briup.bd1903.chapter16.akka.yellowchiken.common.{ClientMessage, ServerMessage}
import com.typesafe.config.ConfigFactory

class YellowChickenServer extends Actor {
  override def receive: Receive = {
    case "start" => println("小黄鸡客服开始工作了...")
    //如果服务器接收到了ClientMessage
    case ClientMessage(mes) => {
      //使用match case 匹配(模糊匹配)
      mes match {
        case "大数据学费" => sender() ! ServerMessage("20000RMB")
        case "学校地址" => sender() ! ServerMessage("某昆某软件园")
        case "学习什么技术" => sender() ! ServerMessage("大数据 前端 python")
        case _ => sender() ! ServerMessage("你说的啥子~~~")
      }
    }
  }
}

//主程序
object YellowChickenServer extends App {

  val host = "127.0.0.1" //服务端ip地址
  val port = 9999
  //创建config对象,指定协议类型，监听的ip和端口
  val config = ConfigFactory.parseString(
    s"""
       |akka.actor.provider="akka.remote.RemoteActorRefProvider"
       |akka.remote.netty.tcp.hostname=$host
       |akka.remote.netty.tcp.port=$port
        """.stripMargin)

  //创建ActorSystem
  val serverActorSystem = ActorSystem("Server", config)
  //创建YellowChickenServer的actor和返回actorRef
  val yellowChickenServerRef: ActorRef = serverActorSystem.actorOf(Props[YellowChickenServer], "YellowChickenServer")

  //启动
  yellowChickenServerRef ! "start"
}
```

#### 客户端

```scala
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
```

#### 使用样例类构建协议

```scala
package com.briup.bd1903.chapter16.akka.yellowchiken.common

//使用样例类来构建协议
//客户端发给服务器协议(序列化的对象)
case class ClientMessage(mes: String)

//服务器发给客户端协议(序列化的对象)
case class ServerMessage(mes: String)
```

## Spark Master Worker 进程通讯项目

### 项目意义

1. 深入理解Spark的Master和Worker的通讯机制
2. 为了方便同学们看Spark的底层源码，命名的方式和源码保持一致.(如： 通讯消息类命名就是一样的)
3. 加深对主从服务心跳检测机制(HeartBeat)的理解，方便以后spark源码二次开发。

### 项目需求分析

1. worker注册到Master, Master完成注册，并回复worker注册成功
2. worker定时发送心跳，并在Master接收到
3. Master接收到worker心跳后，要更新该worker的最近一次发送心跳的时间
4. 给Master启动定时任务，定时检测注册的worker有哪些没有更新心跳,并将其从hashmap中删除
5. master worker 进行分布式部署(Linux系统)-》如何给maven项目打包->上传linux