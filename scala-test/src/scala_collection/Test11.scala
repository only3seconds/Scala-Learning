package scala_collection

/**
  * 合并 Map 与合并 Set 类似
  * 使用 ++ 运算符或 Map.++() 方法来连接两个 Map，Map 合并时会移除重复的 key。
  */
object Test11 {

  def main(args: Array[String]) {
    val colors1 = Map("red" -> "#FF0000",
      "azure" -> "#F0FFFF",
      "peru" -> "#CD853F")

    val colors2 = Map("blue" -> "#0033FF",
      "yellow" -> "#FFFF00",
      "red" -> "#FF0000")

    //  ++ 作为运算符
    var colors = colors1 ++ colors2
    println( "colors1 ++ colors2 : " + colors )

    //  ++ 作为方法
    colors = colors1.++(colors2)
    println( "colors1.++(colors2) : " + colors )

  }
}