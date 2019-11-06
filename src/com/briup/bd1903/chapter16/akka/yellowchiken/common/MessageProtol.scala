package com.briup.bd1903.chapter16.akka.yellowchiken.common

//使用样例类来构建协议
//客户端发给服务器协议(序列化的对象)
case class ClientMessage(mes: String)

//服务器发给客户端协议(序列化的对象)
case class ServerMessage(mes: String)
