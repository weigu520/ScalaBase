package com.briup.bd1903.chapter12

object MatchFor {
  def main(args: Array[String]): Unit = {
    val map = Map("A" -> 1, "B" -> 0, "C" -> 3)
    for ((k, v) <- map) {
      println(k + " -> " + v)
    }
    //说明v==0输出
    for ((k, 0) <- map) {
      println(k + " --> " + 0)
    }
    //说明v>0输出,守卫,更加灵活
    for ((k, v) <- map if v > 0) {
      println(k + " ---> " + v)
    }

  }
}
