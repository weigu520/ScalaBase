package com.briup.bd1903.chapter08.mytrait

object TraitDemo01 {
  def main(args: Array[String]): Unit = {

  }
}

//trait Serializable extends scala.Any with java.io.Serializable
//在scala中,java的接口都可以当做trait来使用
object T1 extends Serializable {}
