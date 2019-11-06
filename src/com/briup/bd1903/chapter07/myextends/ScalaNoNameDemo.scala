package com.briup.bd1903.chapter07.myextends

object ScalaNoNameDemo {
  def main(args: Array[String]): Unit = {
    val mon = new Mon {
      override var name: String = "哪吒"

      override def cry(): Unit = {
        println(name + "大战傲丙！！！")
      }
    }
    mon.cry()
  }
}

abstract class Mon {
  var name: String

  def cry()
}
