package com.briup.bd1903.chapter07.visit

object Testvisit {
  def main(args: Array[String]): Unit = {
    val c = new Clerk()
    c.showInfo()
    Clerk.test(c)

    //创建一个Person对象
    val p1 = new Person
    println(p1.name)
  }
}

//类
class Clerk {
  var name: String = "jack"
  var job: String = "大数据工程师" //从底层看是private的属性,但底层会生成相应的get/set方法提供外界访问
  protected var age = 10 //只能子类访问
  private var sal: Double = 9999.9

  def showInfo(): Unit = {
    //在本类可以使用私有的
    println(" name " + name + " sal= " + sal)
  }
}

//当一个文件中出现了class Clerk 和 object Clerk
//1.class Clerk 称为伴生类
//2.object Clerk 为伴生对象
//3.因为scala设计者将static去掉了,设计了伴生类和伴生对象的概念
//4.将非静态的内容放在伴生类中,将静态的内容放在伴生对象中
//5.
object Clerk {
  def test(c: Clerk): Unit = {
    //这里体现出在伴生对象中，可以访问c.sal
    println("test() name=" + c.name + " sal= " + c.sal)
  }
}

class Person {
  //这里我们增加一个包访问权限
  //下面private[visit] 1.仍然是私有访问权限 2.在visit包(包括子包)下也可以使用name属性,相当于扩大了访问范围
  private[visit] val name = "Jack"
//  protected[visit] val name1 = "Jack"
}
