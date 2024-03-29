package com.briup.bd1903.chapter02.datatype

object TypeDemo02 {
  def main(args: Array[String]): Unit = {
    println(sayHello)

    var num = 1.2 //默认为Double
    var num2 = 1.7f //这是Float
    //num2 = num//error 修改num2 = num.toFloat

  }

  //比如开发中,我们有一个方法,就会异常中断,这时就可以返回Nothing
  //即当我们把Nothing做返回值时,就是明确说明该方法没有正常返回值
  def sayHello: Nothing = {
    throw new Exception("抛出异常")
  }
}
