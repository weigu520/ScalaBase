package com.briup.bd1903.chapter10.array

object ArrayDemo01 {
  def main(args: Array[String]): Unit = {
    //创建Array
    //在没有赋值的情况下,各个元素的值为0
    val arr = new Array[Int](4)   //底层int[] arr = new int[4]
    println(arr.length)

    arr(3) = 10
    for (i <- arr) {
      println(i)
    }
  }
}
