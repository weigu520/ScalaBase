package com.briup.bd1903.chapter11

object ViewDemo01 {
  def main(args: Array[String]): Unit = {

    //如果这个数,逆序后和原来数相等,就返回true,否则返回false
    def eq(i: Int): Boolean = {
      println("eq")
      i.toString.equals(i.toString.reverse)
    }

    //说明: 没有使用view
    val viewSquares1 = (1 to 100).filter(eq)
    println(viewSquares1)
    //for (x <- viewSquares1) {}
    //使用view,如果对集合进行map.filter,reduce,fold...并不希望立即执行,而是在使用到结果才执行,则可以使用view
    val viewSquares2 = (1 to 100)
      .view
      .filter(eq)
    println(viewSquares2)
    //遍历
    for (item <- viewSquares2) {
      println("item=" + item)
    }
  }
}
