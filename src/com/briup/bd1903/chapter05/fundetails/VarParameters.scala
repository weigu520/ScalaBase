package com.briup.bd1903.chapter05.fundetails

object VarParameters {
  def main(args: Array[String]): Unit = {
    println(sum(10,20,30))
  }

  //Int*是一个序列Seq[Int]
  def sum(n1: Int, args: Int*): Int = {
    println("args.length" + args.length)
    //遍历
    var sum = n1
    for(item <- args){
      sum += item
    }
    sum
  }
}
