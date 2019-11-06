package com.briup.bd1903.chapter13

object FunPatameter {
  def main(args: Array[String]): Unit = {
    def plus(x: Int) = 3 + x

    //在scala中,函数也是有类型的,比如plus就是<function1>
    val result1 = Array(1, 2, 3, 4).map(plus(_))
    println(result1.mkString(","))
  }
}
