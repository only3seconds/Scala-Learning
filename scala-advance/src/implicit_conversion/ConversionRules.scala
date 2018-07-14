package implicit_conversion

import java.io.File

import scala.io.Source
/**
  * 隐式转换规则
  */

package implicitConversion {

  object ImplicitConversion {
    implicit def double2Int(x: Double) = x.toInt
    implicit def file2RFile(file: File) = new RFile(file)
    //implicit def file2RFile2(file: File) = new RFile(file)
    implicit def rFile2RFileAnother(file: RFile) = new RFileAnother(file)

  }

}

class RFile(val file: File) {
  def read = Source.fromFile(file).getLines().mkString
}

class RFileAnother(val file: RFile) {
  def read2 = file.read
}

object ConversionRules extends App {
  // 注意要引入包
  import implicitConversion.ImplicitConversion._
  // 不需要定义隐式转换函数编译就会通过，则不进行隐式转换
  println(3.4 * 3)

  // 如果转换存在二义性，则不会进行隐式转换，编译出错(ambiguous)
  val f = new File("file.txt").read
  println(f)

  // 隐式转换不会嵌套执行，不会发生从 File 转换到 RFile，再到 RFileAnother
  //val f2 = new RFileAnother("file.txt").read2
}
