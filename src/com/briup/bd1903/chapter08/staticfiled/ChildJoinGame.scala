package com.briup.bd1903.chapter08.staticfiled

object ChildJoinGame {
  def main(args: Array[String]): Unit = {
    //创建三个小孩
    val c1 = new Child("哪吒")
    val c2 = new Child("敖丙")
    val c3 = new Child("太乙真人")
    Child.joinGame(c1)
    Child.joinGame(c2)
    Child.joinGame(c3)
    Child.showNum()
  }
}

class Child(cName: String) {
  var name: String = cName
}

object Child {
  var totalChildNum = 0

  def joinGame(child: Child): Unit = {
    printf("%s 小孩加入了游戏\n", child.name)
    totalChildNum += 1
  }

  def showNum(): Unit = {
    printf("当前有%d小孩玩游戏\n", totalChildNum)
  }
}
