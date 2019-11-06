package com.briup.bd1903.chapter02.dataconvert

object Demo01 {
  def main(args: Array[String]): Unit = {

    //1.有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算。
    var n1 = 10
    var n2 = 1.1f
    var n3 = n1 + n2

    //2.(byte, short) 和 char之间不会相互自动转换。
    var n4: Byte = 10
//    var char1: Char = n4  //false,因为byte不能自动转换为char




  }
}
