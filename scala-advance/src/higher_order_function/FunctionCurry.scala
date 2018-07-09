package higher_order_function

/**
  * 函数柯里化
  */
object FunctionCurry {
  def main(args: Array[String]): Unit = {
    // 函数 multiplyBy 返回的函数作为值函数赋值给变量x
    val x = multiplyBy_1(10)
    // 调用函数 x
    println("调用结果：" + x(5))

    println("函数柯里化，调用结果：" + multiplyBy_2(10)(5))

    // 偏函数（部分应用函数）
    val x1 = multiplyBy_2(10)_
    println("偏函数，调用结果：" + x1(5))

  }

  def multiplyBy_1(factor:Double) = (x:Double) => factor * x

  // 函数柯里化
  def multiplyBy_2(factor:Double)(x:Double) = factor * x



}
