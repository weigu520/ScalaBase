package com.briup.bd1903.chapter11

import scala.collection.mutable

object Exercise03 {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
    val map1 = sentence.foldLeft(Map[Char, Int]())(charCount1)
    println("map1=" + map1)

    //使用可变的Map效率更高
    //创建一个可变Map,作为左折叠的第一个参数
    val map2 = mutable.Map[Char, Int]()
    sentence.foldLeft(map2)(charCount2)
    println("map2=" + map2)
  }

  //不可变的Map
  def charCount1(map: Map[Char, Int], c: Char): Map[Char, Int] = {
    map + (c -> (map.getOrElse(c, 0) + 1))
  }

  //可变Map
  def charCount2(map: mutable.Map[Char, Int], c: Char): mutable.Map[Char, Int] = {
    map += (c -> (map.getOrElse(c, 0) + 1))
  }

}
