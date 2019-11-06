package com.briup.bd1903.chapter05.myexception

object ThrowsComment {
  def main(args: Array[String]): Unit = {
    f()
  }

  @throws(classOf[NumberFormatException]) //等同于NumberFormatException.class
  def f() = {
    "abc".toInt
  }

}
