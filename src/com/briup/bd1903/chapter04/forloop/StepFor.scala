package com.briup.bd1903.chapter04.forloop

object StepFor {
  def main(args: Array[String]): Unit = {
    //步长控制
    for (i <- 1 to 10) {
      println("i=" + i)
    }
    println("===============")
    //步长控制为2
    //Rang(1,10,2)的对应的构建方法是
    //def apply(start: Int, end: Int, step: Int): Range.Exclusive = new Range.Exclusive(start, end, step)
    for (i <- Range(1, 10, 2)) {
      println("i=" + i)
    }
    println("===============")
    //控制步长的第二种方式
    for (i <- 1 to 10 if i % 2 == 1) {
      println("i=" + i)
    }
  }
}
