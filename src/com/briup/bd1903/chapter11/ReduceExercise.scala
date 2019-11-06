package com.briup.bd1903.chapter11

object ReduceExercise {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4 ,5)
    println(list.reduceLeft(minus)) // 输出-13

    println(1-(2-(3-((4-5)))))
    println(list.reduceRight(minus)) //输出3

    //reduce等价于reduceLeft
    println(list.reduce(minus)) //是-13
  }

  def minus(num1: Int, num2: Int): Int = {
    num1 - num2
  }

}
