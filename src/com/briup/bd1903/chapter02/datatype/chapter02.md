# Scala数据类型

## scala数据类型介绍

+ Scala 与 Java有着相同的数据类型，**在Scala中数据类型都是对象**，也就是说scala没有java中的原生类型

+ Scala数据类型分为两大类 **AnyVal**(值类型) 和 **AnyRef**(引用类型)， 注意：不管是AnyVal还是AnyRef 都是对象。[案例演示  Int , Char]

  ```scala
  package com.briup.bd1903.chapter02.datatype
  
  object TypeDemo01 {
    def main(args: Array[String]): Unit = {
  
      var num1: Int = 10
      //因为Int是一个类,因此他的一个实例,就是可以使用很多方法
      //在scala中如果一个方法没有形参,则可以省略()
      println(num1.toDouble +"\t"+ num1.toString + 100.toString)
  
      sayHi
      sayHi()
  
      var isPass = true
      println(isPass.toString)
  
    }
  
    def sayHi(): Unit = {
      println("say Hi")
    }
  
  }
  ```

  

+ 相对于java的类型系统，scala要复杂些！也正是这复杂多变的类型系统才让面向对象编程和函数式编程完美的融合在了一起

## scala数据类型体系一览图(记住)

![1568254889538](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1568254889538.png)

**对上面图的小结和整理**

1. 在scala中有一个根类型Any,它是所有类的父类

2. scala中一切皆为对象,分为两大类AnyVal(值类型),AnyRef(引用类型),他们都是Any子类

3. Null类型是scala的特别的类型,它只有一个值null,它是bottom class,是所有AnyRef类型的子类

4. Nothing类型也是底层类bottom class,它是所有类的子类,在开发中通常可以将Nothing类型的值返回给任意变量或者函数,这里抛出异常使用很多。

   ```scala
   package com.briup.bd1903.chapter02.datatype
   
   object TypeDemo02 {
     def main(args: Array[String]): Unit = {
       println(sayHello)
     }
   
     //比如开发中,我们有一个方法,就会异常中断,这时就可以返回Nothing
     //即当我们把Nothing做返回值时,就是明确说明该方法没有正常返回值
     def sayHello: Nothing = {
       throw new Exception("抛出异常")
     }
   }
   ```

5. 在scala中仍然遵守低精度的值向高精度的值自动转换(隐式转换)

   ```scala
   var num = 1.2 //默认为Double
       var num2 = 1.7f //这是Float
       //num2 = num//error 修改num2 = num.toFloat
   ```

## scala数据类型列表

| 数据类型 | 描述                                                         |
| -------- | ------------------------------------------------------------ |
| Byte     | 8位有符号补码整数。数值区间为 -128 到 127                    |
| Short    | 16位有符号补码整数。数值区间为 -32768 到 32767               |
| Int      | 32位有符号补码整数。数值区间为 -2147483648 到 2147483647     |
| Long     | 64位有符号补码整数。数值区间为 -9223372036854775808 到 9223372036854775807 |
| Float    | 32 位, IEEE 754标准的单精度浮点数                            |
| Double   | 64 位 IEEE 754标准的双精度浮点数                             |
| Char     | 16位无符号Unicode字符, 区间值为 U+0000 到 U+FFFF             |
| String   | 字符序列                                                     |
| Boolean  | true或false                                                  |
| Unit     | 表示无值，和其他语言中void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值，写成()。 |
| Null     | null                                                         |
| Nothing  | Nothing类型在Scala的类层级的最低端；它是任何其他类型的子类型。 |
| Any      | Any是所有其他类的超类                                        |
| AnyRef   | AnyRef类是Scala里所有引用类(reference class)的基类           |

### 整数类型

| 数据类型  | 描述                                                         |
| --------- | ------------------------------------------------------------ |
| Byte [1]  | 8位有符号补码整数。数值区间为 -128 到 127                    |
| Short [2] | 16位有符号补码整数。数值区间为 -32768 到 32767               |
| Int [4]   | 32位有符号补码整数。数值区间为 -2147483648 到 2147483647     |
| Long [8]  | 64位有符号补码整数。数值区间为 -9223372036854775808 到 9223372036854775807 = 2的(64-1)次方-1 |

**整型的使用细节**

1. Scala各整数类型有固定的表数范围和字段长度，不受具体OS的影响，以保证Scala程序的可移植性。

2. Scala的整型 常量/字面量  默认为 Int 型，声明Long型 常量/字面量 须后加‘l’’或‘L’ [反编译看]

3. Scala程序中变量常声明为Int型，除非不足以表示大数，才使用Long

   ```scala
   package com.briup.bd1903.chapter02.datatype
   
   object TypeDemo03 {
     def main(args: Array[String]): Unit = {
       println("Long的最大值" + Long.MaxValue + "Long的最小值" + Long.MinValue)
   	
       var c = 11 // c 就是Int类型
   	println("c=" + c)
   	var d = 12l // d 就是 Long 类型 或者 var d = 12L
   	println("d=" + d) 
   	
       var i = 10 // i Int
       var l = 10l // l Long
   	var e = 9223372036854775807 // 正确吗? 如何解决  
       //不正确,超过Int范围 var e = 9223372036854775807L
     }
   }
   ```

### 浮点类型

#### 基本介绍 

Scala的浮点类型可以表示一个小数，比如 123.4f，7.8 ，0.12等等

#### 浮点型的分类

| Float [4]  | 32 位, IEEE 754标准的单精度浮点数 |
| ---------- | --------------------------------- |
| Double [8] | 64 位 IEEE 754标准的双精度浮点数  |

#### 浮点型使用细节

1. 与整数类型类似，Scala 浮点类型也有固定的表数范围和字段长度，不受具体OS的影响。

2. Scala的浮点型常量默认为Double型，声明Float型常量，须后加‘f’或‘F’。

