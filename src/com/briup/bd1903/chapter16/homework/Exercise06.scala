package com.briup.bd1903.chapter16.homework

object Exercise06 {
  def main(args: Array[String]): Unit = {
    println(func(3))
  }
  //用to和reduceLeft实现阶乘函数,不得使用循环或递归
  def func(n: Int): Int = {
//    1 to n reduce((x: Int,y: Int) => x * y)
    1 to n reduce(_ * _)
  }
}
