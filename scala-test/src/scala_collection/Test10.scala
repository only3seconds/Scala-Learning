package scala_collection

/**
  * keys 返回 Map 所有的键(key)
  * values 返回 Map 所有的值(value)
  * isEmpty	在 Map 为空时返回true
  *
  * foreach
  *
  * Map.contains 方法来查看 Map 中是否存在指定的 Key。
  */
object Test10 {
  def main(args: Array[String]): Unit = {
    val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF", "peru" -> "#CD853F");
    val nums:Map[Int, Int] = Map();

    println("colors 中的键为：" + colors.keys);
    println("colors 中的值为：" + colors.values);
    println("colors 是否为空：" + colors.isEmpty);
    println("nums 是否为空：" + nums.isEmpty);

    colors.keys.foreach { i =>
      print("Key = " + i);
      println(" Value = " + colors(i));
    }

    if (colors.contains("red"))
      println("red is exist!");

  }

}
