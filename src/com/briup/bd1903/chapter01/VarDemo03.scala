package com.briup.bd1903.chapter01

object VarDemo03 {
  val age = 100 //等同加了final private final int age
  var name = "hello" //不加final private String name

  def main(args: Array[String]): Unit = {
    println("OK")
  }
}
