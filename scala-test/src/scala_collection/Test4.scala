package scala_collection

/**
  * List.tabulate() 方法是通过给定的函数来创建列表。
  * 方法的第一个参数为元素的数量，可以是二维的，第二个参数为指定的函数,函数计算结果插入到列表中，起始值为 0
  */
object Test4 {

  def main(args: Array[String]): Unit = {
    val squares = List.tabulate(6)(n => n * n);
    println("一维列表为：" + squares);

    val mul = List.tabulate(4,5)(_ * _);
    println("二维列表为： " + mul);

  }

}
