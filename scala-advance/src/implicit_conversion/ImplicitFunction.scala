package implicit_conversion

import java.io.File

import scala.io.Source

/**
  * 隐式转换函数
  */
class RichFile(val file: File) {
  def read = Source.fromFile(file).getLines().mkString
}

object ImplicitFunction extends App {

  implicit def double2Int(x: Double) = x.toInt

  var x:Int = 3.9
  println("x = " + x)

  implicit def file2RichFile(file: File) = new RichFile(file)
  // File 类中不存在 read 方法，隐式转换成 RichFile 类
  val f = new File("file.txt").read
  println(f)




}
