package scala_trait

import java.io.PrintWriter

/**
  * trait 构造顺序
  */


trait Logger {
  println("Logger")

  def log(msg: String): Unit

}

trait FileLogger extends Logger {
  println("FileLogger")
  val fileOutput = new PrintWriter("file.log")
  fileOutput.println("#")

  def log(msg: String): Unit = {
    fileOutput.print(msg)
    fileOutput.flush()
  }
}

object TraitDemo {
  def main(args: Array[String]): Unit = {

    // 匿名类
    new FileLogger {}.log("trait demo")
  }
}