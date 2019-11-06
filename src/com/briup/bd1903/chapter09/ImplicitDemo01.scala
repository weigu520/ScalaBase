package com.briup.bd1903.chapter09

object ImplicitDemo01 {
  def main(args: Array[String]): Unit = {

    //编写一个隐式函数转成Double->Int转换
    //隐式函数应当在作用域才能生效
    //隐式函数匹配必须是唯一的
    implicit def f1(d: Double): Int = { //f1$1
      d.toInt
    }

    implicit def f2(f: Float): Int = {
      f.toInt
    }

    val f2i: Int = 1.2f

    val num1: Int = 3.5 //f1$1(3.5) //3
    val num2: Int = 3.6 //3
    val num3: Int = 3.7 //3
    println("sum= " + num1 + num2 + num3) //sum= 333

    /*
    public void main(String[] args)
  {
    int num1 = f1$1(3.5D);
    int num2 = f1$1(3.6D);
    int num3 = f1$1(3.7D);
    Predef..MODULE$.println(5 + "sum= " + num1 + num2 + num3);
  }

  private static final int f1$1(double d)
  {
    return (int)d;
  }
     */
  }
}
