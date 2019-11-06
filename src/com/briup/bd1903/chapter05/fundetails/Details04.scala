package com.briup.bd1903.chapter05.fundetails

object Details04 {
  def main(args: Array[String]): Unit = {
    println(sayOk())  //jack ok!
    println(sayOk("mary"))  //mary ok!
  }

  //name 形参的默认值为jack
  def sayOk(name: String = "jack"): String = {
    return name + " ok! "
  }

}
