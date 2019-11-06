package com.briup.bd1903.chapter17.observer.local

//该类可以理解是气象局维护的一个提供天气情况数据类
class WeatherData {
  private var mTemperatrue: Float = _ //温度
  private var mPressure: Float = _ //气压
  private var mHumidity: Float = _ //湿度
  //公告板
  private var mCurrentConditions: CurrentConditions = _

  //构建WeatherData对象时,将CurrentConditions传入
  def this(mCurrentConditions: CurrentConditions) {
    this
    this.mCurrentConditions = mCurrentConditions
  }

  def getTemperature() = {
    mTemperatrue
  }

  def getPressure() = {
    mPressure
  }

  def getHumidity() = {
    mHumidity
  }

  //将最新数据的update给公告板
  def dataChange() = {
    mCurrentConditions.update(getTemperature(), getPressure(), getHumidity())
  }

  //设置最新的天气情况的方法
  def setData(mTemperature: Float, mPressure: Float, mHumidity: Float) = {
    this.mTemperatrue = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    //修改公告板的最新数据
    dataChange()
  }
}
