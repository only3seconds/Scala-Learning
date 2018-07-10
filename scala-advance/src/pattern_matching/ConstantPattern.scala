package pattern_matching

/**
  * 常量模式匹配
  */
object ConstantPattern {

  def main(args: Array[String]): Unit = {

    // Scala 可以在一个函数体中定义另外一个函数
    def patternShow(x:Any) = x match {
      case 5 => "five"
      case true => "true"
      case "test" => "String"
      case null => "null"
      case Nil => "empty list"
      case _ => "other constants"
    }

    println(patternShow(5))
    println(patternShow("Good Morning!"))
  }

}
