package com.briup.bd1903.chapter07.myextends

object ScalaFiledOverrideDetail02 {
  def main(args: Array[String]): Unit = {
    val f = new F
    println(f.sal) //0

    val e: E = new F
    println(e.sal()) //0
  }
}

class E {
  def sal(): Int = {
    return 10
  }
}

class F extends E {
  override val sal: Int = 0 //底层 public sal()
}
