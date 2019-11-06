package com.briup.bd1903.chapter13

object HigherOrderFun2 {
  def main(args: Array[String]): Unit = {

    //minusxy(x: Int)是一个高阶函数,因为返回了一个匿名函数
    //返回的匿名函数是(y: Int) => x - y
    //返回的匿名函数可以使用变量接收

    def minusxy(x: Int) = {
      (y: Int) => x - y //匿名函数
    }

    //分步执行
    val f1 = minusxy(3)
    //f1就是(y: Int) => 3 - y
    println("f1的类型为" + f1) //3-1
    println(f1(1)) //3-1
    println(f1(3)) //3-3

    //一步到位
    val result3 = minusxy(3)(5)
    println(result3)
  }
}
