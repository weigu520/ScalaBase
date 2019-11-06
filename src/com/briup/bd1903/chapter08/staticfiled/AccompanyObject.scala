package com.briup.bd1903.chapter08.staticfiled

object AccompanyObject {
  def main(args: Array[String]): Unit = {
    println(ScalaPerson.sex) //true 在底层等价于ScalaPerson$.MODULE$.sex()
    ScalaPerson.sayHi() //在底层等价于ScalaPerson$.MODULE$.sayHi()
  }
}

//1.当在同一个文件中有class ScalaPerson object ScalaPerson
//2.称class ScalaPerson为伴生类,将非静态的内容写到该类中
//3.称object ScalaPerson为伴生对象,将静态的内容写到该对象(类)中
//4.class ScalaPerson编译后底层生成ScalaPerson类 ScalaPerson.class
//5.object ScalaPerson编译后底层生成ScalaPerson$类 ScalaPerson$.class
//6.对于伴生对象的内容,可以直接通过ScalaPerson.属性或者方法

//伴生类
class ScalaPerson {
  var name: String = _
}

//伴生对象
object ScalaPerson {
  var sex: Boolean = true

  def sayHi(): Unit = {
    println("object ScalaPerson sayHi~~~")
  }
}
