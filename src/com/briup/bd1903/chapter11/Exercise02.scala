package com.briup.bd1903.chapter11

import scala.collection.mutable.ArrayBuffer

/*
val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
将sentence 中各个字符，通过foldLeft存放到 一个ArrayBuffer中
目的：理解flodLeft的用法
 */
object Exercise02 {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
    val arrayBuffer = new ArrayBuffer[Char]()
    sentence.foldLeft(arrayBuffer)(putArray)
    println("arrayBuffer=" + arrayBuffer)

  }

  def putArray(arr: ArrayBuffer[Char], c: Char): ArrayBuffer[Char] = {
    //将c放入到arr中
    arr.append(c)
    arr
  }
}
