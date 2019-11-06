package com.briup.bd1903.chapter02.datatype

object CharDemo {
  def main(args: Array[String]): Unit = {
    var char1: Char = 97
    //当我们输出一个char类型时,会输出该数字对应的字符(Unicode码)Unicode码值表包括了ASCII码

    //char可以当做数字进行计算
    var char2: Char = 'a'
    var num = 10 + char2
    println("num" + num)

  }
}
