package com.briup.bd1903.chapter09

object ImplicitDemo02 {
  //编写一个隐式函数,拓展Mysql功能
  implicit def addDelete(mysql: MySQL): DB = {
    new DB
  }

  def main(args: Array[String]): Unit = {

    val mySQL = new MySQL
    mySQL.insert
    mySQL.delete  //分析addDelete(mySQL).delete()
  }
}

class MySQL {
  def insert: Unit = {
    println("insert")
  }
}

class DB {
  def delete: Unit = {
    println("delete")
  }
}