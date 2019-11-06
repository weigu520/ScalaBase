package com.briup.bd1903.chapter08.mixin

object MixInDemo01 {
  def main(args: Array[String]): Unit = {
    //在不修改类的定义继承,让他们可以使用trait方法
    val oracleDB = new OracleDB with Operate
    oracleDB.insert(100)

    val mysql = new MYSQL with Operate
    mysql.insert(200)

    //如果一个抽象类有抽象方法,如何动态混入特质
    val mysql2 = new MYSQL2 with Operate {
      override def say(): Unit = {
        println("say~~~")
      }
    }
    mysql2.insert(300)
    mysql2.say()
  }
}

trait Operate {
  def insert(id: Int): Unit = {
    println("插入数据= " + id)
  }
}

class OracleDB {}

abstract class MYSQL {}

abstract class MYSQL2 {
  def say()
}