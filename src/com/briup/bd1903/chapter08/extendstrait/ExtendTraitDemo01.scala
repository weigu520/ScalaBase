package com.briup.bd1903.chapter08.extendstrait

object ExtendTraitDemo01 {
  def main(args: Array[String]): Unit = {
    println("~~~")
  }
}

//1.LoggedException 继承了Exception
//2.LoggedException特质就可以有Excetion的功能
trait LoggedException extends Exception {
  def log(): Unit = {
    println(getMessage)
  }
}

//UnhappyException就是Exception的子类
class UnhappyException extends LoggedException {
  override def getMessage = "错误消息"
}
//如果混入该特质的类，已经继承了另一个类(A类)，则要求A类是特质超类的子类，否则就会出现了多继承现象，发生错误
class UnhappyException2 extends IndexOutOfBoundsException with LoggedException {
  override def getMessage = "错误消息"
}
//下面这种方式错误:Throwable不是Exception的子类
//class UnhappyException3 extends Throwable with LoggedException {
//  override def getMessage = "错误消息"
//}