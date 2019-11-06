package com.briup.bd1903.chapter10.array

object MultiplyArray {
  def main(args: Array[String]): Unit = {

    //创建二维数组
    val arr = Array.ofDim[Int](3, 4)

    //遍历
    for (item <- arr) {
      for (item2 <- item) {
        print(item2 + "\t")
      }
      println()
    }

    //指定取出元素
    println(arr(1)(1))

    //修改值
    arr(1)(1) = 100

    //遍历
    for (i <- arr.indices) {
      for (j <- arr(i).indices) {
        printf("arr[%d][%d]=%d\t", i, j, arr(i)(j))
      }
      println()
    }

  }
}
