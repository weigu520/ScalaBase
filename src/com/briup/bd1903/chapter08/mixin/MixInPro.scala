package com.briup.bd1903.chapter08.mixin

object MixInPro {
  def main(args: Array[String]): Unit = {
    val mySQL6 = new MySQL6 with DB6 {
      override var sal: Int = _
    }
    println(mySQL6.opertype)
  }
}

trait Operate6 {
  var opertype: String

  def insert()
}


trait DB6 extends Operate6 {

  var sal: Int
  var opertype: String = "insert"

  def insert(): Unit = {
  }
}

class MySQL6 {}

