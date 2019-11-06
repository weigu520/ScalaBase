package com.briup.bd1903.chapter13

/*
  比较两个字符串在忽略大小写的情况下是否相等，注意，这里是两个任务：
  全部转大写（或小写）
  比较是否相等
 */
object CurryDemo02 {
  def main(args: Array[String]): Unit = {
    println("hello".checkEq("Hello")(eq))
    println("hello".checkEq("Hello")(_.equals(_)))
  }

  //    方式1: 简单的方式,使用一个函数完成.
  def eq2(s1: String)(s2: String): Boolean = {
    s1.toLowerCase == s2.toLowerCase
  }

  def eq(s1: String, s2: String): Boolean = {
    s1.equals(s2)
  }

  //隐式类
  //checkEq完成转换大小写
  //f函数完成比较功能
  implicit class TestEq(s: String) {
    def checkEq(ss: String)(f: (String, String) => Boolean): Boolean = {
      f(s.toLowerCase, ss.toLowerCase)
    }
  }

}
