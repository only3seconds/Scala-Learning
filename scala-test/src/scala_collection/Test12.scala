package scala_collection

/**
  * 元组 Tuple
  * 与列表一样，元组也是不可变的，但与列表不同的是元组可以包含不同类型的元素。
  * Tuple.productIterator() 方法来迭代输出元组的所有元素
  * Tuple.toString() 方法将元组的所有元素组合成一个字符串
  * Tuple.swap 方法来交换Tuple2元组中的元素
  */
object Test12 {
  def main(args: Array[String]): Unit = {
    val t = (4, 3, 2, 1);
    t.productIterator.foreach { i =>
      println("Value = " + i);
    }

    val sum = t._1 + t._2 + t._3 + t._4;
    println("sum = " + sum);

    val t1 = (1, 3.14, "Mary");
    println("t1 = " + t1);

    val t2 = new Tuple4(1, 2.2, 'a', "Love");
    println("t2 = " + t2);

    val t3 = new Tuple3("PPP", 520, Console);
    println("连接后的字符串为：" + t3.toString());

    val t4 = new Tuple2("Pan Pingping", "Lu Weiling");
    println("交换元素后的数组为：" + t4.swap);

  }

}
