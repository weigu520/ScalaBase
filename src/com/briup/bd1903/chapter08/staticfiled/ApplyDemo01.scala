package com.briup.bd1903.chapter08.staticfiled

object ApplyDemo01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    println(list)
    
    val pig1 = new Pig("小花")

    //使用apply方法创建对象
    val pig2 = Pig("小黑猪") //自动触发 apply(pName: String): Pig方法
    val pig3 = Pig()  //自动触发apply(): Pig方法

    println(pig2.name)
    println(pig3.name)
  }
}

//案例演示apply方法
class Pig(pName: String) {
  var name: String = pName
}

object Pig {
  //编写一个apply
  def apply(pName: String): Pig = new Pig(pName)

  def apply(): Pig = new Pig("匿名猪")
}