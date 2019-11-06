package com.briup.bd1903.chapter01

class HelloScala {
  private var value = 0
  def increment(args: Int): Unit = { value += args}
  def current(): Int = { value }
}
//只要看到object
// object MainScala对应的是一个MainScala$的一个静态对象MODULE$ 在程序中是一个单例对象
object MainScala{
  def main(args: Array[String]): Unit = {
    val myHelloScala =new HelloScala
    myHelloScala.increment(2)
    print(myHelloScala.current())
  }
}

