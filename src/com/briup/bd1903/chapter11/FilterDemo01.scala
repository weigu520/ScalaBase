package com.briup.bd1903.chapter11

object FilterDemo01 {
  def main(args: Array[String]): Unit = {
    /*
    应用案例：将val names = List("Alice", "Bob", "Nick")集合中首字母为'A'的筛选到新的集合
     */
    val names = List("Alice", "Bob", "Nick")
    val names2 = names.filter(startA)
    println("names =" + names)
    println("names2 =" + names2)
  }

  def startA(str: String): Boolean = {
    str.startsWith("A")
  }
}
