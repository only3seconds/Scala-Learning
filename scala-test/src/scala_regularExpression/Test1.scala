package scala_regularExpression
import scala.util.matching.Regex;

object Test1 {
  def main(args: Array[String]): Unit = {

    //使用 String 类的 r() 方法构造了一个Regex对象
    val pattern = "Scala".r;
    val str = "Scala is scalable and Scala is cool";

    //使用 findFirstIn 方法找到首个匹配项
    println(pattern findFirstIn str);

    //使用 findAllIn 方法查看所有的匹配项
    println(pattern findAllIn str);
  }

}
