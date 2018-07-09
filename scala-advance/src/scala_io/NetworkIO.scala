package scala_io

import java.net.URL
import scala.io.Source.fromURL

/**
  * Scala 网络 IO
  */
object NetworkIO {

  def main(args: Array[String]): Unit = {
    println(fromURL(new URL("http://www.baidu.com")).mkString)
  }

}
