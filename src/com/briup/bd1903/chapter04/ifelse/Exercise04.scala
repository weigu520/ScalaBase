package com.briup.bd1903.chapter04.ifelse

import scala.io.StdIn

object Exercise04 {
  def main(args: Array[String]): Unit = {
    //参加百米运动会，如果用时8秒以内进入决赛，否则提示淘汰。
    // 并且根据性别提示进入男子组或女子组.输入成绩和性别，进行判断。
    //double second; char gender;
    println("请输入运动员的成绩")
    val speed = StdIn.readDouble()
    if(speed <= 8){
      println("请输入你的性别")
      val gender = StdIn.readChar()
      if(gender == '男'){
        println("进入男子组")
      }else{
        println("进入女子组")
      }
    }else {
      println("你被淘汰了")
    }
  }
}
