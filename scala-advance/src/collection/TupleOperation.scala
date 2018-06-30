package collection

object TupleOperation {

  def main(args: Array[String]): Unit = {

    // 定义 tuple
    val tuple = ("Hello", 520, 'a')
    println("tuple = " + tuple)

    // 访问元组元素
    println("通过下标访问数组元素：")
    println("第一个元素为：" + tuple._1)
    println("第二个元素为：" + tuple._2)
    println("第三个元素为：" + tuple._3)

    // 通过模式匹配访问元组元素
    println("通过模式匹配访问元组元素：")
    val (first, second, third) = tuple
    println("第一个元素为：" + first)
    println("第二个元素为：" + second)
    println("第三个元素为：" + third)
  }

}
