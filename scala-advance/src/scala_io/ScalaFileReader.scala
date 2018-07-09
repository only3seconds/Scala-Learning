package scala_io

import scala.io.Source

/**
  * Scala 读文件
  */
object ScalaFileReader {

  def main(args: Array[String]): Unit = {
    // 读取文件
    val file = Source.fromFile("/Users/thinking/Documents/workspace/Scala-Learning/scala-advance/src/class_and_object/Animal.scala")
    // 返回 Iterator[String]
    val lines = file.getLines()
    // 打印内容
    for(i <- lines) println(i)
    // 关闭文件
    file.close()

  }

}
