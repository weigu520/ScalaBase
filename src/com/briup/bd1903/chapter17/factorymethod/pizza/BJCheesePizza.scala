package com.briup.bd1903.chapter17.factorymethod.pizza

class BJCheesePizza extends Pizza {
  override def prepare(): Unit = {
    this.name = "北京奶酪Pizza"
    println(this.name + "preparing...")
  }
}
