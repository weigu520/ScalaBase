package com.briup.bd1903.chapter14

object RecursiveMaxList {
  def main(args: Array[String]): Unit = {
    println(max(List(1, 25, 9, -1)))
    println(List(1, 25, 9, -1).max)
  }

  //大话java数据结构,使用递归求List中最大元素
  def max(xs: List[Int]): Int = {
    //如果为空,抛出异常
    if (xs.isEmpty)
      throw new java.util.NoSuchElementException
    if (xs.size == 1) xs.head //如果有一个元素,就是它
    //递归时告诉计算机做什么,而不是告诉计算机怎么做(迭代)
    else if (xs.head > max(xs.tail)) xs.head
    else max(xs.tail)
  }

}
