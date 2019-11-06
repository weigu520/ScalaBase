package com.briup.bd1903.chapter04.dowhile

object DoWhileDemo01 {
  def main(args: Array[String]): Unit = {
    var i = 0
    do {
      println("hello,scala" + i)
      i += 1
    } while (i < 10)
  }
}
