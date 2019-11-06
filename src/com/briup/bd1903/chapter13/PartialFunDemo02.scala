package com.briup.bd1903.chapter13

object PartialFunDemo02 {
  def main(args: Array[String]): Unit = {
    //使用偏函数解决
    val list = List(1, 2, 3, 4, "Hello")
    //定义一个偏函数
    //PartialFunction[Any,Int]表示偏函数接收的参数类型是Any,返回类型是Int
    //isDefinedAt(x: Any)如果返回true,就会去调用apply构建对象实例,如果是false,过滤x
    //apply构造器对传入的值加1,并返回(新的集合)
    val partialFun = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = {
        println("x=" + x)
        x.isInstanceOf[Int]
      }

      override def apply(v1: Any): Int = {
        println("v1=" + v1)
        v1.asInstanceOf[Int] + 1
      }
    }

    //如果是使用偏函数,则不能使用map，应该使用collect
    //执行流程
    //1.遍历List所有元素
    //2.然后调用val element = if (isDefinedAt(List单个元素)) apply(List单个元素)
    //3.将element添加到新集合中
    val list2 = list.collect(partialFun)
    println(list2)
  }
}
