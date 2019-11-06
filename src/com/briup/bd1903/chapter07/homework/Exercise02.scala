package com.briup.bd1903.chapter07.homework

import scala.beans.BeanProperty

/*
创建一个Student类，加入可读写的JavaBeans属性name(类型为String)和id(类型为Long)。
有哪些方法被生产？(用javap查看[该指令可以查看.class文件的反编译的方法声明(还可以看到反汇编的代码)]。)
你可以在Scala中调用JavaBeans的getter和setter方法吗？
 */
object Exercise02 {
  def main(args: Array[String]): Unit = {
    println("ok")
  }
}

class Student{
  @BeanProperty var name : String = _
  @BeanProperty var id : Long = _
}