3. 浮点型常量有两种表示形式
          十进制数形式：如：5.12       512.0f        .512   (必须有小数点）
          科学计数法形式:如：5.12e2  = 5.12乘以10的2次方     5.12E-2  = 5.12除以10的2次方   

4. 通常情况下，应该使用Double型，因为它比Float型更精确(小数点后大致7位)

   //测试数据 ：2.2345678912f  , 2.2345678912

   ```scala
   	var num1: Float = 2.2345678912f
       var num2: Double = 2.2345678912
       println("num1:" + num1 + "num2:" + num2) //结果num1:2.2345679   num2:2.2345678912
   ```

### 字符类型(Char)

#### 基本介绍

字符类型可以表示单个字符,字符类型是Char， 16位无符号Unicode字符(2个字节), 区间值为 U+0000 到 U+FFFF

#### 字符类型使用细节

1) 字符常量是用单引号(‘ ’)括起来的单个字符。例如：var c1 = 'a‘   var c2 = '中‘  var c3 =  '9' 

2) Scala 也允许使用转义字符‘\’来将其后的字符转变为特殊字符型常量。例如：var c3 = ‘\n’  // '\n'表示换行符 

3)可以直接给Char赋一个整数，然后输出时，会按照对应的unicode 字符输出 ['\u0061' 97]

4) Char类型是可以进行运算的，相当于一个整数，因为它都对应有Unicode码。

![1568259451629](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1568259451629.png)

**问题：**
**var c2 : Char =  ‘a’ + 1  正确吗?**

**错误:Int不能转换为Char**

**var c1: Char = 'a'**

**var num: Int = 10 + c1+'b'**

**分析:**

1. **当把一个运算的结果赋值给一个变量,则编译期会进行类型转换及判断(即会可能范围+类型)**

2. **当把一个字面量赋值一个变量,则编译期会进行范围的判定**

   ```scala
   var c1: Char = 'a' + 1 //false
   var c2: Char = 97 + 1 //false
   var c3: Char = 98 //true
   var c4: Char = 99999 //false
   ```

#### 字符类型本质探讨

1. 字符型存储到 计算机中，需要将字符对应的码值（整数）找出来存储：字符——>码值——>二进制——>存储读取：二进制——>码值——> 字符——>读取
2. 字符和码值的对应关系是通过字符编码表决定的(是规定好)， 这一点和Java一样。

### 布尔类型:Boolean

1. 布尔类型也叫Boolean类型，Booolean类型数据只允许取值true和false
2. boolean类型占1个字节。
3. boolean 类型适于逻辑运算，一般用于程序流程控制：
   if条件控制语句；                  
   while循环控制语句；
   do-while循环控制语句；      
   for循环控制语句

### Unit类型、Null类型和Nothing类型

#### 基本说明

| Unit    | 表示无值，和其他语言中void等同。用作不返回任何结果的方法的结果类型。Unit只有一个实例值，写成()。 |
| ------- | ------------------------------------------------------------ |
| Null    | null , Null 类型只有一个实例值 null                          |
| Nothing | Nothing类型在Scala的类层级的最低端；它是任何其他类型的子类型。当一个函数，我们确定没有正常的返回值，可以用Nothing 来指定返回类型，这样有一个好处，就是我们可以把返回的值（异常）赋给其它的函数或者变量（兼容性） |

#### 使用细节和注意事项

1. Null类只有一个实例对象，null，类似于Java中的null引用。null可以赋值给任意引用类型(AnyRef)，但是不能赋值给值类型(AnyVal: 比如 Int, Float, Char, Boolean, Long, Double, Byte, Short)

2. Unit类型用来标识过程，也就是没有明确返回值的函数。由此可见，Unit类似于Java里的void。Unit只有一个实例:(),这个实例也没有实质的意义

3. Nothing，可以作为没有正常返回值的方法的返回类型，非常直观的告诉你这个方法不会正常返回，而且由于Nothing是其他任意类型的子类，他还能跟要求返回值的方法兼容。

4. 代码

   ```scala
   package com.briup.bd1903.chapter02.datatype
   object UnitNullNothingDemo {
     //Unit等价于java的void,只有一个实例值()
     def sayHello():Unit = {}
     def main(args: Array[String]): Unit = {
       val res = sayHello()
       println("res=" + res)
       //Null类只有一个实例对象，null，类似于Java中的null引用。
       // null可以赋值给任意引用类型(AnyRef),
       // 但是不能赋值给值类型(AnyVal: 比如 Int, Float, Char, Boolean, Long, Double, Byte, Short)
       val dog: Dog = null
   	//val char1: Char = null
   	//an expression of type Null is ineligible for implicit conversion
       println("ok~~~")
     }
   }
   class Dog{}
   ```

## 值类型转换

### 值类型隐式转换

#### 介绍

**当Scala程序在进行赋值或者运算时，精度小的类型自动转换为精度大的数据类型，这个就是自动类型转换(隐式转换)。**
**数据类型按精度(容量)大小排序为**![1568603806417](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\1568603806417.png)

#### 自动类型转换细节说明

1. 有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算。 5.6 + 10 = 》double

2. 当我们把精度(容量)大 的数据类型赋值给精度(容量)小 的数据类型时,就会报错，反之就会进行自动类型转换。

3. (byte, short) 和 char之间不会相互自动转换。

4. byte，short，char  他们三者可以计算，在计算时首先转换为int类型。

5. 自动提升原则： 表达式结果的类型自动提升为 操作数中最大的类型

   ```scala
   //1.有多种类型的数据混合运算时，系统首先自动将所有数据转换成容量最大的那种数据类型，然后再进行计算。
       var n1 = 10
       var n2 = 1.1f
       var n3 = n1 + n2
   
       //2.(byte, short) 和 char之间不会相互自动转换。
       var n4: Byte = 10
   //    var char1: Char = n4  //false,因为byte不能自动转换为char
   ```

#### 高级隐式转换和隐式函数

### 强制类型转换

#### 介绍

**自动类型转换的逆过程，将容量大的数据类型转换为容量小的数据类型。使用时要加上强制转函数，但可能造成精度降低或溢出,格外要注意。**

#### 演示

**java  :  int num = (int)2.5**
**scala :  var num : Int =  2.7.toInt  //对象**

