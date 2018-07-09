# 特征 Traits 

- 对于不存在具体实现及字段的 trait, 它最终生成的字节码文件反编译后等同于 java 中的接口

- 带有具体实现的 trait 是通过 java 中的抽象类来实现的

- 注意：trait 重的抽象属性和方法都不要用 abstract

- 即使 trait 中没有抽象的方法也是合理的

- trait 有自己的构造器，它是无参构造器，不能定义 trait 带参数的构造器。除此之外， trsit 和普通的 scala 类没有区别

## 一. trait 构造顺序
trait 构造器按照以下顺序执行：

- 1.如果有超类，则先调用超类的构造器

- 2.如果有父 trait, 它会按照继承层次先调用父 	trait 的构造器

- 3.如果有多个父 trait,则按顺序从左到右执行

- 4.所有父类，父 trait 构造完之后，才会构造本类

代码：

```scala
package scala_trait

import java.io.PrintWriter

/**
  * trait 构造顺序
  */


trait Logger {
  println("Logger")

  def log(msg: String): Unit

}

trait FileLogger extends Logger {
  println("FileLogger")
  val fileOutput = new PrintWriter("file.log")
  fileOutput.println("#")

  def log(msg: String): Unit = {
    fileOutput.print(msg)
    fileOutput.flush()
  }
}

object TraitDemo {
  def main(args: Array[String]): Unit = {

    // 匿名类
    new FileLogger {}.log("trait demo")
  }
}

```

运行结果：

	// 打印输出内容为：
	Logger
	FileLogger

	//创建文件 file.log，内容为：
	#
	trait demo

## 二. 懒加载

- 虽然子类可以对抽象成员变量进行重写，编译也能通过，但实际执行会出现空指针异常，具体原因是 trait 构造器执行顺序问题

- 解决办法：懒加载，lazy 方式定义只有当被真正使用时才被初始化

- lazy 只能修饰 val 类型变量

代码：

```scala
package scala_trait

import java.io.PrintWriter

/**
  * lazy 懒加载
  */

trait Logger {
  println("Logger")

  def log(msg: String): Unit

}

trait FileLogger extends Logger {
  println("FileLogger")
  val fileName: String
  lazy val fileOutput = new PrintWriter(fileName)
  // fileOutput.println("#") 这句也会报 NullPointerException

  def log(msg: String): Unit = {
    fileOutput.print(msg)
    fileOutput.flush()
  }
}

class Person

class Student extends Person with FileLogger {
  val fileName = "file.log"
}
object TraitDemo {
  def main(args: Array[String]): Unit = {

    val s = new Student
    s.log("lazy variable")
  }
}
```

运行结果：

	// 打印输出内容为：
	Logger
	FileLogger

	//创建文件 file.log，内容为：
	lazy variable

## 三. trait 继承类

代码：

```scala
package scala_trait

import java.io.IOException

trait Logger_1 {
  def log(msg: String): Unit
}

trait ExceptionLogger extends Exception with Logger {

  // 可以不写 override
  def log(msg: String): Unit = {
    println(getMessage)
  }
}

// 注意是 extends，ExceptionLogger 的父类 Exception 自动成为 UnprintedException 的父类
class UnprintedException extends ExceptionLogger {
  // 必须写 override
  override def log(msg: String): Unit = {
    println(" ")
  }
}

// IOException 和 ExceptionLogger 都有父类 Exception, scala 会让 UnprintedException1 只有一个父类 Exception
class UnprintedException1 extends IOException with ExceptionLogger {
  // 必须写 override
  override def log(msg: String): Unit = {
    println(" ")
  }
}
```
## 四. self type 自身类型

- 自身类型的存在相当于让当前类变得“抽象”了，它假设当前对象（this) 也符合指定的类型，因为自身类型：this:X => 的存在，当前类构造实例时需要同时满足X类型.

代码：

```scala
package scala_trait

/**
  * self type 自身类型
  */
trait X {
  def foo()
}

class B{
  // 定义了自身类型, 要求 B 在实例化时或定义 B 的子类时， 必须混入指定的 X 类型，这个 X 类型也可以指定为当前类型
  self:X=>
}

// 类 C 扩展 B 的时候必须混入 trait X
class C extends B with X{
  def foo = println("self type demo")
}

object SelfTypeDemo extends App{
  println(new C().foo)
  // println(println())  （）可以作为 Unit 的实例
}
```

运行结果：

	self type demo
	()