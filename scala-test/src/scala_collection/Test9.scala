package scala_collection

/**
  *  Set.min 方法查找集合中的最小元素，Set.max 方法查找集合中的最大元素
  *
  *  Set.& 方法 或 Set.intersect 方法来查看两个集合的交集元素
  */
object Test9 {
  def main(args: Array[String]): Unit = {
    val num1 = Set(1, 2, 3, 4, 5);
    val num2 = Set(1, 2, 8, 9, 10);

    println("num1 的最大元素为：" + num1.max);
    println("num2 的最小元素为：" + num2.min);

    //交集
    println("num1.&(num2) = " + num1.&(num2));
    println("num1.intersect(num2) = " + num1.intersect(num2));
  }

}