#### 强制类型转换细节说明

1. 当进行数据的 从 大——>小，就需要使用到强制转换

2. 强转符号只针对于最近的操作数有效，往往会使用小括号提升优先级

   ```scala
   val num1: Int = 10 * 3.5.toInt + 6 * 1.5.toInt  // 36
   val num2: Int = (10 * 3.5 + 6 * 1.5).toInt // 44
   println(num1 + " " + num2)
   ```

3. Char类型可以保存 Int的常量值，但不能保存Int的变量值，需要强转

4. Byte和Short类型在进行运算时，当做Int类型处理。

#### 判断是否能够通过编译,并说明原因

1）var s : Short  = 5 // ok
      s = s-2    //  error  Int -> Short                
2） var b : Byte  = 3    // ok
       b = b + 4              // error Int ->Byte     
       b = (b+4).toByte       // ok ，使用强制转换
3）var c : Char  = 'a'  //ok
      var  i : Int = 5 //ok
      var d : Float = .314F //ok
      var result : Double = c+i+d     //ok Float->Double
4） var b : Byte  = 5 // ok
      var s : Short  = 3 //ok
       var t : Short = s + b // error Int->Short
       var t2 = s + b   // ok, 使用类型推导

### 值类型和String类型的转换

#### 介绍

在程序开发中，我们经常需要将基本数据类型转成String 类型。
或者将String类型转成基本数据类型。

#### 基本类型转String类型

语法： 将基本类型的值+"" 即可

#### String类型转基本数据类型

语法：通过基本类型的String的 toXxx方法即可

#### 注意事项

+ 在将String 类型转成 基本数据类型时，要确保String类型能够转成有效的数据，比如 我们可以把 "123" , 转成一个整数，但是不能把 "hello" 转成一个整数
+ 思考就是要把 "12.5" 转成 Int  //?

```scala
    val d1 = 1.2
    //基本数据类型转String类型
    val s1 = d1 + ""

    //String类型转基本数据类型
    val s2 = "12"
    val num2 = s2.toInt
    val num3 = s2.toLong
    val num4 = s2.toDouble
    val num5 = s2.toFloat

    //在将String 类型转成 基本数据类型时，要确保String类型能够转成有效的数据，比如 我们可以把 "123" , 转成一个整数，但是不能把 "hello" 转成一个整数
    val s3 = "hello"
//    println(s3.toInt) NumberFormatException

    //思考就是要把 "12.5" 转成 Int?
    //在scala中,不是将小数点后的数据进行截取,而是会抛出异常
    val s4 = "12.5"
//    println(s4.toInt) NumberFormatException,toDouble
```

# 标识符的命名规范

## 标识符概念

1. Scala 对各种变量、方法、函数等命名时使用的字符序列称为标识符
2. 凡是自己可以起名字的地方都叫标识符

## 标识符的命名规则(记住)

Scala中的标识符声明，基本和Java是一致的，但是细节上会有所变化。

1. 首字符为字母，后续字符任意字母和数字，美元符号，可后接下划线_
2. 数字不可以开头。
3. **首字符为操作符(比如+ - * / )，后续字符也需跟操作符 ,至少一个(反编译)**
4. 操作符(比如+-*/)不能在标识符中间和最后.
5. 用反引号`....`包括的任意字符串，即使是关键字(39个)也可以 [true]

```scala
hello    // ok
hello12 // ok
1hello  // error
h-b   // error
x h   // error
h_4   // ok
_ab   // ok
Int    // ok, 在scala中，Int 不是关键字，而是预定义标识符,可以用，但是不推荐
Float  // ok
_   // 不可以，因为在scala中，_ 有很多其他的作用，因此不能使用
Abc    // ok
+*-   // ok
+a  // error
```

```scala
    //首字符为操作符(比如+ - * / )，后续字符也需跟操作符 ,至少一个(反编译)**
    val ++ = "hello,world" //ok
    //++ => $plus$plus
    println(++)

    val -+ = 90 //ok
    println("res=" + -+)

    //    val +q = "+q" error

    //用反引号`....`包括的任意字符串，即使是关键字(39个)也可以 [true]
    var `true` = "hello,scala"
    println("内容=" + `true`)

    val Int = 90.45
    println("Int=" + Int)

	//不能使用下划线_做标识符
    val _ = "jack"
    println(_)
```

## 标识符命名注意事项

1. 包名：尽量采取有意义的包名，简短，有意义

2. 变量名、函数名 、方法名 采用驼峰法。

# Scala关键字

## 关键字介绍

Scala有39个关键字：

+ package, import, class, object, trait, extends, with, type, forSome
+ private, protected, abstract, sealed, final, implicit, lazy, override
+ try, catch, finally, throw 
+ if, else, match, case, do, while, for, return, yield
+ def, val, var 
+ this, super
+ new
+ true, false, null

# 运算符

## 运算符介绍

运算符是一种特殊的符号，用以表示数据的运算、赋值和比较等。
算术运算符
赋值运算符 
比较运算符(关系运算符)
逻辑运算符
位运算符

## 算术运算符

### 介绍

算术运算符(arithmetic)是对数值类型的变量进行运算的，在Scala程序中使用的非常多。

| **运算符** | **运算**   | **范例**   | **结果** |
| ---------- | ---------- | ---------- | -------- |
| **+**      | 正号       | +3         | 3        |
| **-**      | 负号       | b=4; -b    | -4       |
| **+**      | 加         | 5+5        | 10       |
| **-**      | 减         | 6-4        | 2        |
| *****      | 乘         | 3*4        | 12       |
| **/**      | 除         | 5/5        | 1        |
| **%**      | 取模(取余) | 7%5        | 2        |
| **+**      | 字符串相加 | “He”+”llo” | “Hello”  |

### 演示

案例演示算术运算符的使用(Operator.scala)。

1. +, - , * , / , %  重点讲解 /、%
2. +、-、* 是一个道理，完全可以类推。
3. 算数运算符的运算规则和Java一样

```scala
    /*
     假如还有97天放假，问：xx个星期零xx天
     1.搞清楚需求(读题)
     2.思路分析
     (1)变量保存97
     (2)使用/7 得到 几个星期
     (3)xx天 使用%
     3.代码实现
    */
    val day = 97
    printf("统计结果是 %d个星期零%d天", day / 7, day % 7)

    /*
    定义一个变量保存华氏温度，华氏温度转换摄氏温度的公式为：5.0/9*(华氏温度-100),请求出华氏温度对应的摄氏温度。[测试：232.5]
    分析
    1.变量保存华氏温度,变量保存摄氏温度
    2.公式使用
     */
    val huashi = 232.5
    val sheshi = 5.0 / 9 * (huashi - 100)
    println("对应的摄氏温度为:" + sheshi.formatted("%.2f"))
