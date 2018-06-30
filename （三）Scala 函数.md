# Scala 函数

## 一. 函数字面量（值函数）

- 函数字面量（function literal），也称值函数（function values），指的是函数可以赋值给变量。

代码：

```scala
package function

/**
  * 函数字面量
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


  }

}
```

运行结果：

	调用 increase1: 11
	Hello
	Scala
	调用 increase2: 11
	数组的 map 方法中调用：2,3,4
	
## 二. 匿名函数