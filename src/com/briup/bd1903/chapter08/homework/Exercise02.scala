package com.briup.bd1903.chapter08.homework

object Exercise02 {
  def main(args: Array[String]): Unit = {
    val point = Point(3, 4) //触发apply方法
    println(point)
  }
}

class Point(x: Int = 0, y: Int = 0) {
  var x1 = x
  var y1 = y
}

object Point {
  def apply(x: Int = 0, y: Int = 0): Point = new Point(x, y)
}