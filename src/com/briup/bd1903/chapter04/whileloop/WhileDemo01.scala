package com.briup.bd1903.chapter04.whileloop

object WhileDemo01 {
  def main(args: Array[String]): Unit = {
    //输出10句"hello,scala"
    //循环变量
    var  i = 0
    while (i < 10 /*循环条件*/){
      printf("hello,scala" + i) //循环体
      //循环遍历迭代
      i += 1
    }
  }
}
