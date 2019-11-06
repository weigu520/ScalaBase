package com.briup.bd1903.chapter17.observer.observerpattern

class SinaCurrentConditions extends Observer {
  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  def display() = {
    if (mTemperature > 38) {
      println("***新浪的天气公告板 Today mTemperature: " + mTemperature + "***"+"天气炎热中暑")
    }else if(mTemperature <5){
      println("***新浪的天气公告板 Today mTemperature: " + mTemperature + "***"+"天气寒冷冻死")
    }
    println("***新浪的天气公告板 Today mTemperature: " + mTemperature + "***")
    println("***新浪的天气公告板 Today mPressure: " + mPressure + "***")
    println("***新浪的天气公告板 Today mHumidity: " + mHumidity + "***")
  }

  override def update(mTemperature: Float, mPressure: Float, mHumidity: Float) = {
    //更新天气公告板的数据
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    //显示
    display()
  }
}
