package com.briup.bd1903.chapter02.identify

object IdenDemo01 {
  def main(args: Array[String]): Unit = {
    //首字符为操作符(比如+ - * / )，后续字符也需跟操作符 ,至少一个(反编译)**
    val ++ = "hello,world" //ok
    //++ => $plus$plus
    println(++)

    val -+ = 90 //ok
    println("res=" + -+)

    //    val +q = "+q" error

    //用反引号`....`包括的任意字符串，即使是关键字(39个)也可以 [true]
    var `true` = "hello,scala"
    println("内容=" + `true`)

    val Int = 90.45
    println("Int=" + Int)

    //不能使用下划线_做标识符
//    val _ = "jack"
//    println(_)

  }
}
