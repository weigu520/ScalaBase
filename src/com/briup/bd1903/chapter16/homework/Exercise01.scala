package com.briup.bd1903.chapter16.homework

object Exercise01 {
  def main(args: Array[String]): Unit = {
    println(swap(10,20))
  }

  //利用模式匹配，编写一个swap函数，接受一个整数的对偶，返回对偶的两个组成部件互换位置的新对偶
  def swap[T, S](tup: (T, S)) = {
    tup match {
      case (a, b) => (b, a)
      case _ => println("没有匹配到...")
    }
  }
}
