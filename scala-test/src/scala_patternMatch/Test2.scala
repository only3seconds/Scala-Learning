package scala_patternMatch

/**
  * 不同数据类型的模式匹配
  */
object Test2 {

  def main(args: Array[String]): Unit = {
    println(matchTest(1));
    println(matchTest("two"));
    val y = 2;
    println(matchTest(y))
    println(matchTest(7.7));
  }

  def matchTest(x: Any): Any = x match {
    case 1 => "one";
    case "two" => 2;
    case y: Int => "scala.Int";
    case _ => "many";
  }

}
