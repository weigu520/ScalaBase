package com.briup.bd1903.chapter08.innerclass

object ScalaInnerClassdeMO {
  def main(args: Array[String]): Unit = {
    val outer1: ScalaOuterClass = new ScalaOuterClass
    val outer2: ScalaOuterClass = new ScalaOuterClass

    val inner1 = new outer1.ScalaInnerClass
    val inner2 = new outer2.ScalaInnerClass

    inner1.info()
    inner2.info()

    //调用test方法内部类方法
    inner1.test(inner1)
    inner2.test(inner2)
    inner1.test(inner2) //在默认情况下scala的内部类的实例和创建该内部类实例的外部类对象关联

    val staticInnerClass = new ScalaOuterClass.ScalaStaticInnerClass
  }
}

class ScalaOuterClass {

  myOut => //外部类的别名看作是外部类的一个实例
  //定义两个属性要放在别名后面
  var name = "sc"
  private var sal = 3000

  class ScalaInnerClass { //成员内部类

    def info() = {
      // 访问方式：外部类名.this.属性名
      // 怎么理解 ScalaOuterClass.this 就相当于是 ScalaOuterClass 这个外部类的一个实例,
      // 然后通过 ScalaOuterClass.this 实例对象去访问 name 属性
      // 只是这种写法比较特别，学习java的同学可能更容易理解 ScalaOuterClass.class 的写法.
      println("外部类.this.属性" + " name = " + ScalaOuterClass.this.name
        + " sal =" + ScalaOuterClass.this.sal)
      println("取别名myOut.属性" + " name = " + myOut.name
        + " sal =" + myOut.sal)
    }

    //下面方法可以接收ScalaInnerClass实例
    // ScalaOuterClass#ScalaInnerClass:类型投影的作用就是屏蔽外部类对象对内部类对象的影响
    def test(ic: ScalaOuterClass#ScalaInnerClass): Unit = {
      println("使用了类型投影" + ic)
    }
  }

}

object ScalaOuterClass {

  class ScalaStaticInnerClass { //静态内部类
  }

}
