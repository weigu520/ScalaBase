package com.briup.bd1903.chapter04.mutilfor

object Exercise03 {
  def main(args: Array[String]): Unit = {
    //3. 打印出九九乘法表
    //使用两次循环,有9行,每一行的列数在增加
    val num = 9
    for (i <- 1 to num) { //行
      for (j <- 1 to i) { //列
        printf("%d * %d = %d\t", j, i, i * j)
      }
      println()
    }
  }
}
