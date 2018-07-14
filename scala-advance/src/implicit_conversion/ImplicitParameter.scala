package implicit_conversion


/**
  * 隐式参数的隐式转换
  */

class Student(var name: String) {
  // 将 Student 类的信息格式化打印，outputFormat 为隐式参数
  def formatStudent(implicit outputFormat: OutputFormat) = {
    outputFormat.first + " " + this.name + " " + outputFormat.second
  }
}

class OutputFormat(var first: String, val second: String)

object ImplicitParameter {

  // 隐式参数中的隐式转换
  def compare[T](first: T, second: T)(implicit order: T => Ordered[T]) = {
    if(first > second)
      first
    else
      second
  }

  def main(args: Array[String]): Unit = {
    implicit val outputFormat = new OutputFormat("<<", ">>")

    println(new Student("Journey").formatStudent)

    println(compare('A', 88))
  }

}
