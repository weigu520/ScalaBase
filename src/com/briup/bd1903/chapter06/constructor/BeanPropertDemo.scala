package com.briup.bd1903.chapter06.constructor

import scala.beans.BeanProperty

object BeanPropertDemo {
  def main(args: Array[String]): Unit = {
    val car = new Car
    car.name = "宝马"
    println(car.name)

    //@BeanProperty自动生成的getter/setter方法
    car.setName("奔驰")
    println(car.getName)
  }
}

class Car {
  @BeanProperty var name: String = null
}
