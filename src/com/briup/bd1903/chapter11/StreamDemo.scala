package com.briup.bd1903.chapter11

object StreamDemo {
  def main(args: Array[String]): Unit = {
    //创建Stream
    def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n + 1)

    val stream1 = numsForm(1)
    println(stream1) //(1,?)
    //取出第一个元素
    println("head=" + stream1.head) //  1
    println(stream1.tail) //(2,?)
    println(stream1) //(1,2?)

    //创建Stream
//    def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
    def multi(x:BigInt) : BigInt = {
      x * x
    }
    println(numsForm(5).map(multi)) // (25,?)

  }
}
