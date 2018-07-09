package higher_order_function

/**
  * reduce 函数，使用reduce可以处理集合的每个元素并返回一个值,reduce 不保证方向
  * 通过使用 reduceLeft 和 reduceRight 可以强制处理元素的方向
  */
object ReduceFun {
  def main(args: Array[String]): Unit = {
    // 方法一
    val array = Array(1, 2, 3, 4, 5)
    print("array = ")
    for(i <- array) print(i + " ")

    val sum1 = array.reduce(_+_)
    println("\nsum1 = " + sum1)

    // 方法二
    val sum2 = array.reduce((x: Int, y: Int) => { println(x, y); x + y })
    println("reduce sum2 = " + sum2)

    val sum3 = array.reduceLeft((x: Int, y: Int) => { println(x, y); x + y })
    println("reduceLeft sum3 = " + sum3)

    val sum4 = array.reduceRight((x: Int, y: Int) => { println(x, y); x + y })
    println("reduceRight sum4 = " + sum4)

    // List
    val list = List("Spark", "Hive", "Hadoop")
    println("list1 = " + list)

    val str = list.reduce(_+_)
    println("str = " + str)
  }

}
