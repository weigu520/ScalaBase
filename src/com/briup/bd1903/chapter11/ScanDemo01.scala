package com.briup.bd1903.chapter11

object ScanDemo01 {
  def main(args: Array[String]): Unit = {
    def minus(num1: Int, num2: Int): Int = {
      num1 - num2
    }

    //5 (1,2,3,4,5) =>先将5保留到集合左边(5),在进行minus操作 =>Vector(5,4,2,-1,-5,-10)
    val i8 = (1 to 5).scanLeft(5)(minus) //IndexedSeq[Int]
    println(i8)

    def add(num1: Int, num2: Int): Int = {
      num1 + num2
    }

    //5 (1,2,3,4,5) =>先将5保留到集合右边(5),在进行add操作 =>Vector(20, 19, 17, 14, 10, 5)
    val i9 = (1 to 5).scanRight(5)(add) //IndexedSeq[Int]
    println(i9)

  }
}
