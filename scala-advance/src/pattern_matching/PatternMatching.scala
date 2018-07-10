package pattern_matching

import scala.collection.mutable.ArrayBuffer

/**
  * Scala 模式匹配
  */
object PatternMatching extends App {
  var list = new ArrayBuffer[Int]()
  var x = 0

  for(i <- 1 to 50) {
    i match {
      // 可以跟表达式
      case 10 => x = 10
      case 30 => println(30)
      case 50 => println(50)
      // 增加守卫条件
      case _ if(i % 4 == 0) => list.append(i)
      case _ if(i % 3 == 0) => println(i + ": 能被3整出")
      case _ =>
    }
  }

  println("能被4整除的数：" + list)
  println("x = " + x)

}
