package com.briup.bd1903.chapter07.homework

//编写一段程序,将Java哈希映射中的所有元素拷贝到Scala哈希映射。用引入语句重命名这两个类
//1.当继承了App后,就可以直接在这个类中执行代码,不需要在写main函数
object Exercise03 extends App {

  import java.util.{HashMap => JavaHashMap}

  import collection.mutable.{HashMap => ScalaHashMap}

  val javaMap = new JavaHashMap[Int, String]
  javaMap.put(1, "one")
  javaMap.put(2, "two")
  javaMap.put(3, "three")
  javaMap.put(4, "four")

  val scalaMap = new ScalaHashMap[Int, String]
  //1.javaMap.keySet().toArray(),这里javaMap的key转成数组
  //2.key.asInstanceOf[Int],将key强转成Int类型
  //3.javaMap.get(key),得到这个key对应的value
  //4.(key.asInstanceOf[Int] -> javaMap.get(key)) 是key->value对偶元组
  //5.+=将key->value加入到scalaMap
  for (key <- javaMap.keySet().toArray()) {
    scalaMap += (key.asInstanceOf[Int] -> javaMap.get(key))
  }
  println(scalaMap.mkString("\t"))

}
