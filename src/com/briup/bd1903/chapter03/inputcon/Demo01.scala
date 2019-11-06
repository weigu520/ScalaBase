package com.briup.bd1903.chapter03.inputcon

import scala.io.StdIn

object Demo01 {
  def main(args: Array[String]): Unit = {
    /*
    控制台接收用户信息:姓名,年龄,薪水
     */
    println("请输入姓名:")
    val name = StdIn.readLine()

    println("请输入年龄:")
    val age = StdIn.readInt()

    println("请输入薪水:")
    val salary = StdIn.readDouble()

    printf("用户的信息位 name=%s age=%d sal=%f",name,age,salary)

//    Cat.sayHi()
//    Cat.sayHello()

  }
}
//声明了一个对象(判断对象)
object Cat extends A {
  def sayHi(): Unit = {
    println("小狗汪汪叫~~~")
  }
}

trait A{  //A是特质,等价于java中的interface +  abstract class
  def sayHello(): Unit = {
    println("A sayHello")
  }
}
