package pattern_matching

/**
  * 变量模式匹配
  */
object VariablePattern {
  def main(args: Array[String]): Unit = {

    def patternShow(x:Any) = x match {
      case 5 => "five"
      case y => y
    }

    println("Scala is beautiful!")
  }
}
