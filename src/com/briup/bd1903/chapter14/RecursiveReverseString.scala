package com.briup.bd1903.chapter14

object RecursiveReverseString {
  def main(args: Array[String]): Unit = {
    val str = "myReverse"
    println(reverse(str))
  }
  //使用递归完成对字符串的翻转
  def reverse(xs: String): String =
    if (xs.length == 1) xs
    else reverse(xs.tail) + xs.head
}
