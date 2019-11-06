package com.briup.bd1903.chapter04.forloop

object ForUtilDemo02 {
  def main(args: Array[String]): Unit = {
    //输出10句"hell,scala"
    val start = 1
    val end = 10
    //循环的范围是start到end-1
    for(i <- start until end){
      println("hello,scala"+i)
    }
  }
}
