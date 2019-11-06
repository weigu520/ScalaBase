package com.briup.bd1903.chapter13

object ParameterInfer {
  def main(args: Array[String]): Unit = {
    //分别说明
    val list = List(1, 2, 3, 4)
    println(list.map((x: Int) => x + 1)) //(2,3,4,5)
    println(list.map((x) => x + 1))
    println(list.map(x => x + 1))
    println(list.map(_ + 1))

    println(list.reduceLeft(f1))
    println(list.reduceLeft((n1: Int, n2: Int) => n1 + n2))
    println(list.reduceLeft((n1, n2) => n1 + n2))
    println(list.reduceLeft(_ + _))
    val res = list.reduce(_ + _)

  }

  def f1(n1: Int, n2: Int): Int = {
    n1 + n2
  }
}
