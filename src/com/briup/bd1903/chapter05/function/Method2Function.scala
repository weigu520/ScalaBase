package com.briup.bd1903.chapter05.function

object Method2Function {
  def main(args: Array[String]): Unit = {
    //使用方法
    val dog = new Dog
    println(dog.sum(10, 20))

    //方法转成函数
    val f1 = dog.sum _
    println("f1=" + f1)
    println("f1=" + f1(10, 90))

    //函数,求两个数的和
    val f2 = (n1: Int, n2: Int) => {
      n1 + n2 //函数体
    }
    println("f2="+f2)
    println("f1=" + f2(2, 8))
  }

}

class Dog {
  //方法
  def sum(n1: Int, n2: Int): Int = {
    n1 + n2
  }
}
