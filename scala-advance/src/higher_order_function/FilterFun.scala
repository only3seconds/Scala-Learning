package higher_order_function

/**
  * filter 函数， 过滤
  */
object FilterFun {
  def main(args: Array[String]): Unit = {
    val array1 = Array(1, 2, 3, 4, 5)
    print("array1 = ")
    array1.foreach(x => print(x + " "))
    val array2 = array1.filter(_>3)
    print("\narray2 = ")
    array2.foreach(x => print(x + " "))
  }

}
