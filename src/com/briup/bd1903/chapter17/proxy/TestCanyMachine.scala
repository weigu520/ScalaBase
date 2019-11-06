package com.briup.bd1903.chapter17.proxy

object TestCanyMachine {
  def main(args: Array[String]): Unit = {
    val mMonitor = new Monitor()
    var mCandyMachine = new CandyMachine("北京-海淀区", 6)
    mMonitor.addMachine(mCandyMachine)

    mCandyMachine = new CandyMachine("北京-昌平区~", 4)
    mCandyMachine.insertCoin()
    mMonitor.addMachine(mCandyMachine)

    mCandyMachine = new CandyMachine("北京-朝阳区", 14);
    mCandyMachine.insertCoin()
    mCandyMachine.turnCrank()//转动曲柄，出糖
    mMonitor.addMachine(mCandyMachine)

    mMonitor.report()
  }
}
