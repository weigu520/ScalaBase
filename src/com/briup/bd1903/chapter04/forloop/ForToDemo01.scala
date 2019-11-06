package com.briup.bd1903.chapter04.forloop

object ForToDemo01 {
  def main(args: Array[String]): Unit = {
    //输出10句"hello,scala"
    val start = 1
    val end = 10
    //1.start 从哪个数开始循环
    //2.to 关键字
    //3.end 循环结束的值
    //4.start to end 表示前后闭合
    for (i <- start to end) {
      println("hello,scala" + i)
    }

    //for这种推导式,也可以直接对集合进行遍历
    var list = List("hello", 10, 30, 't')
    for (item <- list) {
      println("item=" + item)
    }
  }
}
