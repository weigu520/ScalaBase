package com.briup.bd1903.chapter11

object OperatorDemo {
  def main(args: Array[String]): Unit = {
    val monster = Monster()
    monster.+(10)
    monster + 10
    monster.++
    println(monster++)
    !monster
    println(monster.money)
  }
}

class Monster {
  var money: Int = 0

  def +(n: Int): Unit = {
    this.money += n
  }

  def ++() = {
    this.money += 1
  }

  def unary_!()= {
    this.money = -this.money
  }

}

object Monster {
  def apply(): Monster = new Monster()
}