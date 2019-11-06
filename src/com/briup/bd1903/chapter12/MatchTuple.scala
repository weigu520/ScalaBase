package com.briup.bd1903.chapter12

object MatchTuple {
  def main(args: Array[String]): Unit = {
    // 元组匹配
    //如果要匹配 (10, 30) 这样任意两个元素的对偶元组，应该如何写?
    for (pair <- Array((0, 1), (1, 0), (1, 1), (1, 0, 2), (10, 30))) {
      val result = pair match { //
        case (0, _) => "0 ..." //
        case (y, 0) => y //
        case (y, x) => (x, y) //
        case _ => "other" //.
      }
      println(result)
    }
  }
}
