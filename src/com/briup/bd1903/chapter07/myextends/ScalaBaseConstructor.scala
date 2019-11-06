package com.briup.bd1903.chapter07.myextends

object ScalaBaseConstructor {
  def main(args: Array[String]): Unit = {
    //1.因为scala遵守先构建父类部分extends Person5()
    //2.Person...
    //3.Emp...(Emp5的主构造器)
    //    val emp5 = new Emp5()

    //1.因为scala遵守先构建父类部分extends Person5()
    //2.Person...
    //3.Emp...(Emp5的主构造器)
    //4.Emp 辅助构造器~
//    println("=========================")
//    val emp55 = new Emp5("mary")

    //1.因为scala遵守先构建父类部分extends Person5()
    //2.Person...
    //3.默认的名字
    //4.Emp...(Emp5的主构造器)
    //5.Emp 辅助构造器~
//    val emp555 = new Emp5("smith")

    //1.Person...
    //2.Emp...
    val emp5555 = new Emp5("terry", 11)
    emp5555.showInFo()  //雇员的名字是: terry
  }
}

class Person5(pName: String) {
  var name = pName
  println("Person...")

  def this() {
    this("默认的名字")
    println(name)
  }
}

class Emp5(eName: String, eAge: Int) extends Person5(eName) {
  println("Emp ....")

  //辅助构造器
  def this(name: String) {
    this("eName", 1) // 必须调用主构造器
    this.name = name
    println("Emp 辅助构造器~")
  }

  def showInFo(): Unit = {
    println("雇员的名字是: " + name)
  }
}
