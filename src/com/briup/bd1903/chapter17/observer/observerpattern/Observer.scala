package com.briup.bd1903.chapter17.observer.observerpattern

trait Observer {
  //抽象方法,等待其他的观察者实现
  def update(mTemperatrue: Float, mPressure: Float, mHumidity: Float)
}
