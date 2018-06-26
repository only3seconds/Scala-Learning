package scala_collection

object Test10 {
  def main(args: Array[String]): Unit = {
    val colors = Map("red" -> "#FF0000", "azure" -> "F0FFFF", "peru" -> "#CD853F");
    val nums:Map[Int, Int] = Map();

    println("colors 中的键为：" + colors.keys);
    println("colors 中的值为：" + colors.values);
    println("colors 是否为空：" + colors.isEmpty);
    println("nums 是否为空：" + nums.isEmpty);

  }

}
