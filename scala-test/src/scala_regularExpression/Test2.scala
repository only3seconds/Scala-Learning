package scala_regularExpression

import scala.util.matching.Regex

object Test2 {
  def main(args: Array[String]): Unit = {

    //使用管道(|)来设置不同的模式
    val pattern = new Regex("(S|s)cala"); //首字母可以是大写S或小写s
    val str = "Scala is scalable and cool";

    //mkString( ) 方法来连接正则表达式匹配结果的字符串
    println((pattern findAllIn str).mkString(","));

    //replaceFirstIn()替换第一个匹配项，replaceAllIn()替换所有匹配项
    println(pattern replaceFirstIn(str, "java"));
  }

}
