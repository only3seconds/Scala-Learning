package higher_order_function

/**
  * fold 函数
  */
object FoldFun {

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5)
    val sum1 = array.foldLeft(0)((x: Int, y: Int) => {println(x, y); x + y})
    println("sum of array = " + sum1)

    val sum2 = array.foldRight(6)((x: Int, y: Int) => {println(x, y); x + y})
    println("add 6, sum of array = " + sum2)


  }

}
