package scala_exception

import java.io.{FileNotFoundException, FileReader, IOException}

/**
  * Scala 抛出异常的方法和 Java一样，使用 throw 方法
  * 在Scala里，借用了模式匹配的思想来做异常的匹配
  * 越具体的异常越要靠前，越普遍的异常越靠后
  */
object Test1 {
  def main(args: Array[String]): Unit = {
    try {
      val f = new FileReader("input.txt");
    } catch {
      case ex: FileNotFoundException => {
        println("Missing file exception");
      }
      case ex: IOException => {
        println("IO Exception");
      }
    } finally {
      println("Exiting finally");
    }
  }

}
