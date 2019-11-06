package com.briup.bd1903.chapter17.decorator.mydecorator

class NewMilk(obj: Drink) extends Decorator(obj){
  super.setDescription("新式Milk")
  super.setPrice(4.0f)
}
