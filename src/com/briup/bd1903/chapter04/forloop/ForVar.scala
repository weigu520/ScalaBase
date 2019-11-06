package com.briup.bd1903.chapter04.forloop

object ForVar {
  def main(args: Array[String]): Unit = {
    //引入变量
    for (i <- 1 to 3; j = 4 - i) {
      print(j + " ")
    }


    for (i <- 1 to 3) {
      val j = 4 - i
      print(j + "")
    }
  }
}
