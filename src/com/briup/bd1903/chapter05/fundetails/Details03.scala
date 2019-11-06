package com.briup.bd1903.chapter05.fundetails

object Details03 {
  def main(args: Array[String]): Unit = {
    def f1(): Unit = { //ok private final f1$1()
      println("f1")
    }

    println("ok~~~")

    def sayOk(): Unit = { //private final sayOk$1()
      println("main sayOk")
      def sayOk(): Unit = { //private final sayOk$2()
        println("sayOk sayOk")
      }
    }

  }

  def sayOk(): Unit = {
    println("main sayOk")
  }
}
