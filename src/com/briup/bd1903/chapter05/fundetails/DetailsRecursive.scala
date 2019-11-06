package com.briup.bd1903.chapter05.fundetails

object DetailsRecursive {
  def main(args: Array[String]): Unit = {

  }

  def f1(n: Int): Int = { //错误,递归不能使用类型推断，必须指定返回的数据类型
    if (n <= 0)
      1
    else
      n * f1(n - 1)
  }

//  def f2(n: Int)= { //错误,递归不能使用类型推断，必须指定返回的数据类型
//    if (n <= 0)
//      1
//    else
//      n * f2(n - 1)
//  }

}
