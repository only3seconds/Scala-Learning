package implicit_conversion

/**
  * 函数中隐式参数使用要点
  */

object ImplicitParameterInFunction {
  // implicit 作用于 x 和 y
  def sum1(implicit x: Int, y: Int) = x + y
  // 不能期望 implicit 只作用于某一个参数，以下两个定义报错
  //def sum(implicit x: Int, implicit y: Int) = x + y
  //def sum(implicit x: Int, implicit y: Int) = x + y

  def sum2(x: Int)(implicit y: Int) = x + y
  // 以下两个定义也不允许
  //def sum2(x: Int)(implicit y: Int)(z: Int) = x + y + z
  //def sum2(x: Int)(implicit y: Int)(implicit z: Int) = x + y + z
  // 如果函数带有隐式参数，则不能使用其偏函数
  //def sum2_2 = sum2 _

  def main(args: Array[String]): Unit = {
    // 注意：sum1 在使用时也只能定义一个隐式参数
    //implicit val x: Int = 3
    implicit val y: Int = 4
    println("sum1 = " + sum1)

    println("sum2 = " + sum2(3))

    // 匿名函数不能使用隐式参数
    // val sum3 = (implicit x: Int) => x + 1
  }

}
