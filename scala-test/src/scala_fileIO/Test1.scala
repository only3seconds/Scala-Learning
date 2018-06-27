package scala_fileIO

/**
  * Scala 进行文件写操作，直接用的都是 java中 的 I/O 类 （java.io.File)
  */

import java.io._

object Test1 {
  def main(args: Array[String]): Unit = {

    val writer = new PrintWriter(new File("test.txt"));

    writer.write("Scala is cool, \n " +
      "I like scala!");
    writer.close();

  }

}
