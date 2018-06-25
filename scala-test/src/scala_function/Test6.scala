package scala_function

/**
  * 可以通过指定函数参数名传参，并且不需要按照顺序向函数传递参数
  */
object Test6 {

  def main(args: Array[String]): Unit = {
    printInt(b = 4, a = 8);
  }

  def printInt(a: Int, b: Int): Unit = {
    println("Value of a: " + a);
    println("Value of b: " + b);
  }


}
