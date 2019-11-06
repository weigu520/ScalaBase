package com.briup.bd1903.chapter07.myextends

//1.在scala中,子类继承了父类的所有属性
//2.但是private的属性和方法无法访问

object Extends02 {
  def main(args: Array[String]): Unit = {
    val sub = new Sub()
    sub.sayOk()
//    sub.test200() 编译器不通过
  }
}

//父类
class Base {
  var n1: Int = 1 //public n1() public n1_$eq()
  protected var n2: Int = 2
  private var n3: Int = 3 //private n3() private n3_$eq()

  def test100(): Unit = { //默认是 public test100()
    println("base 100")
  }

  protected def test200(): Unit = { //public
    println("base 200")
  }

  private def test300(): Unit = { //private
    println("base 300")
  }
}

//子类Sub继承了父类Base
class Sub extends Base {
  def sayOk(): Unit = {
    this.n1 = 20  //这里的访问本质this.n1_$eq()
    this.n2 = 40
    println("范围" + this.n1 + this.n2)
  }
}