```

## 关系运算符(比较运算符)

### 基本介绍

1. 关系运算符的结果都是boolean型，也就是要么是true，要么是false
2. 关系表达式 经常用在 if结构的条件中或循环结构的条件中
3. 关系运算符的使用和java一样

| **运算符** | **运算                                 范例                                         结果** |
| ---------- | ------------------------------------------------------------ |
| **==**     | 相等于                               4==3                                                false |
| **!=**     | 不等于                               4!=3                                                 true |
| **<**      | 小于                                   4<3                                                   false |
| **>**      | 大于                                   4>3                                                   true |
| **<=**     | 小于等于                           4<=3                                                false |
| **>=**     | 大于等于                           4>=3                                                true |
|            |                                                              |

### 案例演示

案例演示关系运算符的使用(Operator02.scala)。

```scala
 	var a = 9
    var b = 8
    println(a>b)  // true
    println(a>=b) // true
    println(a<=b) // false
    println(a<b) // false
    println(a==b) // false
    println(a!=b) // true
    var flag : Boolean = a>b  // true
```

### 细节说明

1. 关系运算符的结果都是Boolean型，也就是要么是true，要么是false。
2. 关系运算符组成的表达式，我们称为关系表达式。 a > b 
3. 比较运算符“==”不能误写成“=”
4. 使用陷阱: 如果两个浮点数进行比较，应当保证数据类型一致.

## 逻辑运算符

### 介绍

用于连接多个条件（一般来讲就是关系表达式），最终的结果也是一个Boolean值。 

### 逻辑运算符一览

假定变量 A 为 true，B 为 false

| 运算符 | 描述   | 实例                       |
| ------ | ------ | -------------------------- |
| &&     | 逻辑与 | (A && B) 运算结果为 false  |
| \|\|   | 逻辑或 | (A \|\| B) 运算结果为 true |
| !      | 逻辑非 | !(A && B) 运算结果为 true  |

```scala
	var a = true
    var b = false
    println("a && b = " + (a && b))  // false
    println("a || b = " + (a || b)) // true
    println("!(a && b) = " + !(a && b)) // true
```

## 赋值运算符

### 介绍

赋值运算符就是将某个运算后的值，赋给指定的变量。

| 运算符 | 描述                                           | 实例                                  |
| ------ | ---------------------------------------------- | ------------------------------------- |
| =      | 简单的赋值运算符，将一个表达式的值赋给一个左值 | C = A + B 将 A + B 表达式结果赋值给 C |
| +=     | 相加后再赋值                                   | C += A 等于 C = C + A                 |
| -=     | 相减后再赋值                                   | C -= A 等于 C = C - A                 |
| *=     | 相乘后再赋值                                   | C *= A 等于 C = C * A                 |
| /=     | 相除后再赋值                                   | C /= A 等于 C = C / A                 |
| %=     | 求余后再赋值                                   | C %= A 等于 C = C % A                 |

| 运算符 | 描述           | 实例                       |
| ------ | -------------- | -------------------------- |
| <<=    | 左移后赋值     | C <<= 2  等于 C = C << 2   |
| >>=    | 右移后赋值     | C >>= 2  等于 C = C >> 2   |
| &=     | 按位与后赋值   | C &= 2   等于 C = C & 2    |
| ^=     | 按位异或后赋值 | C ^= 2    等于 C = C ^ 2   |
| \|=    | 按位或后赋值   | C \|= 2    等于 C = C \| 2 |

**说明：这部分的赋值运算涉及到二进制相关知识，其运行的规则和Java一样。**

### 赋值运算符特点

1. 运算顺序从右往左
2. 赋值运算符的左边 只能是变量,右边 可以是变量、表达式、常量值/字面量
3. 复合赋值运算符等价于下面的效果       
          比如：a+=3 等价于a=a+3

### 面试题

有两个变量，a和b，要求将其进行交换，但是不允许使用中间变量，最终打印结果:
val a = 10
val b = 20

## 位运算符

| 运算符 | 描述           | 实例                                                         |
| ------ | -------------- | ------------------------------------------------------------ |
| &      | 按位与运算符   | (a & b) 输出结果 12 ，二进制解释： 0000 1100                 |
| \|     | 按位或运算符   | (a \| b) 输出结果 61 ，二进制解释： 0011 1101                |
| ^      | 按位异或运算符 | (a ^ b) 输出结果 49 ，二进制解释： 0011 0001                 |
| ~      | 按位取反运算符 | (~a ) 输出结果 -61 ，二进制解释： 1100 0011， 在一个有符号二进制数的补码形式。 |
| <<     | 左移动运算符   | a << 2 输出结果 240 ，二进制解释： 1111 0000                 |
| >>     | 右移动运算符   | a >> 2 输出结果 15 ，二进制解释： 0000 1111                  |
| >>>    | 无符号右移     | A >>>2 输出结果 15, 二进制解释: 0000 1111                    |

### 运算符的特别说明

Scala不支持三目运算符 , 在Scala 中使用 if – else 的方式实现。
val num = 5 > 4 ? 5 : 4  //没有
val num = if (5>4) 5 else 4
案例1：求两个数的最大值
案例2：求三个数的最大值

```scala
    val num = if (5 > 4) 5 else 4
    //val num = 5>4?5:4 error

    /*
    案例1：求两个数的最大值
    案例2：求三个数的最大值
     */
    val n1 = 4
    val n2 = 8
    var res = if (n1 > n2) n1 else n2
    println("res = " + res)

    val n3 = 11
    res = if (res > n3) res else n3
    println("res = " + res)
