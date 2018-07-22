# 模式匹配 & case class

- 在 java 语言中存在 switch 语句，在实际编码中程序员容易忽略 break 语句，导致意外掉入另一个分支。Scala 利用模式匹配解决了这个问题，并且提供了更为灵活的匹配方式。

## 一. 模式匹配简介
代码：

```scala
package pattern_matching

import scala.collection.mutable.ArrayBuffer

/**
  * Scala 模式匹配
  */
object PatternMatching extends App {
  var list = new ArrayBuffer[Int]()
  var x = 0

  for(i <- 1 to 50) {
    i match {
      // 可以跟表达式
      case 10 => x = 10
      case 30 => println(30)
      case 50 => println(50)
      // 增加守卫条件
      case _ if(i % 4 == 0) => list.append(i)
      case _ if(i % 3 == 0) => println(i + ": 能被3整出")
      case _ =>
    }
  }

  println("能被4整除的数：" + list)
  println("x = " + x)

}
```

运行结果：

```
3: 能被3整出
6: 能被3整出
9: 能被3整出
15: 能被3整出
18: 能被3整出
21: 能被3整出
27: 能被3整出
30
33: 能被3整出
39: 能被3整出
42: 能被3整出
45: 能被3整出
50
能被4整除的数：ArrayBuffer(4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48)
x = 10
```

## 二. Case Class 样例类

- Case class 是一种特殊的类，能够被优化用于模式匹配


- 当一个类被声明为 case class 时，scala 会做以下事情：

	（1）构造器中的参数如果不被声明为 var ，则默认为 val, 不建议声明为 var
	
	（2）自动创建伴生对象，同时在里面实现好了 apply 方法，我们可以不用显示 new 一个对象
	
	（3）伴生对象实现了 unapply 方法，从而可以将 case class 用于模式匹配
	
	（4）实现自己的 toString、hashcode、equals、copy方法
	
- 在进行模式匹配的时候，有时需要所有的情况都被列出，此时常常将 case class 的超类定义为 sealed（密封的）

- 除了模式匹配，case class 在实际中还有其他重要应用

代码：

```scala
package pattern_matching

/**
  * case class 样例类
  */

// sealed的作用：模式匹配时，如果没有匹配所有的情况，编译器会提示
sealed abstract class Person

// 样例类
case class Student(name: String, age: Int, studentNo: Int) extends Person
case class Teacher(name: String, age: Int, teacherNo: Int) extends Person
case class Nobody(name: String) extends Person

// 接受多个 Person 类型参数
case class SchoolClass(description: String, persons: Person*)

object CaseClassDemo {

  def main(args: Array[String]): Unit = {
    val p: Person = Student("Mary", 24, 1001)

    p match {
      case Student(_, age, studentNo) => println("Student:" + " age = " + age + " studentNo = " + studentNo)
      case Teacher(name, age, teacherNo) => println("Teacher: name = " + name + " age = " + age + " studentNo = " + teacherNo)
      //case Nobody(name) => println("Nobody: name = " + name)
    }

    val t = Teacher("John", 38, 2918)

    // 无参 copy 方法
    val t1 = t.copy()
    println(t1)
    // copy 方法是深拷贝
    println("t equals t1 = " + (t equals t1))
    println("t eq t1 = " + (t eq t1))

    println("带一个参数的 copy 方法：" + t.copy(name = "Bob"))
    println("带两个参数的 copy 方法：" + t.copy(name = "Bob", age = 40))
    println("带三个参数的 copy 方法：" + t.copy(name = "Bob", age = 40, teacherNo = 2919))

    // hashcode 方法
    println("hashcode = " + t.hashCode)

    // toString 方法
    println("toString = " + t.toString)

    val sc = SchoolClass("Scala Learning", Teacher("Bob", 35, 2918), Student("Mary", 24, 1001))

    sc match {
      case SchoolClass(_, _, Student(name, age, studentNo)) => println("SchoolClass Student: " + name)
      case _ => println("Nobody")
    }
  }
}
```

运行结果：

```
Student: age = 24 studentNo = 1001
Teacher(John,38,2918)
t equals t1 = true
t eq t1 = false
带一个参数的 copy 方法：Teacher(Bob,38,2918)
带两个参数的 copy 方法：Teacher(Bob,40,2918)
带三个参数的 copy 方法：Teacher(Bob,40,2919)
hashcode = 725259313
toString = Teacher(John,38,2918)
SchoolClass Student: Mary
```

## 三. 模式匹配的类型

### 1. 常量模式

代码：

```scala
package pattern_matching

/**
  * 常量模式匹配
  */
object ConstantPattern {

  def main(args: Array[String]): Unit = {

    // Scala 可以在一个函数体中定义另外一个函数
    def patternShow(x:Any) = x match {
      case 5 => "five"
      case true => "true"
      case "test" => "String"
      case null => "null"
      case Nil => "empty list"
      case _ => "other constants"
    }

    println(patternShow(5))
    println(patternShow("Good Morning!"))
  }

}
```

