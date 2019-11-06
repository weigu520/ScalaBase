
//代码说明
//1.package com.briup.bd1903{} 表示我们创建了包com.briup.bd1903,
// 在大括号这我们可以继续写它的子包scala即com.briup.bd1903.scala,还可以写类,特质trait,object
//2.即scala支持,在一个文件中可以同时创建多个包,以及给各个包创建类,trait和object

package com.briup.bd1903 {

  import com.briup.bd1903.scala2.Monster //包 com.briup.bd1903

  class User { //在com.briup.bd1903包下创建User类
    val monster = new Monster()

    //想使用scala2下的Monster
    import com.briup.bd1903.scala2.Monster

    def sayHello(): Unit = {}
  }

  package scala2 { //创建包 com.briup.bd1903.scala2
  class User { //在com.briup.bd1903.scala2包下创建User类
  }

    class Monster {
    }

  }

  //1.在包中直接写方法,或者定义变量,就错误==>使用包对象的技术来解决
  //2.package object scala表示创建一个包对象scala,它是com.briup.bd1903.scala这个包对应的包对象
  //3.每一个包都可以有一个包对象,只能有一个
  //4.包对象的名字需要和子包保持一致
  //5.在包对象中可以定义变量,方法
  //6.在包对象做定义的变量和方法,就可以在对应的包中使用
  //7.在底层这个包对象会生成两个类package.class package$.class
  package object scala {
    val name = "king"

    def sayHi(): Unit = {
      println("package object scala sayHi~")
    }
  }


  package scala { //包 com.briup.bd1903.scala

    //在包中直接写方法,或者定义变量,就错误==>使用包对象的技术来解决
    //    val name = "king"
    //    def sayHi():Unit={}

    class Person { //表示在com.briup.bd1903.scala下创建类Person
      val name = "Nick"

      def play(message: String): Unit = {
        println(this.name + " " + message)
      }
    }

    class User {
      def testUser(): Unit = {
        println("name=" + name)
        sayHi()
      }
    }

    object TestDemo { //表示在 com.briup.bd1903.scala创建object Test
      def main(args: Array[String]): Unit = {

        //使用包对象的name
        println("使用name=" + name)
        //使用包对象的方法
        sayHi()


        println("ok")

        //可以直接使用父包的内容,
        //1.如果有同名的类,则采用就近原则来使用内容(比如包)
        //2.如果就是要使用父包的类,则指定路径即可
        val user = new User
        println("user=" + user)
        val user2 = new com.briup.bd1903.User
        println("user2=" + user2)
      }
    }

  }

}

