package com.briup.bd1903.chapter04.homework

import scala.util.control.Breaks._

object HomeWork01 {
  def main(args: Array[String]): Unit = {
    /*
    100以内的数求和,求当和第一次大于20的当前数
     */
    var num = 0
    breakable {
      for (i <- 1 to 100) {
        num += i
        if (num > 20) {
          println("第一次大于20的当前数是" + i)
          break()
        }
      }
    }

    //除了break机制来中断之外,使用循环守卫
    println("===============")
    var loop = true
    var sum = 0
    for (i <- 1 to 100 if loop == true) {
      sum += i
      if (sum > 20) {
        println("循环守卫实现中断 第一次大于20的当前数=" + i)
        loop = false
      }
      println("i=" + i)
    }

  }
}
