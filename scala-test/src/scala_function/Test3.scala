package scala_function

/**
  *Scala 可以为函数参数指定默认参数值，使用了默认参数，你在调用函数的过程中可以不需要传递参数，这时函数就会调用它的默认参数值，
  * 如果传递了参数，则传递值会取代默认值。
  */
object Test3 {

  def main(args: Array[String]): Unit = {
    System.out.println(addInt());
    System.out.println(addInt(2, 6));
  }
  def addInt(a:Int = 1, b:Int = 2): Int = {
    var sum: Int = 0;
    sum = a + b;
    return sum;
  }

}
