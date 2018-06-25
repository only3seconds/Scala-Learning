package scala_function

import java.util.Date;

/**
  * Scala 偏应用函数是一种表达式，你不需要提供函数需要的所有参数，只需要提供部分，或不提供所需参数。
  */
object Test5 {
  def main(args: Array[String]): Unit = {
    val date = new Date;
    //偏应用函数
    val logWithDateBound = log(date, _: String);

    logWithDateBound("message1");
    Thread.sleep(1000);
    logWithDateBound("message2");
    Thread.sleep(1000);
    logWithDateBound("message3");
  }

  def log(date: Date, message: String): Unit = {
    println(date + "----" + message);
  }

}
