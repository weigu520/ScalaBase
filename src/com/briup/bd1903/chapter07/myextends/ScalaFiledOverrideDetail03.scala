package com.briup.bd1903.chapter07.myextends

object ScalaFiledOverrideDetail03 {
  def main(args: Array[String]): Unit = {

  }
}

//在CF中,有一个抽象的字段(属性)
//1.抽象的字段(属性):就是没有初始化的字段(属性)
//2.当一个类有抽象的字段时,则该类需要标记为abstract
//3.对于抽象的属性在底层 不会生成对应的属性声明,而是生成两个对应的抽象方法(name name_$eq)
abstract class CF {
  var name : String //抽象
//  var age : Int = 10
}

class SubCF extends CF {
  //1.如果在子类中去重写父类的抽象属性,本质是实现了抽象方法
  //2.因此可以写override,也可以不写
  override var name: String = _
//  override var age : Int = 10
}
