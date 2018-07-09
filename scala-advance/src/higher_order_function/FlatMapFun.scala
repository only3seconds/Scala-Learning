package higher_order_function

/**
  * flatMap 函数, flatMap与map唯一不一样的地方就是传入的函数在处理完后返回值必须是List
  */
object FlatMapFun {
  def main(args: Array[String]): Unit = {
    val list1 = List(List(1, 2, 3), List(2, 3, 4))
    println("list1 = " + list1)
    val list2 = list1.flatMap(x => x)
    println("list2 = " + list2)
  }

}
