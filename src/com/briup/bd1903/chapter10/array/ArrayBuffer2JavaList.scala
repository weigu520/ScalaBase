package com.briup.bd1903.chapter10.array

import scala.collection.mutable.ArrayBuffer

object ArrayBuffer2JavaList {
  def main(args: Array[String]): Unit = {
    // Scala集合和Java集合互相转换
    val arr = ArrayBuffer("1", "2", "3")
    import scala.collection.JavaConversions.bufferAsJavaList
    //隐式函数转换:参数类型转换:ArrayBuffer->List
    val javaArr = new ProcessBuilder(arr)
    val arrList = javaArr.command()
    println(arrList) //输出 [1, 2, 3]

    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable
    // java.util.List ==> Buffer
    val scalaArr: mutable.Buffer[String] = arrList
    scalaArr.append("jack")
    println(scalaArr)

  }
}
