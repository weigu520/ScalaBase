package com.briup.bd1903.chapter06.method

object MethodDemo02 {
  def main(args: Array[String]): Unit = {
    /*
    编写类(MethodExec)，编程一个方法，方法不需要参数，在方法中打印一个10*8 的矩形，在main方法中调用该方法。
     */
    val m = new MethodExec
    m.printRect()
    /*
    修改上一个程序，编写一个方法中，方法不需要参数，计算该矩形的面积，并将其作为方法返回值。
    在main方法中调用该方法，接收返回的面积值并打印(结果保留小数点2位)
    长宽为属性
     */
    m.width = 2.1
    m.len = 3.4
    println("面积等于=" + m.area())
  }
}

class MethodExec {
  //属性
  var len = 0.0
  var width = 0.0

  def area(): Double = {
    return (this.len * this.width).formatted("%.2f").toDouble
  }

  def printRect(): Unit = {
    for (i <- 0 until 10) {
      for (j <- 0 until 8) {
        print("*")
      }
      println()
    }
  }
}
