package com.briup.bd1903.chapter08.mytrait

object TraitDemo03 {
  def main(args: Array[String]): Unit = {
    //创建sheep
    val sheep = new Sheep
    sheep.sayHi()
    sheep.sayHello
  }
}

//当一个trait有抽象方法和非抽象方法时
//1.一个trait在底层对应两个Trait03.class接口
//2.还对应Trait03$class.class Trait03$class抽象类

trait Trait03 {
  //抽象方法
  def sayHi()

  //普通方法
  def sayHello: Unit = {
    println("trait sayHello~~~")
  }
}

//当trait有接口和抽象类时
//1.class Sheep extends Trait03在底层对应
//2.class Sheep implements Trait03
//3.当在Sheep类中要使用Trait03的实现方法,就通过Trait03$class调用

class Sheep extends Trait03 {
  override def sayHi(): Unit = {
    println("小羊 sayHi~~~")
  }
}
