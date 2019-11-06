package com.briup.bd1903.chapter09

object ImplicitClassDemo {
  def main(args: Array[String]): Unit = {

    //Db是一个隐式类,当我们在该隐式类的作用域范围,创建Mysql实例,该隐式类会生效
    implicit class Db(val m: Mysql) { //ImplicitClassDemo$Db$1
      def addS(): String = {
        m + "scala"
      }
    }

    val mysql = new Mysql
    mysql.sayOk
    mysql.addS()
  }
}

class Mysql {
  def sayOk: Unit = {
    println("sayOk")
  }
}
