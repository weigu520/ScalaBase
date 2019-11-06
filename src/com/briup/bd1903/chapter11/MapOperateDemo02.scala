package com.briup.bd1903.chapter11

object MapOperateDemo02 {
  def main(args: Array[String]): Unit = {
    val list = List(3, 5, 7)

    //1.将list集合的元素依次遍历
    //2.将遍历出来的元素传递给multiply函数=>新Int
    //3.将得到新的Int放入新集合并返回
    //4.因此multiply函数被调用三次
    val list2 = list.map(multiply)
    println(list2)

    //深刻理解map映射函数的机制-模拟实现
    val myList = MyList()
    val myList2 = myList.map(multiply)
    println("myList2" + myList2)
  }

  def multiply(n: Int): Int = {
    println("被调用了~")
    2 * n
  }
}

//深刻理解map映射函数的机制-模拟实现
class MyList {
  val list1 = List(3, 5, 7)
  //新的集合
  var list2 = List[Int]()

  //写map
  def map(f: Int => Int): List[Int] = {
    //遍历集合
    for (item <- this.list1) {
      //过滤,扁平化...
      list2 = list2 :+ f(item)
    }
    list2
  }
}

object MyList {
  def apply(): MyList = new MyList()
}
