package com.briup.bd1903.chapter04.mutilfor

import scala.io.StdIn

object Exercise02 {
  def main(args: Array[String]): Unit = {
//    统计三个班成绩情况，每个班有5名同学，求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
//    统计三个班及格人数，每个班有5名同学。
    val classNum = 3
    val stuNum = 5
    var score = 0.0 //分数
    var classScore = 0.0 //班级总分
    var totalScore = 0.0 //所有班级总分
    var passNum = 0 //统计及格人数
    for (i <- 1 to classNum) {
      //先将classScore 清0
      classScore = 0.0
      for (j <- 1 to stuNum) {
        printf("请输入第%d班级的第%d个学生的成绩\n", i, j)
        score = StdIn.readDouble()
        if( score >= 60){
          passNum += 1
        }
        classScore += score
      }
      //累计总分totalScore
      totalScore += classScore
      printf("第%d班级的平均分%.2f\n", i, classScore / stuNum)
    }
    printf("所有班级的平均分为%.2f\n", totalScore / (stuNum * classNum))
    printf("所有班级的及格人数为%d\n", passNum)
  }
}
