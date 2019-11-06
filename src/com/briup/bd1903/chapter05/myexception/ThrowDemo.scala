package com.briup.bd1903.chapter05.myexception

object ThrowDemo {
  def main(args: Array[String]): Unit = {
    //      val res = test()
    //      println(res.toString)

    //如果希望在test()抛出异常后,代码可以继续执行,则需要处理异常
    try {
      test()
    } catch {
      case ex: Exception => println("捕获异常:" + ex.getMessage)
      case ex: ArithmeticException => println("得到一个异常")
    }

    println("ok~~~")
  }

  def test(): Nothing = {
    throw new ArithmeticException("算术异常")//Exception("自定义的异常")
  }

}
