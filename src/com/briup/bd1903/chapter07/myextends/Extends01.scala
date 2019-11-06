package com.briup.bd1903.chapter07.myextends

object Extends01 {
  def main(args: Array[String]): Unit = {
    val student = new Student
    student.name = "Jack" //调用了student.name()[调用到从Person继承的name()]
    student.studying()
    student.showInfo()
  }
}

//Person类
class Person {
  var name: String = _
  var age: Int = _

  def showInfo(): Unit = {
    println("学生信息如下：")
    println("名字：" + this.name)
  }
}

//Student类继承Person类
class Student extends Person {
  def studying(): Unit = {
    //这里可以使用父类的属性
    println(this.name + "学习 scala中....")
  }
}
