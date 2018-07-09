package scala_io

import java.io.FileWriter

/**
  * Scala 写文件
  */
object ScalaFileWriter {

  def main(args: Array[String]): Unit = {
    val fileWriter = new FileWriter("file.txt")
    fileWriter.write("Scala file writer")
    fileWriter.flush()
    fileWriter.close()
  }

}
