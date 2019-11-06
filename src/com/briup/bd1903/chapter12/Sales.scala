package com.briup.bd1903.chapter12

/*
现在有一些商品，请使用Scala设计相关的样例类，完成商品可以捆绑打折出售。要求
商品捆绑可以是单个商品，也可以是多个商品。
打折时按照折扣xx元进行设计.
能够统计出所有捆绑商品打折后的最终价格
 */
object Sales {
  def main(args: Array[String]): Unit = {
    //打折的案例
    //有一捆书,单本漫画（40-10） +文学作品(两本书)（80+30-20） = 30 + 90 = 120.0
    val sale = Bundle("书籍", 10, Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30)))

    //使用match对象匹配,得到漫画
    val res = sale match {
      //如果我们进行对象匹配时，不想接受某些值，则使用_ 忽略即可，_* 表示所有
      case Bundle(_, _, Book(desc, _), _*) => desc
    }
    println("res=" + res)

    //知识点2-通过@表示法将嵌套的值绑定到变量。_*绑定剩余Item到rest
    val res2 = sale match {
      //如果我们进行对象匹配时，不想接受某些值，则使用_ 忽略即可，_* 表示所有
      case Bundle(_, _, book@Book(_, _), rest@_*) => (book, rest)
    }
    println("res2" + res2)

    //知识点3-不使用_*绑定剩余Item到rest
    val res3 = sale match {
      //如果我们进行对象匹配时，不想接受某些值，则使用_ 忽略即可，_* 表示所有
      case Bundle(_, _, book@Book(_, _), rest) => (book, rest)
    }
    println("res3" + res3)

    println("price=" + price(sale)) //120

  }

  def price(it: Item): Double = {
    it match {
      case Book(_, p) => p
      //生成一个新的集合,_是将its中每个循环的元素传递到price中it中。递归操作,分析一个简单的流程
      case Bundle(_, disc, its@_*) => its.map(price).sum - disc
    }
  }
}

abstract class Item // 项

case class Book(description: String, price: Double) extends Item

//Bundle 捆 ， discount: Double 折扣 ， item: Item* ,
case class Bundle(description: String, discount: Double, item: Item*) extends Item