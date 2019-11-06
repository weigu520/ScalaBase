package com.briup.bd1903.chapter17.decorator.mydecorator

class Chocolate(obj: Drink) extends Decorator(obj){
  super.setDescription("Chocolate")
  super.setPrice(3.0f)
}
