package com.briup.bd1903.chapter12

object MatchObjectDemo {
  def main(args: Array[String]): Unit = {
    val namesString = "Alice,Bob,Thomas"
    //说明
    namesString match {
      //1.当执行下面这个case时case Names(first, second, third)
      //2.会调用unapplySeq,把"Alice,Bob,Thomas"传入给str
      //3.如果满足Some(str.split(",")) => Some("Alice","Bob","Thomas")分别给(first, second, third)
      //4.注意这里的返回的值的个数需要和(first, second, third)要保持一致
      //5.如果返回的None则表示匹配失败
      case Names(first, second, third) => {
        println("the string contains three people's names")
        // 打印字符串
        println(s"$first $second $third")
      }
      case _ => println("nothing matched")
    }

  }
}

object Names {
  //当构造器是多个参数时,就会触发这个对象提取器
  def unapplySeq(str: String): Option[Seq[String]] = {
    if (str.contains(",")) Some(str.split(","))
    else None
  }
}

