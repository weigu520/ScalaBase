package com.briup.bd1903.chapter07.myextends

object MethodOverride01 {
  def main(args: Array[String]): Unit = {
    val emp = new Emp
    emp.printName()
  }
}

class Person2 {
  var name: String = "tom"

  def printName() {
    println("Person printName() " + name)
  }
  def sayHi(): Unit = {
    println("sayHi~~~")
  }
}

class Emp extends Person2 {
  //这里需要显式的使用override
  override def printName() {
    println("Emp printName() " + name)
    //在子类中需要去调用父类的重写方法,使用super
    super.printName()
    sayHi()
  }
}

