package com.briup.bd1903.chapter13

object AbstractControl {
  def main(args: Array[String]): Unit = {

    //myRunInThread就是一个抽象控制
    //是没有输入也没有输出的函数f1: () => Unit
    def myRunInThread(f1: () => Unit) = {
      new Thread {
        override def run(): Unit = {
          f1()
        }
      }.start()
    }

    myRunInThread {
      () =>
        println("干活咯！5秒完成...")
        Thread.sleep(5000)
        println("干完咯！")
    }

    def myRunInThread2(f1:  => Unit) = {
      new Thread {
        override def run(): Unit = {
          f1
        }
      }.start()
    }
    //对于没有输入,也没有返回值函数,可以简写
    myRunInThread2 {
        println("干活咯！5秒完成~~~")
        Thread.sleep(5000)
        println("干完咯！~~~")
    }

  }


}
