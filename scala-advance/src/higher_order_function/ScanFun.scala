package higher_order_function

/**
  * scan 函数
  */
object ScanFun {
  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5)
    val array1 = array.scanLeft(0)((x: Int, y: Int) => {println(x, y); x + y})
    print("array.scanLeft = ")
    for(i <- array1) print(i + " ")
    
    println()

    val array2 = array.scanRight(0)((x: Int, y: Int) => {println(x, y); x + y})
    print("array.scanRight = ")
    for(i <- array2) print(i + " ")
  }

}
