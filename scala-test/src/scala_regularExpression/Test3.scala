package scala_regularExpression

import scala.util.matching.Regex

object Test3 {
  def main(args: Array[String]): Unit = {
    // \\d	匹配数字，类似: [0-9]
    val pattern = new Regex("abl[ae]\\d+");
    val str = "ablaw is able1 and cool"

    println((pattern findAllIn str).mkString(","));

  }


}
