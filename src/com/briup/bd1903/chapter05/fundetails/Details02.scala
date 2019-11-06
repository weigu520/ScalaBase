package com.briup.bd1903.chapter05.fundetails

object Details02 {
  def main(args: Array[String]): Unit = {
    //如果函数明确使用return关键字，那么函数返回就不能使用自行推断了,这时要明确写成 : 返回类型 =  ，
    // 当然如果你什么都不写，即使有return 返回值为()
    println(getSum2(10,20)) //()
    println(getSum3(9,9))   //()
  }

  def getSum2(n1: Int, n2: Int){
    //如果返回值这里什么都没有写,即表示改函数没有返回值,这时的return无效
    return n1 + n2
  }

  def getSum3(n1: Int, n2: Int):Unit={
    //如果返回值这里什么都没有写,即表示改函数没有返回值,这时的return无效
    return n1 + n2
  }

  def getSum(n1: Int, n2: Int): Int = {
    //因为这里有明确的return,这时getSum就不能省略 : Int = 的 Int了
    return n1 + n2
  }

}
