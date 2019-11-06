package com.briup.bd1903.chapter06.oop

object CatDemo {
  def main(args: Array[String]): Unit = {
    //创建一只猫
    val cat = new Cat
    //cat.name = "小白"等价于cat.name_$eq("小白")
    //cat.name等价于cat.name()
    cat.name = "小白"
    cat.age = 10
    cat.color = "白色"
    printf("小猫的信息如下:%s %d %s",cat.name,cat.age,cat.color)
  }
}
//一个class Cat对应的字节码只有一个Cat.class,默认是public
class Cat{
  //声明三个属性
  //var name: String在底层对应private String name
  //同时会生成两个public方法 name()<=类似于=>getter name_$eq(String x$1)<=类似于=>setter
  var name: String = "" //给初始值
  var age: Int = _ // _表示给age一个默认值,如果时Int默认是0
  var color: String = _ //给color一个默认值String就是""
}
