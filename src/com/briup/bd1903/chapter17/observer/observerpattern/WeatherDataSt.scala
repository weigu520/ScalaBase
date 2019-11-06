package com.briup.bd1903.chapter17.observer.observerpattern

import scala.collection.mutable.ListBuffer

class WeatherDataSt extends Subject {

  //集合,管理所有的观察者
  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _
  private val mObservers: ListBuffer[Observer] = ListBuffer()

  def getTemperature() = {
    mTemperature
  }

  def getPressure() = {
    mPressure
  }

  def getHumidity() = {
    mHumidity
  }

  def dataChange() = {
    //一旦天气变化,通知所有观察者
    notifyObservers()
  }

  def setData(mTemperature: Float, mPressure: Float, mHumidity: Float) = {
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    dataChange()
  }

  override def registerObserver(o: Observer): Unit = {
    mObservers.append(o)
  }

  override def removeObserver(o: Observer): Unit = {
    if (mObservers.contains(o)) {
      mObservers -= o
    }
  }

  //天气情况变化了,通知所有的观察者
  override def notifyObservers(): Unit = {
    for (observer <- mObservers) {
      observer.update(mTemperature, mPressure, mHumidity)
    }
  }
}
