package com.briup.bd1903.chapter17.observer.observerpattern

//气象局的公告板
class CurrentConditions extends Observer {
  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  def display() = {
    println("***天气公告板 Today mTemperature: " + mTemperature + "***")
    println("***天气公告板 Today mPressure: " + mPressure + "***")
    println("***天气公告板 Today mHumidity: " + mHumidity + "***")
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
