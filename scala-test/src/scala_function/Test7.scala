package scala_function

/**
  * 递归函数
  */
object Test7 {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10)
      println(i + "的阶乘为：" + factorial(i));

  }

  def factorial(n: BigInt): BigInt = {
    if (n <= 1)
      1;
    else
      n * factorial(n-1);
  }

}
