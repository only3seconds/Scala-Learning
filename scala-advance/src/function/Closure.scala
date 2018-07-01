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
