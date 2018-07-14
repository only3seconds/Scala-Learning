# Scala 函数


## 一. 函数字面量（值函数）

- 函数字面量（function literal），也称值函数（function values），指的是函数可以赋值给变量。

代码：

```scala
package function

/**
  * 函数字面量（值函数）
  */
object FunctionLiteral {

  def main(args: Array[String]): Unit = {
    // 函数体只有一条语句
    val increase1 = (x: Int) => x + 1
    println("调用 increase1: " + increase1(10))

    // 函数体有多条语句
    val increase2 = (x: Int) => {
      println("Hello")
      println("Scala")
      x + 1
    }
    println("调用 increase2: " + increase2(10))

    // 数组的 map 方法中调用
    println("数组的 map 方法中调用：" + Array(1, 2, 3).map(increase1).mkString(","))

    // 函数简化
    val increase3 = 1 + (_: Double)
    println("调用 increase3: " + increase3(10))

    val increase4: (Double) => Double = 1 + _
    println("调用 increase4: " + increase4(10))

  }

}

```

运行结果：

	调用 increase1: 11
	Hello
	Scala
	调用 increase2: 11
	数组的 map 方法中调用：2,3,4
	调用 increase3: 11.0
	调用 increase4: 11.0
	
## 二. 匿名函数

- 匿名函数：箭头左边是参数列表，右边是函数体。

代码：

```scala
package function

/**
  * 匿名函数  函数参数 => 函数体
  */
object AnonymousFunction {

  def main(args: Array[String]): Unit = {
    // 匿名函数
    println(Array(1, 2, 3, 4).map((x:Int) => x + 1).mkString(","))

    // 函数简化

    println(Array(1, 2, 3, 4).map{(x:Int) => x + 1}.mkString(","))

    // 省略符号 .
    println(Array(1, 2, 3, 4) map((x:Int) => x + 1) mkString(","))

    // 参数类型推断
    println(Array(1, 2, 3, 4) map((x) => x + 1) mkString(","))

    // 函数只有一个参数的话
    println(Array(1, 2, 3, 4) map(x => x + 1) mkString(","))

    // 如果参数右边只出现一次
    println(Array(1, 2, 3, 4).map(_ + 1).mkString(","))

  }

}
```

运行结果：

	2,3,4,5
	2,3,4,5
	2,3,4,5
	2,3,4,5
	2,3,4,5
	2,3,4,5
	
## 三. 高阶函数
- 高阶函数（Higher-Order Function）就是操作其他函数的函数。

- Scala 中允许使用高阶函数, 高阶函数可以使用其他函数作为参数，或者使用函数作为输出结果。

代码：

```scala
package function

/**
  * 高阶函数：就是操作其他函数的函数
  */
object HigherOrderFunction {

  def main(args: Array[String]): Unit = {

    println("调用函数 convertIntToString: " + convertIntToString((x: Int) => x + " s"))

    val newFun = multiplyBy(10)
    println("调用函数 multiplyBy: " + newFun(5))

  }

  // 函数作为参数
  def convertIntToString(f: (Int) => String) = f(4)

  // 函数作为函数体，高阶函数可以产生新的函数
  def multiplyBy(factor: Double) = (x: Double) => factor * x

}
```

运行结果：

	调用函数 convertIntToString: 4 s
	调用函数 multiplyBy: 50.0
	
## 四. 闭包

- 闭包：闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量。

代码：
 
```scala
package function

/**
  * 闭包：闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量。
  */

object Closure {

  def main(args: Array[String]): Unit = {
    var more = 1
    // more:自由变量，在运行时其值才得以确定；x:绑定变量，类型确定，其值在函数调用时被赋值
    // 这种函数成为闭包函数
    val fun1 = (x: Int) => x + more

    println("调用函数fun1: " + fun1(10))

    more = 10
    println("再次调用函数fun1: " + fun1(10))

    val somNumbers = List(10, 9, 0, -9)
    var sum = 0

    somNumbers.foreach(sum += _)
    println("sum = " + sum)
    somNumbers.foreach(sum += _)
    println("sum = " + sum)
    
  }

}
```

运行结果：

	调用函数fun1: 11
	再次调用函数fun1: 20
	sum = 10
	sum = 20
 
