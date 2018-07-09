package scala_trait

import java.io.PrintWriter

/**
  * trait 构造顺序
  *
  * lazy 懒加载
  */


trait Logger {
  println("Logger")

  def log(msg: String): Unit

}

trait FileLogger extends Logger {
  println("FileLogger")
  val fileName: String
  lazy val fileOutput = new PrintWriter(fileName)
  // fileOutput.println("#") 这句也会报 NullPointerException

  def log(msg: String): Unit = {
    fileOutput.print(msg)
    fileOutput.flush()
  }
}

class Person

class Student extends Person with FileLogger {
  val fileName = "file.log"
}
object TraitDemo {
  def main(args: Array[String]): Unit = {

    val s = new Student
    s.log("lazy variable")
  }
}