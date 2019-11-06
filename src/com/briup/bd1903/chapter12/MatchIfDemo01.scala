package com.briup.bd1903.chapter12

object MatchIfDemo01 {
  def main(args: Array[String]): Unit = {
    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        // 说明..
        //如果case后有条件守卫if,那么这时的_不是表示默认匹配,表示忽略传入的ch值
        case _ if ch.toString.equals("3") => digit = 3
        case _ if ch > 10 && ch < 20 => println("ch > 10")
        case _ => sign = 2
      }
      println(ch + " " + sign + " " + digit)
    }

  }
}
