package com.briup.bd1903.chapter17.abstractfactory.order

object PizzaStore {
  def main(args: Array[String]): Unit = {
    new OrderPizza(new BJFactory)
  }
}
