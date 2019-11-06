package com.briup.bd1903.chapter17.abstractfactory.order

import com.briup.bd1903.chapter17.abstractfactory.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks._

//OrderPizza,当使用抽象工厂模式后
//接收子工厂实例,根据该工厂的创建要求去实例化
class OrderPizza {

  var absFactory: AbsFactory = _

  def this(absFactory: AbsFactory) { //多态
    this
    breakable {
      var orderType: String = null
      var pizza: Pizza = null
      do {
        println("请输入pizza的类型 ,使用抽象工厂模式...")
        orderType = StdIn.readLine()
        //使用简单工厂模式来创建对象.
        pizza = absFactory.createPizza(orderType)
        if (pizza == null) {
          break()
        }
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
      } while (true)
    }
  }

}
