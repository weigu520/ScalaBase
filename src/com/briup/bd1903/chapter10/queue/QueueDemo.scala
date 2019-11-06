package com.briup.bd1903.chapter10.queue

import scala.collection.mutable

object QueueDemo {
  def main(args: Array[String]): Unit = {
    //创建队列
    val q = new mutable.Queue[Int]

    //给队列增加元素
    q += 9
    println("q=" + q)
    q ++= List(8, 7, 6) //默认是直接加在队列的后面
    println("q=" + q)

    //    q += List(5,4)  //将List(5,4)作为一个元素加入到队列中,要求泛型为Any

    //dequeue()出队列,从队列的队首取出元素,q会变
    val queueElement = q.dequeue()
    println("queueElement=" + queueElement + "\tq=" + q)

    //enQueue入队列,默认是从队列的队尾加入
    q.enqueue(5, 5, 5)
    println("q=" + q)

    //返回队列的元素
    //获取队首
    println(q.head)
    //获取队尾
    println(q.last)
    //获取队列的尾部,即除了队首的剩余的元素(队列)
    println(q.tail)
    println(q.tail.tail.tail)

  }
}
