package com.briup.bd1903.chapter11

object FoldDemo02 {
  def main(args: Array[String]): Unit = {
    val list4 = List(1, 9, 2, 8)

    def minus(num1: Int, num2: Int): Int = {
      num1 - num2
    }

    var i6 = (1 /: list4) (minus) // =等价=> list4.foldLeft(1)(minus)
    println(i6) // 输出-19
    i6 = (100 /: list4) (minus)
    println(i6) // 输出80
    i6 = (list4 :\ 10) (minus) // list4.foldRight(10)(minus)
    println(i6) // 输出-4

  }
}
