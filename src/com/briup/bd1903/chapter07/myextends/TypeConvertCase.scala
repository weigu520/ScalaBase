package com.briup.bd1903.chapter07.myextends

object TypeConvertCase {
  def main(args: Array[String]): Unit = {
    val student4 = new Student4
    val emp4 = new Emp4
    test(student4)
    test(emp4)
  }

  //写了一个参数多态代码
  //因为在oop父类的引用可以接收所有子类的引用,多态(参数多态)
  def test(p: Person4): Unit = {
    //使用scala中类型检查和转换
    if (p.isInstanceOf[Emp4]) { //判断
      //p.asInstanceOf[Emp4]对p的类型没有任何改变,而是返回的是Emp4类型
      p.asInstanceOf[Emp4].showInFo
    } else if (p.isInstanceOf[Student4]) {
      p.asInstanceOf[Student4].cry
    } else {
      println("转换失败")
    }
  }

}

class Person4 {
  def printName: Unit = {
    println("Person4 printName")
  }

  def sayOk: Unit = {
    println("Person4 sayOk")
  }
}

class Student4 extends Person4 {
  val stuId = 100

  override def printName: Unit = {
    println("Student4 printName")
  }

  def cry: Unit = {
    println("学生的ID= " + this.stuId)
  }
}

class Emp4 extends Person4 {
  val empId = 100

  override def printName: Unit = {
    println("Emp4 printName")
  }

  def showInFo: Unit = {
    println("雇员的ID= " + this.empId)
  }
}
