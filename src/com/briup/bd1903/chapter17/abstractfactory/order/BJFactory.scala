package com.briup.bd1903.chapter17.abstractfactory.order

import com.briup.bd1903.chapter17.abstractfactory.pizza.{BJCheesePizza, BJPepperPizza, Pizza}

//实现了抽象工厂的子实现工厂
//如果我们希望订购北京的Pizza就使用该工厂子类
class BJFactory extends AbsFactory {
  override def createPizza(t: String): Pizza = {
    var pizza: Pizza = null
    if (t.equals("cheese")) {
      pizza = new BJCheesePizza
    } else if (t.equals("pepper")) {
      pizza = new BJPepperPizza
    }
    pizza
  }
}
