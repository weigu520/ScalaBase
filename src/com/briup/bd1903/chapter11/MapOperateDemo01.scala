package com.briup.bd1903.chapter11

object MapOperateDemo01 {
  def main(args: Array[String]): Unit = {
    val list1 = List(3, 5, 7)
    var list2 = List[Int]()

    for (item <- list1) {
      list2 = list2 :+ item * 2
    }
    println("list2=" + list2)
  }
}
