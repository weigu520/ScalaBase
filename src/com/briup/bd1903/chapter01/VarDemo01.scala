package com.briup.bd1903.chapter01

object VarDemo01 {
  def main(args: Array[String]): Unit = {
    //编译器,动态的(逃逸分析)
    var age: Int = 10
    var sal: Double = 10.9
    var name: String = "Tom"
    var isPass: Boolean = true
    //在scala中,小数默认为Double,整数默认是Int
    var score: Float = 70.4f
    println(s"$name\t$age")
  }
}
