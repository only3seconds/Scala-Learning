package higher_order_function

/**
  * 部分应用函数
  */
object PartApplicationFun {

  def main(args: Array[String]): Unit = {

    // 不指定任何参数的部分应用函数
    val fun0 = sum _
    println("调用 fun0: " + fun0(1, 2, 3))

    // 指定一个参数的部分应用函数
    val fun1 = sum(1, _:Int, _:Int)
    println("调用 fun1: " + fun1(2, 3))

    // 指定两个参数的部分应用函数
    val fun2 = sum(1, _:Int, 3)
    println("调用 fun2: " + fun2(2))


  }

  def sum(x:Int, y:Int, z:Int) = x + y + z

}
