package com.briup.bd1903.chapter07.myextends

object ScalaFiledOverrideDetails {
  def main(args: Array[String]): Unit = {
    val d = new D
//    d.name = "jack" 相当于调用了父类的name_$eq()
//    println(d.name) 相当于调用了子类的name()
    //这样出现数据设置和数据获取不一致
  }
}

class C {
//  var name: String = "" //底层会生成public name() public name_$eq()
}

class D extends C {
//  override val name: String = "JJ"  //底层会生成public name()
}
