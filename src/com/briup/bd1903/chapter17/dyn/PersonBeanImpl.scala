package com.briup.bd1903.chapter17.dyn

//这个是要被调用的对象
class PersonBeanImpl extends PersonBean {

  var name = ""
  var gender = ""
  var interests = ""

  var score :Int = _ // 评分值


  override def getName(): String = {
    return name
  }

  override def getGender(): String = {
    gender
  }

  override def getInterests(): String = {
    interests
  }

  //  override def getHotOrNotRating(): Int = {
  //    //rating/ratingcount 是平均分
  //    if (ratingcount == 0) return 0 else rating / ratingcount
  //
  //  }

  //自己可以调用,其他用户不能调用
  override def setName(name: String): Unit = {
    this.name = name
  }

  override def setGender(gender: String): Unit = {
    this.gender = gender
  }

  override def setInterests(interests: String): Unit = {
    this.interests = interests
  }

  //  override def setHotOrNotRating(rating: Int): Unit = {
  //    this.rating = rating
  //    ratingcount += 1
  //  }

  //  override def toString: String = {
  //    "什么意思"
  //  }
  override def getScore(): Int = {
    score
  }

  //自己不能调用,其他用户可以调
  override def setScore(score: Int): Unit = {
    this.score = score
  }
}
