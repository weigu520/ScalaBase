package com.briup.bd1903.chapter02.dataconvert

object StringToBasic {
  def main(args: Array[String]): Unit = {
    val d1 = 1.2
    //基本数据类型转String类型
    val s1 = d1 + ""

    //String类型转基本数据类型
    val s2 = "12"
    val num2 = s2.toInt
    val num3 = s2.toLong
    val num4 = s2.toDouble
    val num5 = s2.toFloat

    //在将String 类型转成 基本数据类型时，要确保String类型能够转成有效的数据，比如 我们可以把 "123" , 转成一个整数，但是不能把 "hello" 转成一个整数
    val s3 = "hello"
//    println(s3.toInt) NumberFormatException

    //思考就是要把 "12.5" 转成 Int?
    //在scala中,不是将小数点后的数据进行截取,而是会抛出异常
    val s4 = "12.5"
//    println(s4.toInt) NumberFormatException,toDouble

  }
}
