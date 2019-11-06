package com.briup.bd1903.chapter07.myextends

object AbstractClassDetail01 {
  def main(args: Array[String]): Unit = {
    //默认情况下,一个抽象类是不能实例化的,但是你实例化时,动态的实现了所有抽象方法
    val animal03 = new Animal03 {
      override def sayHello(): Unit = {
        println("匿名子类")
      }
      override var food: String = _
    }
  }
}

abstract class Animal02 {
  def sayHi(): Unit = {
    println("抽象类可以没有abstract方法")
  }
}

abstract class Animal03 {
  var food : String

  def sayHello()
}

class Cat extends Animal03{
  override var food: String = _

  override def sayHello(): Unit = {
    println("小狗汪汪叫")
  }
}
