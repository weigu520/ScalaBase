package com.briup.bd1903.chapter07.homework

object Exercise04 {
  def main(args: Array[String]): Unit = {
    println("xx")
  }
}

class Monster{
  var age : Int = 1
  protected var sal : Double = 0.01
  private var name : String = ""
}
//底层代码
/*
package com.briup.bd1903.chapter07.homework;

import scala.reflect.ScalaSignature;

@ScalaSignature(bytes="\006\001%3Aa\003\007\001/!)a\004\001C\001?!9!\005\001a\001\n\003\031\003bB\024\001\001\004%\t\001\013\005\007]\001\001\013\025\002\023\t\017=\002\001\031!C\005a!9A\b\001a\001\n\023i\004BB \001A\003&\021\007C\004A\001\001\007I\021C!\t\017\025\003\001\031!C\t\r\"1\001\n\001Q!\n\t\023q!T8ogR,'O\003\002\016\035\005A\001n\\7fo>\0248N\003\002\020!\005I1\r[1qi\026\024\bg\016\006\003#I\taA\03132sA\032$BA\n\025\003\025\021'/[;q\025\005)\022aA2p[\016\0011C\001\001\031!\tIB$D\001\033\025\005Y\022!B:dC2\f\027BA\017\033\005\031\te.\037*fM\0061A(\0338jiz\"\022\001\t\t\003C\001i\021\001D\001\004C\036,W#\001\023\021\005e)\023B\001\024\033\005\rIe\016^\001\bC\036,w\fJ3r)\tIC\006\005\002\032U%\0211F\007\002\005+:LG\017C\004.\007\005\005\t\031\001\023\002\007a$\023'\001\003bO\026\004\023\001\0028b[\026,\022!\r\t\003eer!aM\034\021\005QRR\"A\033\013\005Y2\022A\002\037s_>$h(\003\00295\0051\001K]3eK\032L!AO\036\003\rM#(/\0338h\025\tA$$\001\005oC6,w\fJ3r)\tIc\bC\004.\r\005\005\t\031A\031\002\0139\fW.\032\021\002\007M\fG.F\001C!\tI2)\003\002E5\t1Ai\\;cY\026\fqa]1m?\022*\027\017\006\002*\017\"9Q&CA\001\002\004\021\025\001B:bY\002\002")
public class Monster
{
  private int age = 1;
  private String name = "";
  private double sal = 0.01D;

  public int age()
  {
    return this.age; }
  public void age_$eq(int x$1) { this.age = x$1; }
  private String name() { return this.name; }
  private void name_$eq(String x$1) { this.name = x$1; }
  public double sal() { return this.sal; }
  public void sal_$eq(double x$1) { this.sal = x$1; }

}
 */