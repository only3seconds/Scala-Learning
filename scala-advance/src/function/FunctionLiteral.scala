package function

/**
  * 函数字面量
  */
object FunctionLiteral {

  def main(args: Array[String]): Unit = {
    // 函数体只有一条语句
    val increase1 = (x: Int) => x + 1
    println("调用 increase1: " + increase1(10))

    // 函数体有多条语句
    val increase2 = (x: Int) => {
      println("Hello")
      println("Scala")
      x + 1
    }
    println("调用 increase2: " + increase2(10))

    // 数组的 map 方法中调用
    println("数组的 map 方法中调用：" + Array(1, 2, 3).map(increase1).mkString(","))


  }


}
