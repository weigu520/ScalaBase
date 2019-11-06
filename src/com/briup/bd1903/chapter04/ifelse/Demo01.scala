package com.briup.bd1903.chapter04.ifelse

import scala.io.StdIn

object Demo01 {
  def main(args: Array[String]): Unit = {
    println("请输入年龄")
    val age = StdIn.readInt()
    if(age > 18){
      println("age > 18")
    }

    //如何查看某个包下包含的内容
    //1.比如查看scala.io包有什么内容
    //2.将光标放在io上,在ctrl+b
    scala.io.StdIn

  }
}