```

## 运算符优先级

1)运算符有不同的优先级，所谓优先级就是表达式运算中的运算顺序。如右表，上一行运算符总优先于下一行。  2) 只有单目运算符、赋值运算符是从右向左运算的。
3) 运算符的优先级和Java一样。

| 类别 | 运算符                             | 关联性     |
| ---- | ---------------------------------- | ---------- |
| 1    | () []                              | 左到右     |
| 2    | ! ~                                | **右到左** |
| 3    | * / %                              | 左到右     |
| 4    | + -                                | 左到右     |
| 5    | >> >>> <<                          | 左到右     |
| 6    | > >= < <=                          | 左到右     |
| 7    | == !=                              | 左到右     |
| 8    | &                                  | 左到右     |
| 9    | ^                                  | 左到右     |
| 10   | \|                                 | 左到右     |
| 11   | &&                                 | 左到右     |
| 12   | \|\|                               | 左到右     |
| 13   | = += -= *= /= %= >>= <<= &= ^= \|= | **右到左** |
| 14   | ,                                  | 左到右     |

### 小结运算符的优先级

1.() []
2.单目运算
3.算术运算符
4.移位运算
5.比较运算符(关系运算符)
6.位运算
7.关系运算符
8.赋值运算

## 键盘输入语句

### 介绍

在编程中，需要接收用户输入的数据，就可以使用键盘输入语句来获取。InputDemo.scala

### 步骤 

1. 导入该类的所在包 
2. 创建该类对象（声明变量）
3. 调用里面的功能

### 演示

**要求：可以从控制台接收用户信息，【姓名，年龄，薪水】。**

1. 回顾Java的实现//不说明
2. Scala的实现 【 import scala.io.StdIn】

```scala
object Demo01 {
  def main(args: Array[String]): Unit = {
    /*
    控制台接收用户信息:姓名,年龄,薪水
     */
    println("请输入姓名:")
    val name = StdIn.readLine()

    println("请输入年龄:")
    val age = StdIn.readInt()

    println("请输入薪水:")
    val salary = StdIn.readDouble()


    Cat.sayHi()
    Cat.sayHello()

  }
}
//声明了一个对象(判断对象)
object Cat extends A {
  def sayHi(): Unit = {
    println("小狗汪汪叫~~~")
  }
}

trait A{  //A是特质,等价于java中的interface +  abstract class
  def sayHello(): Unit = {
    println("A sayHello")
  }
}
```

# 程序流程控制介绍

## 程序的流程控制说明

**在程序中**，程序运行的流程控制决定程序是如何执行的，是我们必须掌握的，主要有三大流程控制语句。

**温馨提示**： Scala语言中控制结构和Java语言中的控制结构基本相同，在不考虑特殊应用场景的情况下，代码书写方式以及理解方式都没有太大的区别


1. 顺序控制
2. 分支控制
3. 循环控制

## 顺序控制

### 顺序控制介绍

程序从上到下逐行地执行，中间没有任何判断和跳转。


### 顺序控制举例和注意事项

Scala中定义变量时采用合法的前向引用。如：
def main(args : Array[String]) : Unit = {
        var num1 = 12
        var num2 = num1 + 2
}
错误形式：
def main(args : Array[String]) : Unit = {
        var num2 = num1 + 2
        var num1 = 12
}

## 分支控制if-else

### 分支控制if-else介绍

让程序有选择的的执行,分支控制有三种:
单分支 
双分支 
多分支

### 单分支

#### 基本语法

if (条件表达式) {
	执行代码块
}
说明：当条件表达式为ture 时，就会执行 { } 的代码。
案例说明
编写一个程序,可以输入人的年龄,如果该同志的年龄大于18岁,则输出 “age > 18”

```SCALA
println("请输入年龄")
    val age = StdIn.readInt()
    if(age > 18){
      println("age > 18")
    }

    //如何查看某个包下包含的内容
    //1.比如查看scala.io包有什么内容
    //2.将光标放在io上,在ctrl+b
    scala.io.StdIn
```

### 双分支

#### 基本语法

​     if (条件表达式) {
​	执行代码块1
​      } else {
​	执行代码块2
​      }
说明：当条件表达式成立，即执行代码块1，否则执行代码块2.

案例演示
编写一个程序,可以输入人的年龄,如果该同志的年龄大于18岁,则输出 “age >18”。否则 ,输出 "age <= 18 "

```scala
val age = 6
    if(age > 18){
      println("age > 18")
    }else {
      println("age <= 18")
    }
```

练习:

```scala
//定义两个变量Int，判断二者的和，是否既能被3又能被5整除，打印提示信息
    val num1 = 10
    val num2 = 2
    val sum = num1 + num2
    if (sum % 3 == 0 && sum % 5 == 0) {
      println("能被3又能被5整除")
    }else{
      println("能被3又能被5整除不成立")
    }

    //判断一个年份是否是闰年，闰年的条件是符合下面二者之一：
    // (1)年份能被4整除，但不能被100整除；(2)能被400整除
    val year = 2018
    if((year % 4 == 0 && year % 100 !=0) || year % 400 ==0){
      println(s"$year 是闰年")
    }else {
      println(s"$year 不是闰年")
    }
```

### 多分支

#### 基本语法

​      if (条件表达式1) {
​	执行代码块1
​      }
​      else if (条件表达式2) {
​	执行代码块2
​      }
​       ……
​       else {
​	执行代码块n
​       }

#### 案例演示

岳小鹏参加scala考试，他和父亲岳不群达成承诺：
如果：
成绩为100分时，奖励一辆BMW；
成绩为(80，99]时，奖励一台iphone7plus；
当成绩为[60,80]时，奖励一个 iPad；
其它时，什么奖励也没有。

说明: 成绩在控制台输入!

```scala
println("请输入成绩")
    val score = StdIn.readDouble()
    if(score==100){
      println("成绩为100分")
    }else if(score>80&&score<=99){
      println("成绩为{80,99},奖励一台iphone7plus")
    }else if(score>=60&&score<=80){
      println("ipad")
    }else{
      println("奖励嘴巴子")
    }
