package com.briup.bd1903.chapter16.homework

object WordCount {
  def main(args: Array[String]): Unit = {
    val lines = List("briup wei hello", "briup wei c a c a d m n")
    //    val res1 = lines.flatMap((s:String) => s.split(" "))
    //扁平化
    val res1 = lines.flatMap(_.split(" "))
    println("res1=" + res1)
    //对偶List => 分组统计
//    val res2 = res1.map((s: String) => (s, 1))
    val res2 = res1.map((_, 1))
    println("res2=" + res2)
    //分组,把不同的单词归属到不同的组
//    val res3 = res2.groupBy((x:(String,Int)) => x._1)
    val res3 = res2.groupBy(_._1)
    println("res3=" + res3)
    //对res3的各个元组,进行统计大小
//    val res4 = res3.map((x:(String,List[(String,Int)])) => (x._1,x._2.size))
    val res4 = res3.map(x => (x._1,x._2.size))
    println("res4=" + res4)
    //对res4的结果排序
//    res4.toList.sortBy((x:(String,Int)) => x._2)
    val res5 = res4.toList.sortBy(_._2).reverse
    println("res5=" + res5)

    //合并上面操作
    println(lines.flatMap(_.split(" ")).map((_,1)).groupBy(_._1).map(x=>(x._1,x._2.size)).toList.sortBy(_._2).reverse)
  }
}
