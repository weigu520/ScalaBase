package com.briup.bd1903.chapter06.dogcase

object DogCaseTest {
  def main(args: Array[String]): Unit = {
    /*
    编写一个Dog类，包含name(String)、age(Int)、weight(Double)属性
    类中声明一个say方法，返回String类型，方法返回信息中包含所有属性值。
    在另一个TestDog类中的main方法中，创建Dog对象，并访问say方法和所有属性，将调用结果打印输出。
     */
    val dog = new MyDog
    dog.name = "tomcat"
    dog.age = 2
    dog.weight = 3.0
    println(dog.say())
  }
}

class MyDog {
  var name: String = ""
  var age: Int = 0
  var weight: Double = 0.0

  def say(): String = {
    "小狗的信息如下: name=" + this.name + "\t age=" + this.age + "\t weight=" + this.weight
  }

}