运行结果：

```
five
other constants
```

### 2. 变量模式

代码：

```scala
package pattern_matching

/**
  * 变量模式匹配
  */
object VariablePattern {
  def main(args: Array[String]): Unit = {

    def patternShow(x:Any) = x match {
      case 5 => "five"
      case y => y
    }

    println("Scala is beautiful!")
  }
}
```

运行结果：

```
Scala is beautiful!
```

### 3. 构造器模式

- 构造器模式必须将类定义为 case class

代码：

```scala
package pattern_matching

/**
  * 构造器模式
  */
case class Animal(name: String, age: Int)

object ConstructorPattern {
  def main(args: Array[String]): Unit = {
    val animal = new Animal("Dog", 4)

    def constructorPattern(animal: Animal) = animal match {
      case Animal(name, age) => "Animal"
      case _ => "Other"
    }

    println(constructorPattern(animal))
    
  }

}
```
运行结果:

	Animal
	
### 4. 序列(Sequence)模式

- 序列模式指的是对像 Array、List这样的序列集合进行模式匹配

代码：

```scala
package pattern_matching

/**
  * 序列模式
  */
object SequencePattern {

  def main(args: Array[String]): Unit = {
    val p1 = List("spark", "hive", "hadoop")
    val p2 = List("Spark")

    def sequencePattern(p: List[String]) = p match {
      //只需要匹配第二个元素
      case List(_, second, _*) => second
      case _ => "Other"
    }

    println(sequencePattern(p1))
    println(sequencePattern(p2))

  }

}
```
运行结果：

```
hive
Other
```

### 5. 元组模式

- 匹配某个元组内容

代码：

```scala
package pattern_matching

/**
  * 元组模式
  */
object TuplePattern {

  def main(args: Array[String]): Unit = {
    val t = ("spark", "hive", "hadoop")

    def tuplePattern(t: Any) = t match {
      case (one, _, _) => one
      case _ => "Other"
    }

    println(tuplePattern(t))
  }
}
```
运行结果：

	spark
	
### 6. 类型模式

- 类型模式：匹配传入参数的类型

代码：

```scala
package pattern_matching

/**
  * 类型模式
  */
object TypePattern {

  def main(args: Array[String]): Unit = {

    def typePattern(t: Any) = t match {
      case t: String => "String"
      case t: Int => "Int"
      case t: Double => "Double"
    }

    println(typePattern(9.99))
  }

}
```

运行结果：

	Double
	
### 7. 变量绑定模式

代码：

```scala
package pattern_matching

/**
  * 变量绑定模式
  */
object VariableBindingPattern {
  def main(args: Array[String]): Unit = {
    var list = List(List(1, 2, 3), List(2, 3, 4))

    def variableBindingPattern(t: Any) = t match {
      // 利用变量 e 和 @ 进行匹配， 返回匹配结果
      case List(_, e@List(_, _, _)) => e
      case _ => Nil
    }

    println(variableBindingPattern(list))
  }

}
```

运行结果：

	List(2, 3, 4) 

## 四. for 控制结构中的模式匹配

- for 循环可用于对 Map 、正则表达式进行模式匹配

代码：

```scala
package pattern_matching

/**
  * for 控制结构中的模式匹配
  */
object PatternInForLoop {
  def main(args: Array[String]): Unit = {
    val countries = Map("China" -> "Beijing", "Japan" -> "Tokyo", "America" -> "Washington")

    //利用 for 循环对 Map 进行模式匹配输出
    for((nation, capital) <- countries)
      println(nation + " : " + capital)


    val ipRegex = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r

    // 利用 for 循环对正则表达式进行模式匹配
    for(ipRegex(one, two, three, four) <- ipRegex.findAllIn("192.168.1.1")) {
      println("IP 子段1：" + one)
      println("IP 子段2：" + two)
      println("IP 子段3：" + three)
      println("IP 子段4：" + four)
    }
  }

}
```

运行结果：

```
China : Beijing
Japan : Tokyo
America : Washington
IP 子段1：192
IP 子段2：168
IP 子段3：1
IP 子段4：1
```

## 五. Option 类型模式匹配

- Option 类其实是一个 sealed class

- Some 是一个 case class

- None 是一个 case object, case object 中不存在 apply 和 unapply 方法， None 不需要进行对象创建和内容提取

代码：

```scala
package pattern_matching

/**
  * Option 类型模式匹配
  */
object OptionDemo extends App{
  val map = Map("hive" -> 2, "spark" -> 3, "Spark MLlib" -> 4)

  def mapPattern(s: String) = map.get(s) match {
    case Some(x) => x
    case None => println("None"); -1
  }

  println(mapPattern("spark"))
  println(mapPattern("Hive"))

}
```

运行结果：

```
3
None
-1
```

