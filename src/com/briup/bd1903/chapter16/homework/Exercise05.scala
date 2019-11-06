package com.briup.bd1903.chapter16.homework

object Exercise05 {
  def main(args: Array[String]): Unit = {
    println(values((x:Int) => x*x,-5,5))
  }

  /*
  编写函数values(fun:(Int)=>Int,low:Int,high:Int),
  该函数输出一个集合，对应给定区间内给定函数的输入和输出。
  比如,values(x=>x*x,-5,5)应该产出一个对偶的集合(-5,25),(-4,16),(-3,9),…,(5,25)
   */
  def values(fun: (Int) => Int, low: Int, high: Int) = {
    var newList = List[(Int, Int)]()
    low to high foreach {x => newList = (x, fun(x)) :: newList}
    newList.reverse
  }
}
