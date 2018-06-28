package control_structure

import java.io.File

object MultipleFor {

  val filesHere = (new File(".")).listFiles

  def main(args: Array[String]): Unit = {
    println(filesHere);
    grep("Scala");

  }

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  //多重循环 每次循环将结果保留,当整个循环执行完毕,所有保留的值将会生成一个集合并返回
  def grep(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".md"); //这里的 ; 一定要有

      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)

}
