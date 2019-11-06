package com.briup.bd1903.chapter17.decorator.mydecorator

//装饰者
class Decorator extends Drink {

  //被装饰的对象Drink
  //可以是单品咖啡,也可以是单品咖啡+调料的组合
  private var obj: Drink = null

  def this(obj: Drink) {
    this
    this.obj = obj
  }

  //计算成本,实现了cost方法
  override def cost(): Float = {
    super.getPrice() + obj.cost()
  }

  //获取信息时,也需要递归获取
  override def getDescription(): String = {
    super.getDescription() + "&&" + obj.getDescription()
  }

}
