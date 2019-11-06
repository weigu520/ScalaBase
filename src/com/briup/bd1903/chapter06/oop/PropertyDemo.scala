package com.briup.bd1903.chapter06.oop

object PropertyDemo {
  def main(args: Array[String]): Unit = {
//    val p = new Person
//    println(p.name)
//    println(p.address)
    val a = new A
    println(a.var1)
    println(a.var2)
    println(a.var3)
    println(a.var4)
  }
}

class Person {
  var age: Int = 10
  var sal = 8090.9
  var name = null //name是Null类型
  var address: String = null  //address是String类型

}

class A{
  var var1:String= _  //null
  var var2:Byte= _  //0
  var var3:Float= _ //0.0
  var var4:Boolean= _ //false
}
