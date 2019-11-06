package com.briup.bd1903.chapter17.decorator.mydecorator

class Milk(obj: Drink) extends Decorator(obj){
  super.setDescription("Milk")
  super.setPrice(2.0f)
}
