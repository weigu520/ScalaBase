package com.briup.bd1903.chapter06.homework

object Exercise06 {
  def main(args: Array[String]): Unit = {
    var res = 1L
    var res2 = 1L

    def myCount(char: Char): Unit = {
      res *= char.toLong
    }

    val s = "Hello"
    s.foreach(myCount)
    println("res=" + res)

    //一步到位
    "Hello".foreach(res2 *= _.toLong)
    println("res2=" + res2)
  }
}
