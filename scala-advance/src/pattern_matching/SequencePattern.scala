package pattern_matching

/**
  * 序列模式
  */
object SequencePattern {

  def main(args: Array[String]): Unit = {
    val p1 = List("spark", "hive", "hadoop")
    val p2 = List("Spark")

    def sequencePattern(p: List[String]) = p match {
      //只需要匹配第二个元素
      case List(_, second, _*) => second
      case _ => "Other"
    }

    println(sequencePattern(p1))
    println(sequencePattern(p2))

  }

}
