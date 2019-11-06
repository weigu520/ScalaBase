package com.briup.bd1903.chapter08.mixin

object MixInDemo02 {
  def main(args: Array[String]): Unit = {
    val mysql5 = new MySQL5 with DB5 with File5
    mysql5.insert(999)
    //将数据保存到文件中..
    //将数据保存到数据库中..

    //错误的混入方式
//    val mysql5_ = new MySQL5 with File5
//    mysql5_.insert(999)
  }
}

trait Operate5 {
  def insert(id: Int)
}

trait File5 extends Operate5 {

  //1.如果在子特质中重写了一个父特质的抽象方法,但是同时调用super
  //2.这时不是完全实现,需要声明为abstract override方法
  //3.这时super.insert(id)的调用就和动态混入顺序有密切的关系
  abstract override def insert(id: Int): Unit = {
    println("将数据保存到文件中..")
    super.insert(id)
  }
}

trait DB5 extends Operate5 {
  def insert(id: Int): Unit = {
    println("将数据保存到数据库中..")
  }
}

class MySQL5 {}

