package com.briup.bd1903.chapter04.ifelse

object Exercise02 {
  def main(args: Array[String]): Unit = {
    //求ax2+bx+c=0方程的根。a,b,c分别为函数的参数，如果：b2-4ac>0，则有两个解；
    //b2-4ac=0，则有一个解；b2-4ac<0，则无解； [a=3 b=100 c=6]
    //提示1：x1=(-b+sqrt(b2-4ac))/2a
    //               X2=(-b-sqrt(b2-4ac))/2a
    //提示2：sqrt(num)  在 scala 包中(默认引入的) 的math 的包对象有很多方法直接可用.
    val a = 3
    val b = 100
    val c = 6
    val m = b * b - 4 * a * c
    var x1 = 0.0
    var x2 = 0.0
    if (m > 0) {
      x1 = (-b + math.sqrt(m)) / 2 * a
      x2 = (-b - math.sqrt(m)) / 2 * a
    } else if (m == 0) {
      x1 = (-b + math.sqrt(m)) / 2 * a
    }else {
      println("无解")
    }
  }
}
