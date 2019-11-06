package com.briup.bd1903.chapter13

object ControlAbstractApp {
  def main(args: Array[String]): Unit = {
    var x = 10
//    while (x > 0) {
//      x -= 1
//      println("x=" + x)
//    }

    x = 10
    until(x > 0) {
      x -= 1
      println("until x=" + x)
    }
  }

  //我们可以使用控制抽象写出until函数,实现类似的效果
  def until(condition: => Boolean)(block: => Unit): Unit = {
    //类似while循环，递归
    if (condition) {
      block
      //递归调用until
      until(condition)(block)
    }
  }
}
