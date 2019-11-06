package com.briup.bd1903.chapter17.proxy

import scala.collection.mutable.ListBuffer

//监控糖果的类
class Monitor {

  //监控多台糖果机
  private val candyMachinelst: ListBuffer[CandyMachine] = ListBuffer()

  //给监控器增加一个糖果机
  def addMachine(mCandyMachine:CandyMachine) = {
    candyMachinelst.append(mCandyMachine)
  }

  def  report() = {
    //var mCandyMachine:CandyMachine = null
    for (mCandyMachine <- this.candyMachinelst) {
      println("----------------------------------------")
      println("Machine Loc:" + mCandyMachine.getLocation())
      println("Machine Candy count:" + mCandyMachine.getCount())
      println("Machine State:" + mCandyMachine.getstate().getstatename())
    }
  }

}
