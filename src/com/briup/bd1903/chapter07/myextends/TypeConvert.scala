package com.briup.bd1903.chapter07.myextends

object TypeConvert {
  def main(args: Array[String]): Unit = {

    //classOf的使用,可以得到类名
    println(classOf[String])
    val s = "king"
    println(s.getClass.getName) //使用反射机制

    //isInstanceOf asInstanceOf
    var p1 = new Person3
    var emp3 = new Emp3
    //将子类的引用给父类(向上转型,自动)
    p1 = emp3
    //将父类的引用重新转成子类引用(多态),向下转型
    var emp2 = p1.asInstanceOf[Emp3]
    emp2.sayHello
  }
}

class Person3 {
  var name: String = "tom"

  def printName() {
    println("Person printName() " + name)
  }

  def sayHi(): Unit = {
    println("sayHi~~~")
  }
}

class Emp3 extends Person3 {
  //这里需要显式的使用override
  override def printName() {
    println("Emp printName() " + name)
    //在子类中需要去调用父类的重写方法,使用super
    super.printName()
    sayHi()
  }

  def sayHello: Unit = {
    println("sayHello~~~")
  }
}
