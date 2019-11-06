package com.briup.bd1903.chapter17.singleton

object TestSingleTon {
  def main(args: Array[String]): Unit = {
    val i1 = SingleTon.getInstance
    val i2 = SingleTon.getInstance
    if(i1 == i2) println("是同一个对象")
  }
}

class SingleTon private() {}

//懒汉式
object SingleTon {
  private var s: SingleTon =null
  def getInstance = {
    if(s == null) {
      s = new SingleTon
    }
    s
  }
}