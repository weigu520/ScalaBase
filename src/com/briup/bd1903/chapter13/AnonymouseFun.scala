package com.briup.bd1903.chapter13

object AnonymouseFun {
  def main(args: Array[String]): Unit = {
    //不需要写def函数名
    //不需要写返回类型,使用类型推导
    //=变成=>
    //如果有多行,则使用{}包裹
    val triple = (x: Double) => 3 * x
    println(triple)
    println(triple(3))
  }
}