```

求ax2+bx+c=0方程的根。a,b,c分别为函数的参数，如果：b2-4ac>0，则有两个解；
b2-4ac=0，则有一个解；b2-4ac<0，则无解； [a=3 b=100 c=6]
提示1：x1=(-b+sqrt(b2-4ac))/2a
               X2=(-b-sqrt(b2-4ac))/2a

提示2：sqrt(num)  在 scala 包中(默认引入的) 的math 的包对象有很多方法直接可用.

```scala
//求ax2+bx+c=0方程的根。a,b,c分别为函数的参数，如果：b2-4ac>0，则有两个解；
    //b2-4ac=0，则有一个解；b2-4ac<0，则无解； [a=3 b=100 c=6]
    //提示1：x1=(-b+sqrt(b2-4ac))/2a
    //               X2=(-b-sqrt(b2-4ac))/2a
    //提示2：sqrt(num)  在 scala 包中(默认引入的) 的math 的包对象有很多方法直接可用.
    val a = 3
    val b = 100
    val c = 6
    val m = b * b - 4 * a * c
    var x1 = 0.0
    var x2 = 0.0
    if (m > 0) {
      x1 = (-b + math.sqrt(m)) / 2 * a
      x2 = (-b - math.sqrt(m)) / 2 * a
    } else if (m == 0) {
      x1 = (-b + math.sqrt(m)) / 2 * a
    }else {
      println("无解")
    }
```

#### 分支控制if-else 注意事项

1. 如果大括号{}内的逻辑代码只有一行，大括号可以省略, 这点和java 的规定一样。

2. Scala中任意表达式都是有返回值的，也就意味着if else表达式其实是有返回结果的，具体返回结果的值取决于满足条件的代码体的最后一行内容.[案例演示]

3. Scala中是没有三元运算符，因为可以这样简写

| **// Java** int result = flg ? 1 : 0                         |
| ------------------------------------------------------------ |
| /**/ Scala val result = if (flg) 1 else** **0**   // 因为 scala 的if-else 是有返回值的，因此，本身这个语言也不需要三元运算符了(如图)，**并且**可以写在同一行，类似 三元运算 |

```scala
var sumVal = 9
    val result =
      if(sumVal > 20){
        "结果大于20"
      }
    println(result) //() 即Unit实例
```

### 嵌套分支

#### 基本介绍

在一个分支结构中又完整的嵌套了另一个完整的分支结构，里面的分支的结构称为内层分支外面的分支结构称为外层分支。嵌套分支不要超过3层

#### 基本语法

if(){        

if(){

}else{

 }
}

```scala
	//参加百米运动会，如果用时8秒以内进入决赛，否则提示淘汰。
    // 并且根据性别提示进入男子组或女子组.输入成绩和性别，进行判断。
    //double second; char gender;
    println("请输入运动员的成绩")
    val speed = StdIn.readDouble()
    if(speed <= 8){
      println("请输入你的性别")
      val gender = StdIn.readChar()
      if(gender == '男'){
        println("进入男子组")
      }else{
        println("进入女子组")
      }
    }else {
      println("你被淘汰了")
    }
```

```scala
/*
    出票系统：根据淡旺季的月份和年龄，打印票价
    4_10 旺季：
	    成人（18-60）：60
	    儿童（<18）:半价
	    老人（>60）:1/3
    淡季：
	    成人：40
	    其他：20
     */
    println("请输入月份")
    val month = StdIn.readInt()
    println("请输入年龄")
    val age = StdIn.readInt()
    val ticket = 60
    if(month >= 4 && month <=10){
      if(age >=18 && age <=60){
        println("你的票价是"+ticket)
      }else if(age<18){
        println("你的票价是"+ticket/2)
      }else{
        println("你的票价是"+ticket/3)
      }
    }else{
      if(age >=18 && age <=60) {
        println("你的票价是" + 40)
      }else{
        println("你的票价是" + 20)
      }
    }
```

## for循环控制

### 基本介绍

Scala 也为for 循环这一常见的控制结构提供了非常多的特性，这些for 循环的特性被称为for 推导式（for comprehension）或for 表达式（for expression）

### 范围数据循环方式1

基本案例
for(i <- 1 to 3){
  print(i + " ")
}
println()
说明
i 表示循环的变量， <- 规定好 to 规定
i 将会从 1-3 循环， 前后闭合

```scala
 	//输出10句"hello,scala"
    val start = 1
    val end = 10
    //1.start 从哪个数开始循环
    //2.to 关键字
    //3.end 循环结束的值
    //4.start to end 表示前后闭合
    for (i <- start to end) {
      println("hello,scala" + i)
    }

    //for这种推导式,也可以直接对集合进行遍历
    var list = List("hello", 10, 30, 't')
    for (item <- list) {
      println("item=" + item)
    }
```

### 范围数据循环方式2

基本案例
for(i <- 1 until 3) {
  print(i + " ")
}
println()
说明:
这种方式和前面的区别在于 i 是从1 到 3-1
前闭合后开的范围,和java的arr.length() 类似
for (int i = 0; i < arr.lenght; i++){}

```scala
	//输出10句"hell,scala"
    val start = 1
    val end = 10
    //循环的范围是start到end-1
    for(i <- start until end){
      println("hello,scala"+i)
    }
