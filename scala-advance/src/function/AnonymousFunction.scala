package function

/**
  * 匿名函数  函数参数 => 函数体
  */
object AnonymousFunction {

  def main(args: Array[String]): Unit = {
    // 匿名函数
    println(Array(1, 2, 3, 4).map((x:Int) => x + 1).mkString(","))

    // 函数简化

    println(Array(1, 2, 3, 4).map{(x:Int) => x + 1}.mkString(","))

    // 省略符号 .
    println(Array(1, 2, 3, 4) map((x:Int) => x + 1) mkString(","))

    // 参数类型推断
    println(Array(1, 2, 3, 4) map((x) => x + 1) mkString(","))

    // 函数只有一个参数的话
    println(Array(1, 2, 3, 4) map(x => x + 1) mkString(","))

    // 如果参数右边只出现一次
    println(Array(1, 2, 3, 4).map(_ + 1).mkString(","))

  }

}
