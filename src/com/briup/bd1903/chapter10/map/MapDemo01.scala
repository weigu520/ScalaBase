package com.briup.bd1903.chapter10.map

import scala.collection.mutable

object MapDemo01 {
  def main(args: Array[String]): Unit = {
    //默认Map是immutable.Map
    //key-value类型支持Any
    //在Map底层每对key-value是Tuple2:"Alice" -> 10
    val map1 = Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    println(map1)

    val map2 = mutable.Map("Alice" -> 10, "Bob" -> 20, "Kotlin" -> "北京")
    println(map2)

    //    方式3-创建空的映射
    val map3 = mutable.HashMap
    println(map3)

    //    方式4-对偶元组
    //    即创建包含键值对的二元组， 和第一种方式等价，只是形式上不同而已。
    //    对偶元组 就是只含有两个数据的元组。
    val map4 = mutable.Map(("A", 1), ("B", 2), ("C", 3), ("D", 30))
    println("map4=" + map4)
    println(map4("A"))

    val map5 = mutable.Map(("A", 1), ("B", "北京"), ("C", 3))
    map5("AA") = 20
    println(map5)


    val map6 = mutable.Map(("A", 1), ("B", "北京"), ("C", 3))
    map6 += ("D" -> 4)
    map6 += ("B" -> 50, "E" -> 20)
    println(map6)

    for ((k, v) <- map6) println(k + "=" + v)

    for (k <- map6.keys) println(k) //key
    for (v <- map6.values) println(v) //value

    //这样取出方式kv类型是Tuple2
    for (kv <- map6) println(kv) //(k, v)
    for (v <- map6) println("v=" + v._1)
    for (v <- map6) println("v=" + v._2)
  }
}
