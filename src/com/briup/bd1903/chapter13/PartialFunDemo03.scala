package com.briup.bd1903.chapter13

object PartialFunDemo03 {

  def main(args: Array[String]): Unit = {

    implicit def f1(n: Double): Int = {
      n.toInt
    }
    //将前面的偏函数简写
    def f2: PartialFunction[Any, Int] = {
      case i: Int => i + 1 // case语句可以自动转换为偏函数
      case j: Double => j * 2
    }
    val list = List(1, 2, 3, 4, 1.2, 2.4, "ABC")
    val list1 = list.collect(f2)
    println(list1)

    //第二种简写方式
    val list2 = list.collect {
      case i: Int => i + 1
      case j: Double => (j * 2).toInt
    }
    println(list2)
  }
}
