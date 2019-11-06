package com.briup.bd1903.chapter07.obstractdemo

object BankDemo {
  def main(args: Array[String]): Unit = {
    //开卡
    val account = new Account("gh00001",890.4,"111111")
    account.query("111111")
    account.withDraw("111111",100.0)
    account.query("111111")
  }
}

//编写一个Account类
class Account(inAccount: String, inBanlance: Double, inPwd: String) {
  /*
  属性：
账号，余额，密码
  方法:
查询
取款
存款

   */
  private val accountNum = inAccount
  private var balance = inBanlance
  private var pwd = inPwd

  //查询
  def query(pwd: String): Unit = {
    if (!this.pwd.equals(pwd)) {
      println("密码错误")
      return
    }

    printf("账号为%s 当前余额是=%.2f\n", this.accountNum, this.balance)
  }

  //取款
  def withDraw(pwd: String, money: Double): Any = {
    if (!this.pwd.equals(pwd)) {
      println("密码错误")
      return
    }
    //判断money是否合理
    if (money > this.balance) {
      println("余额不足")
      return
    }
    this.balance -= money
    money
  }

}