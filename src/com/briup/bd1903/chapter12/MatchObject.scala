package com.briup.bd1903.chapter12

object MatchObject {
  def main(args: Array[String]): Unit = {
    // 模式匹配使用：
    val number: Double = 36.0
    number match {
      //1.当匹配到case Square(n)时
      //2.调用Square的unapply(z: Double),z的值就是number
      //3.如果对象提取器unapply(z: Double)返回的是Some(6)集合,则表示匹配成功,同时将 6 赋值给Square(n)的n
      //如果返回的是None,则执行_的默认语句
      case Square(n) => println("匹配成功 n=" + n)
      case _ => println("nothing matched")
    }
  }
}

object Square {
  //1.unapply是对象提取器
  //2.可以接收z: Double类型
  //3.返回类型是Option[Double]
  //4.返回的是Some(math.sqrt(z))集合
  def unapply(z: Double): Option[Double] = {
    println("unapply方法被调用了" + z)
    Some(math.sqrt(z))
//    None
  }

  def apply(z: Double): Double = z * z
}