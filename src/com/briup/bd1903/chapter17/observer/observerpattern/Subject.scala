package com.briup.bd1903.chapter17.observer.observerpattern

trait Subject {
  def registerObserver(o: Observer)
  def removeObserver(o: Observer)
  def notifyObservers()
}
