package com.briup.bd1903.chapter09

//1.当在程序中,同时有隐式值,默认值,传值
//2.编译器的优先级为传值>隐式值>默认值
//3.在隐式值匹配时,不能有二义性
//4.如果隐式值,默认值,传值一个都没有,就会报错
object ImplicitValueDemo04 {
  def main(args: Array[String]): Unit = {
    implicit val name1: String = "scala"
//    implicit val name2: String = "world"

    def hello(implicit content: String = "jack"): Unit = {
      println("Hello" + content)
    }

    hello //报错不能有两个隐式String

    //同时有implicit值和默认值,implicit优先级高
//    implicit val name3: String = "scala"

    def hello2(implicit content: String = "jack"): Unit = {
      println("Hello2" + content)
    }

//    hello2 //Hello2scala

//    implicit val name: Int = 10

    def hello3(implicit content: String = "jack"): Unit = {
      println("Hello3" + content)
    }

//    hello3 //Hello3jack

//    implicit val name4: Int = 10
    //当没有隐式值,没有默认值,又没有传值,报错
    def hello4(implicit content: String): Unit = {
      println("Hello4" + content)
    }

//    hello4 //报错

  }
}
