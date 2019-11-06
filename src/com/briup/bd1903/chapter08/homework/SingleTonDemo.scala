package com.briup.bd1903.chapter08.homework

object SingleTonDemo {
  def main(args: Array[String]): Unit = {
    val dog1 = Dog
    val dog2 = Dog
    println(dog1.equals(dog2))
    println(dog1 == dog2)
  }
}

class Dog private() {

}

object Dog {
  var singleDog: Dog = null

  def apply(): Dog = {
    if (singleDog == null) singleDog = new Dog()
    singleDog
  }
}
