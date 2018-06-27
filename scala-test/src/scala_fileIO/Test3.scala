package scala_fileIO

import scala.io.Source

/**
  * 使用 Scala 的 Source 类及伴生对象从文件读取内容
  */
object Test3 {
  def main(args: Array[String]): Unit = {
    println("文件内容为：")

    Source.fromFile("test.txt").foreach {
      print;
    }
  }

}
