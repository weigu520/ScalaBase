package com.briup.bd1903.chapter06.homework

object Exercise08 {
  def main(args: Array[String]): Unit = {
    val str = "Hello"
    val subStr1 = str.take(1)
    println(subStr1) //"H"
    val subStr2 = str.drop(1)
    println(subStr2) //"ello"
  }

  def ms(string: String): Long = {
    if (string.length == 1) return string.charAt(0).toLong
    else string.take(1).charAt(0).toLong * ms(string.drop(1))
  }
}
