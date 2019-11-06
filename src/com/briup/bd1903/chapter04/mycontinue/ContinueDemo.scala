package com.briup.bd1903.chapter04.mycontinue

object ContinueDemo {
  def main(args: Array[String]): Unit = {
    //用循环守卫实现continue效果 条件为真才执行循环体
    //即当i==2或者i==3时,就跳过
    for (i <- 1 to 10 if (i != 2 && i != 3)) {
      println("i=" + i)
    }

    //也可以写成如下形式
    println("================")
    for (i <- 1 to 10 ) {
      if (i != 2 && i != 3){
        println("i=" + i)
      }
    }
  }
}
