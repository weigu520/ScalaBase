package com.briup.bd1903.chapter17.abstractfactory.order

import com.briup.bd1903.chapter17.abstractfactory.pizza.Pizza

trait AbsFactory {
  //一个抽象方法
  def  createPizza(t : String ): Pizza
}
