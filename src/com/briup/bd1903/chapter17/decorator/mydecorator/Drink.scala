package com.briup.bd1903.chapter17.decorator.mydecorator

abstract class Drink {

  var description = ""
  private var price = 0.0f

  def setDescription(description: String) = {
    this.description = description
  }

  def setPrice(price: Float) = {
    this.price = price
  }

  def getDescription(): String = {
    description + "价格: " + this.getPrice()
  }

  def getPrice(): Float = {
    price
  }

  //计算成本的方法做成一个抽象方法cost
  def cost(): Float
}
