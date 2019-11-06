package com.briup.bd1903.chapter11

object ReduceDemo01 {
  def main(args: Array[String]): Unit = {
    //化简的方式来计算List集合的和
    val list = List(1, 20, 30, 4, 5, 4, 5, 1)

    val res = list.reduceLeft(sum)  //接收一个函数时,也可以传递一个匿名函数
    println("res=" + res)

    val minRes = list.reduceLeft(min)
    println("minRes=" + minRes)
  }

  def sum(n1: Int, n2: Int): Int = {
    n1 + n2
  }

  def min(n1: Int, n2: Int): Int = {
    if (n1 < n2) n1
    else n2
  }
}
