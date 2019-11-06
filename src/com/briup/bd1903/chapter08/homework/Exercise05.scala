package com.briup.bd1903.chapter08.homework

/*
扩展如下的BankAccount类，新类CheckingAccount对每次存款和取款都收取1美元的手续费
 */

object Exercise05 {
  def main(args: Array[String]): Unit = {
    val checkingAccount = new CheckingAccount(100)
    checkingAccount.query()
    checkingAccount.deposit(10)
    checkingAccount.withdraw(10)
    checkingAccount.query()
  }
}

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  //存款
  def deposit(amount: Double) = {
    balance += amount
    balance
  }

  //取款
  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }

  //加入一个查询余额方法
  def query(): Unit = {
    println("当前余额为:" + balance)
  }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = super.deposit(amount - 1)

  override def withdraw(amount: Double): Double = super.withdraw(amount + 1)
}