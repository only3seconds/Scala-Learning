package scala_array

import Array._

/**
  * 区间数组 range()方法最后一个参数为步长，默认为 1
  */
object Test4 {

  def main(args: Array[String]): Unit = {
    var myList1 = range(10, 20, 2);
    var myList2 = range(10, 20);

    for (x <- myList1)
      print(" " + x);
    println();

    for (x <- myList2)
      print(" " + x);
  }

}
