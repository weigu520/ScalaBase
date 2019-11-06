package com.briup.bd1903.chapter17.decorator.mydecorator

import com.briup.bd1903.chapter17.decorator.mycoffee.{Decaf, Espresso}

object CoffeeBar {
  def main(args: Array[String]): Unit = {
    println("咖啡bar...")

    val order1: Drink = new Decaf

    println("order1 price:" + order1.cost())
    println("order1 description:" + order1.getDescription())

    println("-----------------------------------------------")

    //点一份Espresso,加入一份Milk和两份Chocolate
    var order2: Drink = new Espresso
    order2 = new Milk(order2)

    order2 = new Chocolate(order2)
    order2 = new Chocolate(order2)

    order2 = new NewMilk(order2)

    println("order2 price:" + order2.cost())
    println("order2 description:" + order2.getDescription())

  }
}
