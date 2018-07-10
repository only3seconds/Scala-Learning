package pattern_matching

/**
  * 变量绑定模式
  */
object VariableBindingPattern {
  def main(args: Array[String]): Unit = {
    var list = List(List(1, 2, 3), List(2, 3, 4))

    def variableBindingPattern(t: Any) = t match {
      // 利用变量 e 和 @ 进行匹配， 返回匹配结果
      case List(_, e@List(_, _, _)) => e
      case _ => Nil
    }

    println(variableBindingPattern(list))
  }

}
