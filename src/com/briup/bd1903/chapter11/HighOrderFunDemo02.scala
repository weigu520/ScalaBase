package com.briup.bd1903.chapter11

object HighOrderFunDemo02 {
  def main(args: Array[String]): Unit = {
    test2(sayOk)
  }

  //test2是一个高阶函数,可以接收一个没有输入,返回为Unit的函数
  def test2(f: () => Unit): Unit = {
    f()
  }

  def sayOk(): Unit = {
    println("sayOk~~~")
  }
}
