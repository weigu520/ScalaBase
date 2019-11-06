package com.briup.bd1903.chapter16.sparkmasterworker.common

// worker注册信息
case class RegisterWorkerInfo(id: String, cpu: Int, ram: Int)

// 这个是WorkerInfo, 保存在master的HashMap中的
class WorkerInfo(val id: String, val cpu: Int, val ram: Int) {
  var lastHeartBeat: Long = System.currentTimeMillis()
}

//当worker注册成功,服务器返回这个实例
case object RegisteredWorkerInfo

//心跳协议
//worker每隔一定时间由定时器发给自己的一个消息
case object SendHeartBeat

//worker每隔一定时间由定时器触发,向master发送的协议信息
case class HeartBeat(id: String)

//master给自己发送一个触发检查超时worker的信息
case object StartTimeOutWorker
//master给自己发消息，检测worker,对于心跳超时的.
case object RemoveTimeOutWorker


