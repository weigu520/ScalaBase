package com.briup.bd1903.chapter06.oop

object CreateObject {
  def main(args: Array[String]): Unit = {
    val emp = new Emp //emp类型就是Emp
    //如果将子类对象交给父类引用,这时需要指明类型
    val emp2: Person3 = new Emp
  }
}
class Person3{}

class Emp extends Person3{}
