package scala_extractor

/**
  * 实例化一个类时，可以带上0个或者多个的参数，编译器在实例化的时会调用 apply 方法，可以在类和对象中都定义 apply 方法。
  * 在提取器对象中使用 match 语句时，unapply 将自动执行 ??? 
  */
object Test2 {

  def main(args: Array[String]): Unit = {
    val x = Test2(4);
    //val x = "Hello"
    println(x);

    x match {
      case Test2(num) => println(x + "是" + num + "的两倍！")
      case _ => println("无法计算")
    }
    
  }

  def apply(x: Int) = x * 2;

  def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z/2) else None

}
