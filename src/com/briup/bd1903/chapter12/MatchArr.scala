package com.briup.bd1903.chapter12

import scala.collection.mutable.ArrayBuffer

object MatchArr {
  def main(args: Array[String]): Unit = {
//    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0),
//      Array(1, 1, 0), Array(1, 1, 0, 1))) {
//      val result = arr match {
//        case Array(0) => "0"
//        case Array(x, y) => x + "=" + y
//        case Array(0, _*) => "以0开头和数组"
//        case _ => "什么集合都不是"
//      }
//      println("result = " + result)
//    }
    //给一个数组集合,如果该数组是Array(10,20),请使用模式匹配,返回Array(20,10)
    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1), Array(1, 1, 0, 1))) {
      val result = arr match {
        case Array(x, y) => ArrayBuffer(y, x)
        case _ => "不处理"
      }
      println("result = " + result)
    }


  }
}
