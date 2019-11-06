package com.briup.bd1903.chapter07.scalapackage.importdetails

import scala.beans.BeanProperty //表示j将该包的所以内容导入,等价于*

object TestImport {

}

class User {

  import scala.beans.BeanProperty //在需要时才引入,作用域在{}中
  @BeanProperty var name: String = ""

  def test(): Unit = {
    //可以使用选择器,选择引入包的内容,下面只引入HashMap, HashSet
    import scala.collection.mutable.{HashMap, HashSet}
    var map = new HashMap()
    var set = new HashSet()
  }

  def test2() = {
    //下面的含义是java.util.HashMap=>重命名为javaHashMap
    import java.util.{HashMap => JavaHashMap}

    import scala.collection.mutable._
    var map = new HashMap() // 此时的HashMap指向的是scala中的HashMap
    var map1 = new JavaHashMap(); // 此时使用的java中hashMap的别名

  }

  def test3() = {
    import java.util.{HashMap => _} // 含义为 引入java.util包的所有类，但是忽略 HahsMap类.
    //var map = new HashMap() // 此时的HashMap指向的是scala中的HashMap, 而且idea工具，的提示也不会显示java.util的HashMaple
  }

}

class Dog {
  @BeanProperty var name: String = ""
}
