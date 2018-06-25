package scala_function

/**
  * Scala 允许你指明函数的最后一个参数可以是重复的。
  * 通过在参数的类型之后放一个*来设置可变参数(可重复的参数)
  */
object Test2 {

  def main(args: Array[String]): Unit = {
    printStrings("Runoob", "Scala", "Python");
  }

  def printStrings(args:String*) = {
    var i: Int = 0;
    for (arg <- args) {
      println("Arg value[" + i + "] = " + arg);
      i = i + 1;
      }
    }
}
