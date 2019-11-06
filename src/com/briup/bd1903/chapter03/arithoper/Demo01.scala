package com.briup.bd1903.chapter03.arithoper

object Demo01 {
  def main(args: Array[String]): Unit = {

    //除法的使用
    var r1: Int = 10 / 3 //3
    println("r1=" + r1)
    var r2: Double = 10 / 3 //3.0
    println("r2=" + r2)
    var r3: Double = 10.0 / 3 //3.33333
    println("r3=" + r3)
    println("r3=" + r3.formatted("%.2f")) //3.33

    //%的使用
    //1.%的运算的原则: a%b = a- a/b * b
    println(10 % 3) //1
    println(-10 % 3) //-1 -10 % 3 = (-10)-(-3)*3=-10+9=-1
    println(-10 % -3) //-1
    println(10 % -3) //1

    //++和--
    //说明,在scala中没有++和--,而使用+=1和-=1表示
    var num1 = 10
    //num1++错误
    num1 += 1 //替代num1++
    //num1--错误
    num1 -= 1
    println(num1)

  }
}
