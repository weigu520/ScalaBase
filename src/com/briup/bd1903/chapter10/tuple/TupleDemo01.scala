package com.briup.bd1903.chapter10.tuple

object TupleDemo01 {
  def main(args: Array[String]): Unit = {
    //tuple1就是一个Tuple 类型是Tuple5
    // Tuple5 tuple1 = new Tuple5(BoxesRunTime.boxToInteger(1), BoxesRunTime.boxToInteger(2), BoxesRunTime.boxToInteger(3), "hello", BoxesRunTime.boxToInteger(4));
    //为了高效的操作元组,编译器根据元素的个数不同,对应不同的元组的类型
    //分别为Tuple1-Tuple22
    val tuple1 = (1, 2, 3, "hello", 4)
    println(tuple1)

    //访问元组元素
    println("------访问元组元素------------")
    println(tuple1._1)

    /*
    @throws(classOf[IndexOutOfBoundsException])
  override def productElement(n: Int) = n match {
    case 0 => _1
    case 1 => _2
    case 2 => _3
    case 3 => _4
    case 4 => _5
    case _ => throw new IndexOutOfBoundsException(n.toString())
 }
     */
    println(tuple1.productElement(0))

    //遍历元组,元组的遍历需要使用到迭代器
    println("------遍历元组元素------------")
    for (item <- tuple1.productIterator) {
      println("item=" + item)
    }
  }
}
