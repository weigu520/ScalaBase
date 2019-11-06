package com.briup.bd1903.chapter06.homework

object Exercise04 {
  def main(args: Array[String]): Unit = {
    val n = 3
    val res = (0 to n).reverse
    println(res)

    //foreach
    //foreach函数(f: Int => U)即接收一个输入参数为Int,输出为U的函数
    //将res的每个元素依次遍历出来传给println(x)/myShow(x)
//    res.foreach(println)
    res.foreach(myShow)

    //一步搞定
    println("============")
    (0 to n).reverse.foreach(println)

  }

  //自己写一个myShow
  def myShow(n: Int): Unit = {
    println("xxxx")
    println(n)
  }

}
