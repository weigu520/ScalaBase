package com.briup.bd1903.chapter13

object HigherOrderFun {
  def main(args: Array[String]): Unit = {
    //test 就是一个高阶函数，它可以接收f: Double => Double
    def test(f1: Double => Double, f2: Double => Int, n1: Double) = {
      f1(f2(n1))
    }

    //sum 是接收一个Double,返回一个Double
    def sum(d: Double): Double = {
      d + d
    }

    def mod(d: Double): Int = {
      d.toInt % 2
    }

    val res = test(sum, mod, 7.0)
    println("res=" + res)

  }
}
