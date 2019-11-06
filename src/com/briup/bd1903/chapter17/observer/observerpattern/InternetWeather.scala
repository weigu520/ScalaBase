package com.briup.bd1903.chapter17.observer.observerpattern

object InternetWeather {
  def main(args: Array[String]): Unit = {
    val mWeatherDataSt = new WeatherDataSt()
    val mCurrentConditions = new CurrentConditions()
    val sinaCurrentConditions = new SinaCurrentConditions
    mWeatherDataSt.registerObserver(mCurrentConditions)
    mWeatherDataSt.registerObserver(sinaCurrentConditions)
    mWeatherDataSt.setData(30, 150, 40)

    mWeatherDataSt.removeObserver(mCurrentConditions)
    mWeatherDataSt.setData(-1, 250, 50)

  }
}
