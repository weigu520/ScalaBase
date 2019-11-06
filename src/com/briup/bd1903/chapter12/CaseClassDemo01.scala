package com.briup.bd1903.chapter12

object CaseClassDemo01 {
  def main(args: Array[String]): Unit = {
    println("湖人总冠军~~~")
  }
}

abstract class Amount

case class Dollar(value: Double) extends Amount

case class Currency(value: Double, unit: String) extends Amount

case object NoAmount extends Amount