```

### 循环守卫

#### 基本案例

for(i <- 1 to 3 if i != 2) {
  print(i + " ")
}
println()

#### 基本案例说明

循环守卫，即循环保护式（也称条件判断式，守卫）。保护式为true则进入循环体内部，为false则跳过，类似于continue
上面的代码等价

for (i <- 1 to 3) {	

if (i != 2) {		

println(i+"")

}

}

### 引入变量

#### 基本案例

for(i <- 1 to 3; j = 4 - i) {
  print(j + " ")
}

#### 基本案例说明

没有关键字，所以范围后一定要加；来隔断逻辑
上面的代码等价

for ( i <- 1 to 3) {

val j = 4 –i

print(j+"")

}

### 嵌套循环

#### 基本案例

for(i <- 1 to 3; j <- 1 to 3) {
  println(" i =" + i + " j = " + j)
}

#### 基本案例说明

没有关键字，所以范围后一定要加；来隔断逻辑
上面的代码等价

for ( i <- 1 to 3) {	

for ( j <- 1to 3){		

​		println(i + " " + j + " ")	
}

}

### 循环返回值

#### 基本案例

val res = for(i <- 1 to 10) yield i
println(res)

#### 基本案例说明

**将遍历过程中处理的结果返回到一个新Vector集合中，使用yield关键字**

```scala
package com.briup.bd1903.chapter04.forloop

object YieldFor {
  def main(args: Array[String]): Unit = {
    //1.对i 1 to 10 进行遍历
    //2.yield i 将每次循环得到的i 放入到集合Vector中,并返回给res
    //3.i 这里可以是一个代码块,这就意味着我们可以对i进行处理
    //4.下面的这个方式就体现出scala一个重要的语法特点:将一个集合中的各个数据进行处理并返回给新的集合
    val res = for (i <- 1 to 10) yield {
      if (i % 2 == 0) {
        i
      } else {
        "不是偶数"
      }
    }
    println(res)
  }
}
```

### 使用花括号{}代替小括号()

#### 基本案例

for(i <- 1 to 3; j =  i * 2) {
  println(" i= " + i + " j= " + j)
}
可以写成
for{
      i <- 1 to 3
      j = i * 2} {
      println(" i= " + i + " j= " + j)
 }

#### 基本案例说明

1. {}和()对于for表达式来说都可以
2. for 推导式有一个不成文的约定：当for 推导式仅包含单一表达式时使用圆括号，当其包含多个表达式时使用大括号
3. 当使用{} 来换行写表达式时，分号就不用写了

### 注意事项和细节说明

1. scala 的for循环形式和java是较大差异,但是基本的原理还是一样的。
2. scala 的for循环的**步长**如何控制! [for(i <- Range(1,3,2)]
3. 思考题：如何使用循环守卫控制步长

```scala
package com.briup.bd1903.chapter04.forloop

object StepFor {
  def main(args: Array[String]): Unit = {
    //步长控制
    for (i <- 1 to 10) {
      println("i=" + i)
    }
    println("===============")
    //步长控制为2
    //Rang(1,10,2)的对应的构建方法是
    //def apply(start: Int, end: Int, step: Int): Range.Exclusive = new 	Range.Exclusive(start, end, step)
    for (i <- Range(1, 10, 2)) {
      println("i=" + i)
    }
    println("===============")
    //控制步长的第二种方式
    for (i <- 1 to 10 if i % 2 == 1) {
      println("i=" + i)
    }
  }
}
```

### for循环练习题

```scala
package com.briup.bd1903.chapter04.forloop

object ForExercise01 {
  def main(args: Array[String]): Unit = {
    //打印1~100之间所有是9的倍数的整数的个数及总和.
    val start = 1
    val end = 100
    var count = 0
    var sum = 0
    for (i <- start to end) {
      if (i % 9 == 0) {
        count += 1
        sum += i
      }
    }
    printf("count=%d,sum=%d\n", count, sum)

    //输出加法的循环表达式
    val num = 6
    for (i <- 0 to num) {
      printf("%d + %d = %d\n", i, num - i, num)
    }
  }
}
```

## while循环控制

### 基本语法

循环变量初始化
while (循环条件) {
           循环体(语句)
            循环变量迭代
}

### 注意事项和细节说明

1. 循环条件是返回一个布尔值的表达式
2. while循环是先判断再执行语句
3. 与If语句不同，While语句本身没有值，即整个While语句的结果是Unit类型的()
4. 因为while中没有返回值,所以当要用该语句来计算并返回结果时,就不可避免的使用变量 ，而变量需要声明在while循环的外部，那么就等同于循环的内部对外部的变量造成了影响，所以不推荐使用，而是推荐使用for循环。

```scala
package com.briup.bd1903.chapter04.whileloop

object WhileDemo01 {
  def main(args: Array[String]): Unit = {
    //输出10句"hello,scala"
    //循环变量
    var  i = 0
    while (i < 10 /*循环条件*/){
      printf("hello,scala" + i) //循环体
      //循环遍历迭代
      i += 1
    }
  }
}
```

## do..while循环控制

### 基本语法

 循环变量初始化;
   do{
               循环体(语句)
                循环变量迭代
   } while(循环条件)

```scala
package com.briup.bd1903.chapter04.dowhile

