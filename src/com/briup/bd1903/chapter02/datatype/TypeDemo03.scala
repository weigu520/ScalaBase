package com.briup.bd1903.chapter02.datatype

object TypeDemo03 {
  def main(args: Array[String]): Unit = {
    println("Long的最大值" + Long.MaxValue + "Long的最小值" + Long.MinValue)

    var i = 10 // i Int
    var l = 10l // l Long
    var e = 9223372036854775807L//超过Int范围

    var num1: Float = 2.2345678912f
    var num2: Double = 2.2345678912
    println("num1:" + num1 + "num2:" + num2) //结果num1:2.2345679   num2:2.2345678912

  }
}
