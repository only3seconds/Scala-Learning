package scala_array

/**
  * 一维数组的处理
  */
object Test1 {

  def main(args: Array[String]): Unit = {
    var myList = Array(1.9, 2.9, 3.4, 3.5);

    //输出所有数组元素
    for (x <- myList) {
      println(x);
    }

    //计算数组所有元素的综合
    var sum = 0.0;
    for (i <- 0 to (myList.length - 1)) {
      sum += myList(i);
    }
    println("数组所有元素之和为：" + sum);

    //查找数组中的最大元素
    var max = myList(0);
    for (i <- 1 to (myList.length - 1)) {
      if (myList(i) > max)
        max = myList(i);
    }
    println("数组中最大元素为: " + max);
  }

}
