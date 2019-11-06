package com.briup.bd1903.chapter14

object RecursiveFactoria {
  def main(args: Array[String]): Unit = {
    println(factorial(3))
  }
  //递归求出阶乘
  def factorial(n: Int): Int = {
    if (n == 1) 1 else n * factorial(n-1)
  }
}
