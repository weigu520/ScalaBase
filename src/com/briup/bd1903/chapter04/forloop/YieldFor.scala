package com.briup.bd1903.chapter04.forloop

object YieldFor {
  def main(args: Array[String]): Unit = {
    //1.对i 1 to 10 进行遍历
    //2.yield i 将每次循环得到的i 放入到集合Vector中,并返回给res
    //3.i 这里可以是一个代码块,这就意味着我们可以对i进行处理
    //4.下面的这个方式就体现出scala一个重要的语法特点:将一个集合中的各个数据进行处理并返回给新的集合
    val res = for (i <- 1 to 10) yield {
      if (i % 2 == 0) {
        i
      } else {
        "不是偶数"
      }
    }
    println(res)
  }
}
