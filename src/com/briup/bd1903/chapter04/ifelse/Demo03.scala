package com.briup.bd1903.chapter04.ifelse

import scala.io.StdIn

object Demo03 {
  def main(args: Array[String]): Unit = {
    println("请输入成绩")
    val score = StdIn.readDouble()
    if(score==100){
      println("成绩为100分")
    }else if(score>80&&score<=99){
      println("成绩为{80,99},奖励一台iphone7plus")
    }else if(score>=60&&score<=80){
      println("ipad")
    }else{
      println("奖励嘴巴子")
    }
  }
}
