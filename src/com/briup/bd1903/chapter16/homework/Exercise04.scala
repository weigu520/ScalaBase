package com.briup.bd1903.chapter16.homework

import scala.math._

object Exercise04 {
  def main(args: Array[String]): Unit = {
    val h = compose(f,g)
    println(h(1) + " " + h(0))
  }

  /*
  编写一个compose函数，将两个类型为Double=>Option[Double]的函数组合在一起，产生另一个同样类型的函数。如果其中一个函数返回None，则组合函数也应返回None。例如：
  def f(x : Double) = if ( x >= 0) Some(sqrt(x)) else None
  def g(x : Double) = if ( x != 1) Some( 1 / ( x - 1)) else None
  val h = compose(f,g)
  h(2)将得到Some(1)，而h(1)和h(0)将得到None
   */
  def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None

  def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None

  def compose(f: Double => Option[Double], g: Double => Option[Double]) = {
    (x: Double) => {
      if (f(x) == None || g(x) == None) None
      else g(x)
    }
  }

}
