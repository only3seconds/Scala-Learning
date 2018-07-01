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

  // 函数作为函数体，高阶函数可以产生新的函数 (同时这也是一种闭包函数）
  def multiplyBy(factor: Double) = (x: Double) => factor * x

}
