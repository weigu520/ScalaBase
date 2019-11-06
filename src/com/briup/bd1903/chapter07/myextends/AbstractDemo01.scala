package com.briup.bd1903.chapter07.myextends

object AbstractDemo01 {
  def main(args: Array[String]): Unit = {

  }
}

abstract class Animal {
  var name : String //抽象属性
  var age : Int     //抽象属性
  var color : String = "black"  //普通属性
  def cry()       //抽象方法,不能写abstract
}
