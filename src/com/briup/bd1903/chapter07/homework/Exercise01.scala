package com.briup.bd1903.chapter07.homework

/*
编写一个Time类，加入只读属性hours和minutes，
和一个检查某一时刻是否早于另一时刻的方法before(other:Time):Boolean。
Time对象应该以new Time(hrs,min)方式构建。
 */
object Exercise01 {
  def main(args: Array[String]): Unit = {
    val cur = new Time(10, 10)
    val other = new Time(10, 20)
    println(cur.before(other)) //true
  }
}

class Time(hrs: Int, min: Int) {
  val hours: Int = hrs
  val minutes: Int = min

  def before(other: Time): Boolean = {
    if (hours < other.hours) {
      true
    } else if (hours > other.hours) {
      false
    } else {
      if (minutes < other.minutes) true else false
    }
  }


}
