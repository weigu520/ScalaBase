package com.briup.bd1903.chapter08.selftype

object SelfTypeDemo {
  def main(args: Array[String]): Unit = {

  }
}

trait Logger {
  this: Exception =>
  def log: Unit = {
    println(getMessage)
  }
}
//class Console extends Logger{} 错误
class Console extends Exception with Logger{}