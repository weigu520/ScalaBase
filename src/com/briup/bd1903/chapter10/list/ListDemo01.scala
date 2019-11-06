package com.briup.bd1903.chapter10.list

object ListDemo01 {
  def main(args: Array[String]): Unit = {

    //在默认情况下List是scala.collection.immutable.List,即不可变
    //在scala中,List就是不可变的,如需要使用可变的List,则使用ListBuffer
    //List在package object scala做了val List=scala.collection.immutable.List
    val list = List(1, 2, 3, "hello") //直接分配元素
    println(list)

    val nullList = Nil //创建空集合val Nil = scala.collection.immutable.Nil //List()空集合
    println(nullList)

    //访问List元素
    val value1 = list(0) //索引index0
    println("value1= " + value1)

    //通过:+和+:给List追加元素,本身的集合没有变化
    //:+运算符在列表最后增加数据
    val list1 = list :+ 4
    //+:运算符在列表最前增加数据
    val list2 = 0 +: list
    println(list1)
    println(list2)

    //::符号的使用
    //1.List()
    //2.list放进List()=>List(List(1, 2, 3, "hello"))
    //3.6放进去List(6,List(1, 2, 3, "hello"))
    //4.依次放进去
    val list3 = 4 :: 5 :: 6 :: list :: Nil
    println("list3=" + list3)

    //:::符号的使用,左右边必须为集合
    //1.List()
    //2.list扁平化放进去List(1, 2, 3, "hello")
    //2.6放进去List(6,1, 2, 3, "hello")
    val list4 = 4 :: 5 :: 6 :: list ::: Nil
    println("list4=" +list4)
  }
}
