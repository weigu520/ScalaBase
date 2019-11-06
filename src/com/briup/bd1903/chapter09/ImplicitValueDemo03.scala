package com.briup.bd1903.chapter09

object ImplicitValueDemo03 {
  def main(args: Array[String]): Unit = {
    implicit val str: String = "jack" //这个就是隐式值

    //implicit name: String就是隐式参数
    def hello(implicit name: String): Unit = {
      println(name + "hello")
    }

    hello
    //不能带参数即不能写成hello()
    //底层hello$1(str)
  }
}
