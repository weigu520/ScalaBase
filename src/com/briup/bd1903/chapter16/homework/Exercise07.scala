package com.briup.bd1903.chapter16.homework

object Exercise07 {
  def main(args: Array[String]): Unit = {
    val max = largest(x=>10*x-x*x,1 to 10)
    println("maxValue=" + max)
  }
  /*
  编写函数largest(fun:(Int)=>Int,inputs:Seq[Int]),输出在给定输入序列中给定函数的最大值。
  举例来说，largest(x=>10*x-x*x,1 to 10)应该返回25.不得使用循环或递归,使用高阶函数完成
   */
  def largest(fun:(Int)=>Int,inputs:Seq[Int]) = {
    inputs.map(fun(_)).max
  }
}
