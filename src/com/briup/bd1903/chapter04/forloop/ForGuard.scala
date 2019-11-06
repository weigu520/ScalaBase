package com.briup.bd1903.chapter04.forloop

object ForGuard {
  def main(args: Array[String]): Unit = {
    //循环守卫
    for(i <- 1 to 3 if i != 2){
      print(i+" ")
    }
    println()
  }
}
