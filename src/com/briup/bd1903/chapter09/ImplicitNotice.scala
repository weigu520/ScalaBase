package com.briup.bd1903.chapter09

object ImplicitNotice {
  def main(args: Array[String]): Unit = {
    //1.隐式转换不能二义性
    //2.隐式转换不能嵌套使用
    implicit def f1(d: Double): Int = {
      d.toInt
//      val errorNum: Int = 2.3 //底层f1$1(2.3)对应的就是f1函数,就会形成递归调用
    }

    val num: Int = 1.1
  }
}
