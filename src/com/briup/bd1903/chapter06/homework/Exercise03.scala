package com.briup.bd1903.chapter06.homework

object Exercise03 {
  def main(args: Array[String]): Unit = {

    //定义一个List集合
    val list = List(1, 2, 3)
    println(list.reverse) //List(3,2,1)
    println((1 to 10).reverse)  //Range()
    for(i <- 1 to 10 reverse){
      println(i)
    }
  }
}
