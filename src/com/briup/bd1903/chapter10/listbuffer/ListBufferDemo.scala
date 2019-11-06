package com.briup.bd1903.chapter10.listbuffer

import scala.collection.mutable.ListBuffer

object ListBufferDemo {
  def main(args: Array[String]): Unit = {
    //创建ListBuffer
    val lb = ListBuffer[Int](1, 2, 3)

    //访问元素
    println("lb(0)=" + lb(0))

    //动态的增加元素,lb就会变化
    lb.append(4)
    lb += 5

    val lb1 = new ListBuffer[Int]
    lb1 ++= lb
    println("lb1=" + lb1)

    val lb2 = lb1 :+ 6
    println("lb1=" + lb2)

    //删除元素
    lb2.remove(lb2.length - 1)

    //遍历元素
    for (item <- lb2) {
      println("item=" + item)
    }

  }
}
