package com.briup.bd1903.chapter06.constructor

object ConDemo04 {
  def main(args: Array[String]): Unit = {
    val worker = new Worker("smith")
    worker.name //不能访问inName

    val worker2 = new Worker2("smith2")
    worker2.inName //可以访问inName

    val worker3 = new Worker3("Jack")
    worker3.inName = "smith3"
    println(worker3.inName)
  }
}

//1.如果主构造器Worker(inName: String),那么inName就是一个局部变量
class Worker(inName: String) {
  var name = inName
}

//2.主构造器Worker2(val inName: String),那么inName就是Worker2的一个private的只读属性
class Worker2(val inName: String) {
  var name = inName
}

//3.inName是private的可读写的属性
class Worker3(var inName: String) {
  var name = inName
}
