package com.briup.bd1903.chapter17.observer.local

object InternetWeather {
  def main(args: Array[String]): Unit = {
    //创建天气公告板
    val mCurrentConditions = new CurrentConditions()
    //创建WeatherData,设置数据
    val mWeatherData = new WeatherData(mCurrentConditions)
    mWeatherData.setData(30, 150, 40)
  }
}
