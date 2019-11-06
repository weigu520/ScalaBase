package com.briup.bd1903.chapter08.homework

object Exercise04 {
  def main(args: Array[String]): Unit = {
    //type 可以用于给类型取别名
    //    type Myint = Int //给Int取别名Myint
    //    val num: Myint = 888
    //    println("num=" + num)

    println(Suits) //♠,♣,♥,♦
    println(Suits.isRed(Suits.Heart))
    println(Suits.isRed(Suits.Spade))
  }
}

object Suits extends Enumeration {
  type Suits = Value //给Value类型取别名
  val Spade = Value("♠")
  val Club = Value("♣")
  val Heart = Value("♥")
  val Diamond = Value("♦")

  override def toString(): String = {
    Suits.values.mkString(",")
  }

  def isRed(card: Suits) = card == Heart || card == Diamond
}
