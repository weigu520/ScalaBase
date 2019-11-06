package com.briup.bd1903.chapter17.rmi

import java.rmi.{Remote, RemoteException}

//本地和远程使用
trait MyRemote extends Remote{
  @throws(classOf[RemoteException])
  def sayHello(): String
}
