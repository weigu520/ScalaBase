package com.briup.bd1903.chapter12

object CaseClassDemo02 {
  def main(args: Array[String]): Unit = {
    //使用样例类方式进行对象匹配简洁性
    for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
      val result = amt match {
        case Dollar(v) => "$" + v
        case Currency(v, u) => v + " " + u
        case NoAmount => ""
      }
      println(amt + ": " + result)
    }
  }
}
