package com.briup.bd1903.chapter04.ifelse

object Exercise03 {
  def main(args: Array[String]): Unit = {
    var sumVal = 9
    val result =
      if(sumVal > 20){
        "结果大于20"
      }
    println(result) //() 即Unit实例
  }
}
