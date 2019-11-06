package com.briup.bd1903.chapter13

/*
给你一个集合val list = List(1, 2, 3, 4, "abc") ，请完成如下要求:
将集合list中的所有数字+1，并返回一个新的集合
要求忽略掉 非数字 的元素，即返回的 新的集合 形式为 (2, 3, 4, 5)
 */
object PartialFunDemo01 {
  def main(args: Array[String]): Unit = {
    //思路1-map+filter方式
    //但是比较麻烦,效率低下
    //先过滤,再map
    val list = List(1, 2, 3, 4, "abc")
    println(list.filter(f1).map(f2).map(f3))

    //思路2-模式匹配
    //不够完美,有个默认值()
    def addOne(i: Any): Any = {
      i match {
        case x: Int => x + 1
        case _ =>
      }
    }
    val list2 = list.map(addOne)
    println(list2)
  }

  def f1(n: Any): Boolean = {
    n.isInstanceOf[Int]
  }

  //将Any->Int
  def f2(n: Any): Int = {
    n.asInstanceOf[Int]
  }

  def f3(n: Int): Int = {
    n + 1
  }
}
