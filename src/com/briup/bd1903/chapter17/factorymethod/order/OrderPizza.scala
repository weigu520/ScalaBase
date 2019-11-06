package com.briup.bd1903.chapter17.factorymethod.order

import com.briup.bd1903.chapter17.factorymethod.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks._

//这里将OrderPizza做成抽象类
abstract class OrderPizza {

  var orderType: String = _
  var pizza: Pizza = _
  breakable {
    do {
      println("请输入pizza的类型 使用工厂方法模式~~")
      orderType = StdIn.readLine()
      pizza = createPizza(orderType)
      if (pizza == null) {
        break()
      }
      this.pizza.prepare()
      this.pizza.bake()
      this.pizza.cut()
      this.pizza.box()
    } while (true)
  }
  //抽象的方法,createPizza(orderType)让子类去实现
  def createPizza(t: String): Pizza

}
