package com.briup.bd1903.chapter14

object RecursiveFibo {
  def main(args: Array[String]): Unit = {
    var count = BigInt(0)
    println(fbn(10))
    println("递归的次数是=" + count)
    println(fbn(30))
    println("递归的次数是=" + count)

    //研究下递归斐波那契数列的递归次数的增长情况
    //递归的次数呈现是指数增长
    def fbn(n: BigInt): BigInt = {
      count += 1
      if (n == 1 || n == 2) 1
      else fbn(n - 2) + fbn(n - 1)  //重复计算时,优化递归
    }
  }

}
