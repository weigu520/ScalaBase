package com.briup.bd1903.chapter13

object CurryDemo01 {
  def main(args: Array[String]): Unit = {
    println(mulCurry(10)(8))
  }

  def mulCurry(x: Int)(y: Int) = x * y
}
