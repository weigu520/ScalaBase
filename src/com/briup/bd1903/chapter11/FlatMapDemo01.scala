package com.briup.bd1903.chapter11

object FlatMapDemo01 {
  def main(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")
    //注意：每个字符串也是char集合

    //将List集合中的所有元素,进行扁平化操作,把所有元素打散
    println(names.flatMap(upper))

  }

  def upper(s: String): String = {
    s.toUpperCase
  }
}
