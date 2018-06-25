package scala_function

/**
  * （1）匿名函数：箭头左边是参数列表，右边是函数体。
  *
  * （2）闭包：闭包是一个函数，返回值依赖于声明在函数外部的一个或多个变量。
  */
object Test9 {

  def main(args: Array[String]): Unit = {
    println("multiplier(1) value = " + multiplier(1));
    println("multiplier(2) value = " + multiplier(2));

  }
  var factor = 3;
  //这样定义的函数变量 multiplier 成为一个"闭包"，因为它引用到函数外面定义的变量，定义这个函数的过程是将这个自由变量捕获而构成一个封闭的函数。
  val multiplier = (i: Int) => i * factor


}
