package com.briup.bd1903.chapter12

object CaseClassDemo03 {
  def main(args: Array[String]): Unit = {
    val amt = Currency(29.95, "RMB")
    val amt1 = amt.copy() //创建了一个新的对象，但是属性值一样
    val amt2 = amt.copy(value = 19.95) //创建了一个新对象，但是修改了货币单位
    val amt3 = amt.copy(unit = "英镑") //..
    println(amt)
    println(amt2)
    println(amt3)
  }
}
