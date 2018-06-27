package scala_patternMatch

/**
  * match 表达式通过以代码编写的先后次序尝试每个模式来完成计算，只要发现有一个匹配的case，剩下的case不会继续匹配。
  */
object Test1 {
  def main(args: Array[String]): Unit = {
    println(matchTest(3));

  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

}
