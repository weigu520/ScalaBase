package com.briup.bd1903.chapter06.constructor

object ConDemo01 {
  def main(args: Array[String]): Unit = {
    //    val p1 = new PerS("Jack", 20)
    //    println(p1)

    val p2 = new PerS("Tom")
    println(p2)
  }
}

class PerS(inName: String, inAge: Int) {
  var name: String = inName
  var age: Int = inAge

  age += 10

  println("重写了toString方法")

  override def toString: String = {
    "Pers:\t" + "name=" + this.name + "\tage=" + this.age
  }

  println("age=" + age)

  def this(name: String) {
    //辅助构造器必须在第一行显式调用主构造器(可以是直接,也可以是间接)
    this("", 0)
    this.name = name //重新赋值
  }

}
