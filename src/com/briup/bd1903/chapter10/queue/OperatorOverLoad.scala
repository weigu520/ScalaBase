package com.briup.bd1903.chapter10.queue

object OperatorOverLoad {
  def main(args: Array[String]): Unit = {
    val cat = new Cat
    cat + 10
    cat + 10
    cat.+(10)
    println("cat.age=" + cat.age)
  }
}

class Cat {
  var age = 0

  def +(n: Int): Unit = {
    this.age += n
  }
}
