package com.briup.bd1903.chapter16.homework

object Exercise02 {
  def main(args: Array[String]): Unit = {
    println(Array(1, 2, "hello").toBuffer)
  }

  //利用模式匹配，编写一个swap函数，交换数组中的前两个元素的位置，前提条件是数组长度至少为2
  def swap(array: Array[Any]) = {
    array match {
      case Array(first, second, rest@_*) => Array(second, first) ++ rest
      case _ => array
    }
  }
}
