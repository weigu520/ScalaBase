package com.briup.bd1903.chapter04.mybreak

import scala.util.control.Breaks._

object WhileBreak {
  def main(args: Array[String]): Unit = {
    var n = 1
    //breakable是一个高阶函数,可以接收函数的函数就是高阶函数
    /*
    def breakable(op: => Unit): Unit = {
    try {
      op
    } catch {
      case ex: BreakControl =>
        if (ex ne breakException) throw ex
    }
  }
  1.op: => Unit表示接收的参数是一个没有输入,也没有返回值的函数
  2.可以简单理解可以接收一段代码块
  3.breakable对break()抛出的异常做了处理,代码就继续执行
  4.当我们传入的是代码块,scala程序员会将()改成{}
     */
    breakable {
      while (n <= 20) {
        n += 1
        println("n=" + n)
        if (n == 18) {
          //中断while循环
          break()
        }
      }
    }
    println("ok~~~")

    //注意break函数,可以使用在for或者do..while
    breakable {
      for (i <- 1 to 100) {
        println("i=" + i)
        if (i == 20) {
          break()
        }
      }
    }

    println("ok2~~~")
  }
}
