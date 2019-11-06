package com.briup.bd1903.chapter07.myextends

object ScalaFiledOverride {
  def main(args: Array[String]): Unit = {
    val obj1: AA = new BB
    val obj2: BB = new BB
    //obj1.age => obj1.age()  //动态绑定机制
    //obj2.age => obj2.age()
    println("obj1.age" + obj1.age + "\tobj2.age" + obj2.age)
  }
}

class AA {
  val age: Int = 10 //会生成public age()
}

class BB extends AA {
  override val age: Int = 20 //会生成public age()
}