object DoWhileDemo01 {
  def main(args: Array[String]): Unit = {
    var i = 0
    do {
      println("hello,scala" + i)
      i += 1
    } while (i < 10)
  }
}
```



### 注意事项和细节说明

1. 循环条件是返回一个布尔值的表达式
2. do..while循环是先执行，再判断
3. 和while 一样，因为do…while中没有返回值,所以当要用该语句来计算并返回结果时,就不可避免的使用变量 ，而变量需要声明在do...while循环的外部，那么就等同于循环的内部对外部的变量造成了影响，所以不推荐使用，而是推荐使用for循环

## 多重循环控制

### 介绍

1. 将一个循环放在另一个循环体内，就形成了嵌套循环。其中，for ,while ,do…while均可以作为外层循环和内层循环。【建议一般使用两层，最多不要超过3层】

2. 实质上，嵌套循环就是把内层循环当成外层循环的循环体。当只有内层循环的循环条件为false时，才会完全跳出内层循环，才可结束外层的当次循环，开始下一次的循环。

3. 设外层循环次数为m次，内层为n次， 则内层循环体实际上需要执行m*n=mn次。

### 应用实例

1. 统计三个班成绩情况，每个班有5名同学，求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。

   ```scala
   package com.briup.bd1903.chapter04.mutilfor
   
   import scala.io.StdIn
   
   object Exercise {
     def main(args: Array[String]): Unit = {
       /*
       1. 统计三个班成绩情况，每个班有5名同学，求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
       分析思路
       (1)classNum 表示班级个数 stuNum 表示学生个数
       (2)classScore表示各个班级的总分 totalScore 表示所有班级总分
       (3)score 表示各个学生成绩
       (4)使用循环的方式输入成绩
       2. 统计三个班及格人数，每个班有5名同学。
       3. 打印出九九乘法表
        */
       val classNum = 3
       val stuNum = 5
       var score = 0.0 //分数
       var classScore = 0.0 //班级总分
       var totalScore = 0.0 //所有班级总分
       for (i <- 1 to classNum) {
         //先将classScore 清0
         classScore = 0.0
         for (j <- 1 to stuNum) {
           printf("请输入第%d班级的第%d个学生的成绩\n", i, j)
           score = StdIn.readDouble()
           classScore += score
         }
         //累计总分totalScore
         totalScore += classScore
         printf("第%d班级的平均分%.2f\n", i, classScore / stuNum)
       }
       printf("所有班级的平均分为%.2f\n", totalScore / (stuNum * classNum))
     }
   }
   ```

   

2. 统计三个班及格人数，每个班有5名同学。

   ```scala
   package com.briup.bd1903.chapter04.mutilfor
   
   import scala.io.StdIn
   
   object Exercise02 {
     def main(args: Array[String]): Unit = {
   //    统计三个班成绩情况，每个班有5名同学，求出各个班的平均分和所有班级的平均分[学生的成绩从键盘输入]。
   //    统计三个班及格人数，每个班有5名同学。
       val classNum = 3
       val stuNum = 5
       var score = 0.0 //分数
       var classScore = 0.0 //班级总分
       var totalScore = 0.0 //所有班级总分
       var passNum = 0 //统计及格人数
       for (i <- 1 to classNum) {
         //先将classScore 清0
         classScore = 0.0
         for (j <- 1 to stuNum) {
           printf("请输入第%d班级的第%d个学生的成绩\n", i, j)
           score = StdIn.readDouble()
           if( score >= 60){
             passNum += 1
           }
           classScore += score
         }
         //累计总分totalScore
         totalScore += classScore
         printf("第%d班级的平均分%.2f\n", i, classScore / stuNum)
       }
       printf("所有班级的平均分为%.2f\n", totalScore / (stuNum * classNum))
       printf("所有班级的及格人数为%d\n", passNum)
     }
   }
   ```

   

3. 打印出九九乘法表 

   ```scala
   package com.briup.bd1903.chapter04.mutilfor
   
   object Exercise03 {
     def main(args: Array[String]): Unit = {
       //3. 打印出九九乘法表
       //使用两次循环,有9行,每一行的列数在增加
       val num = 9
       for (i <- 1 to num) { //行
         for (j <- 1 to i) { //列
           printf("%d * %d = %d\t", j, i, i * j)
         }
         println()
       }
     }
   }
   ```

## while循环的中断(for)

### 基本说明

**Scala内置控制结构特地去掉了break和continue，是为了更好的适应函数化编程，推荐使用函数式的风格解决break和contine的功能，而不是一个关键字。**

```scala
package com.briup.bd1903.chapter04.mybreak

import util.control.Breaks._

object WhileBreak {
  def main(args: Array[String]): Unit = {
    var n = 1
    //breakable是一个高阶函数,可以接收函数的函数就是高阶函数
    /*
    def breakable(op: => Unit): Unit = {
    try {
      op
    } catch {
      case ex: BreakControl =>
        if (ex ne breakException) throw ex
    }
  }
  1.op: => Unit表示接收的参数是一个没有输入,也没有返回值的函数
  2.可以简单理解可以接收一段代码块
  3.breakable对break()抛出的异常做了处理,代码就继续执行
  4.当我们传入的是代码块,scala程序员会将()改成{}
     */
    breakable {
      while (n <= 20) {
        n += 1
        println("n=" + n)
        if (n == 18) {
          //中断while循环
          break()
        }
      }
    }
    println("ok~~~")
  }
}
```



### 如何实现continue的效果

**Scala内置控制结构特地也去掉了continue，是为了更好的适应函数化编程，可以使用if – else 或是 循环守卫实现continue的效果**
for (i <- 1 to 10 if (i != 2 && i != 3)) {
println("i=" + i)
}

```scala
package com.briup.bd1903.chapter04.mycontinue

object ContinueDemo {
  def main(args: Array[String]): Unit = {
    //用循环守卫实现continue效果 条件为真才执行循环体
    //即当i==2或者i==3时,就跳过
    for (i <- 1 to 10 if (i != 2 && i != 3)) {
      println("i=" + i)
    }

    //也可以写成如下形式
    println("================")
    for (i <- 1 to 10 ) {
      if (i != 2 && i != 3){
        println("i=" + i)
      }
    }
  }
}
```

```scala
//注意break函数,可以使用在for或者do..while
breakable {
      for (i <- 1 to 100) {
        println("i=" + i)
        if (i == 20) {
          break()
        }
      }
    }
    println("ok2~~~")
```

例题:

```scala
package com.briup.bd1903.chapter04.homework

import util.control.Breaks._

object HomeWork01 {
  def main(args: Array[String]): Unit = {
    /*
    100以内的数求和,求当和第一次大于20的当前数
     */
    var num = 0
    breakable {
      for (i <- 1 to 100) {
        num += i
        if (num > 20) {
          println("第一次大于20的当前数是" + i)
          break()
        }
      }
    }

    //除了break机制来中断之外,使用循环守卫
    println("===============")
    var loop = true
    var sum = 0
    for (i <- 1 to 100 if loop == true) {
      sum += i
      if (sum > 20) {
        println("循环守卫实现中断 第一次大于20的当前数=" + i)
        loop = false
      }
      println("i=" + i)
    }

  }
}
```

