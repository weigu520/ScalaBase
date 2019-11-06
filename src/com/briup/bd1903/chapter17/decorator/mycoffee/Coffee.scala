package com.briup.bd1903.chapter17.decorator.mycoffee

import com.briup.bd1903.chapter17.decorator.mydecorator.Drink

//在Drink和单品咖啡,做一个缓冲层
//为了扩展
class Coffee extends Drink{
  override def cost(): Float = {
    super.getPrice()
  }
}
