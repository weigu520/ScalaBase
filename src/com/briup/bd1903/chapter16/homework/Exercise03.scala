package com.briup.bd1903.chapter16.homework

object Exercise03 {
  def main(args: Array[String]): Unit = {
    println(mySum(List(Some(1),Some(2),None)))
  }
  //编写一个函数，计算List[Option[Int]]中所有非None值之和。不得使用match语句
  def mySum(list: List[Option[Int]]) = list.map(_.getOrElse(0)).sum
}
