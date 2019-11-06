package com.briup.bd1903.chapter10.array

object ArrayDemo02 {
  def main(args: Array[String]): Unit = {
    //使用的是object Array的apply
    //直接初始化数组,这时初始化的时候既有整数也有字符串,泛型为Any
    val arr = Array(1, 3, "x")
    for (i <- arr) {
      print(i)
    }
    //如果初始化的时候只有一种类型,泛型为这个类型,改变数组的时候只能修改为该类型
    val arr2 = Array(1, 3, 4)
    arr2(2) = 3
    for (index <- 0 until arr2.length) {
      printf("arr2[%d]=%s", index, arr2(index) + "\t")
    }
  }
}
