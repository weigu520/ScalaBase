package com.briup.bd1903.chapter17.abstractfactory.pizza

class BJPepperPizza extends Pizza {
  override def prepare(): Unit = {
    this.name = "北京胡椒Pizza"
    println(this.name + "preparing...")
  }
}
