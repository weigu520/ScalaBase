package com.briup.bd1903.chapter17.singleton

object TestSingleTon2 {
  def main(args: Array[String]): Unit = {
    val i1 = SingleTon2.getInstance
    val i2 = SingleTon2.getInstance
    if(i1 == i2) println("是同一个对象")
  }
}
class SingleTon2 private() {}

//饿汉式
object SingleTon2 {
  private val s: SingleTon2 =new SingleTon2
  def getInstance = {
   s
  }
}