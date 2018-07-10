package pattern_matching

/**
  * 类型模式
  */
object TypePattern {

  def main(args: Array[String]): Unit = {

    def typePattern(t: Any) = t match {
      case t: String => "String"
      case t: Int => "Int"
      case t: Double => "Double"
    }

    println(typePattern(9.99))
  }

}
