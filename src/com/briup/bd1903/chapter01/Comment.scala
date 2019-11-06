package com.briup.bd1903.chapter01

object Comment {
  /**
    * @deprecated 过期
    * @example testing code
    * @param args
    * 生成文档命令 : scaladoc -d ./mydoc Comment.scala
    */
  def main(args: Array[String]): Unit = {
    println("hello,world!!!")
  }

  /**
    * @deprecated 过期
    * @example
    * 输入n1=10 n2=20 return 30
    * @param n1
    * @param n2
    * @return 两数之和
    */
  def sum(n1: Int, n2: Int): Int = {
    return n1 + n2
  }
}
