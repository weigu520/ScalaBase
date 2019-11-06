package com.briup.bd1903.chapter05.exercise

object Exercise01 {
  def main(args: Array[String]): Unit = {
    //    println("请输入数字(1-9)之间")
    //
    //    val n = StdIn.readInt()
    //    print99(n)
    print1(6)
  }

  def print1(n: Int): Unit = {
    val s1: String = "*"
    val s2: String = " "
    //1 3 5 1+(n-1)*2
    for (i <- 1 to n) {
//      println(s2 * (n - i) + s1)
      println(s"${s2 * (n - i)}${s1 * (1 + ((i - 1) * 2))}")
    }
  }

  //编写一个函数,从终端输入一个整数(1—9),打印出对应的乘法表:【上机练习】
  def print99(n: Int): Unit = {
    for (i <- 1 to n) {
      for (j <- 1 to i) {
        printf("%d * %d = %d\t", j, i, j * i)
      }
      println()
    }
  }

}
