package scala_string

/**
  * 在 Scala 中，字符串的类型实际上是 Java String，它本身没有 String 类。
  * String 是一个不可变的对象，所以该对象不可被修改。修改字符串就会产生一个新的字符串对象。
  * 创建一个可以修改的字符串，可以使用 StringBuilder 类
  */
object Test1 {

  def main(args: Array[String]) = {
    val buf = new StringBuilder;
    buf += 'a';
    buf ++= "bcdef";
    println("buf is: " + buf.toString());

  }

}
