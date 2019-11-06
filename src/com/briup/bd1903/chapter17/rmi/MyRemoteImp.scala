package com.briup.bd1903.chapter17.rmi

import java.rmi.registry.LocateRegistry
import java.rmi.{Naming, RemoteException}
import java.rmi.server.UnicastRemoteObject

class MyRemoteImp extends UnicastRemoteObject with MyRemote {
  @throws(classOf[RemoteException])
  override def sayHello(): String = {
    "Hello World!~"
  }
}

//完成对服务(sayHello)注册任务->对服务管理
object MyRemoteImp {
  def main(args: Array[String]): Unit = {
    val service: MyRemote = new MyRemoteImp()
    //准备把服务绑定到9999端口(第一种注册方式)
//    LocateRegistry.createRegistry(9999)
//    Naming.rebind("RemoteHello", service)
    //第二种注册方式
    Naming.rebind("rmi://127.0.0.1:9999/RemoteHello", service)
    println("远程服务开启，在127.0.0.1 的 9999端口监听，服务名 RemoteHello")
  }
}
