package pattern_matching

/**
  * 元组模式
  */
object TuplePattern {

  def main(args: Array[String]): Unit = {
    val t = ("spark", "hive", "hadoop")

    def tuplePattern(t: Any) = t match {
      case (one, _, _) => one
      case _ => "Other"
    }

    println(tuplePattern(t))
  }
}
