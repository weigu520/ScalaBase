package com.briup.bd1903.chapter04.forloop

object MultiplyFor {
  def main(args: Array[String]): Unit = {
    //多重for循环
    for (i <- 1 to 3; j <- 1 to 3) {
      println(" i =" + i + " j = " + j)
    }
    //等价于下面的写法
    for (i <- 1 to 3) {
      for(j <- 1 to 3){
        println(" i =" + i + " j = " + j)
      }
    }

  }
}
