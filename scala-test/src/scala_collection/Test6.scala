package scala_collection

/**
  * exists 判断列表中指定条件的元素是否存在。
  */
object Test6 {

  def main(args: Array[String]): Unit = {
    //创建一个字符串列表 strList
    val strList = "Hah" :: ("Weiling" :: ("!" :: Nil));

    //test1 是个字符串，不是一个字符串列表
    val test1 = "Hah, Weiling!"

    println(strList.exists(s => s == "Hah"));

    //warning: comparing values of types Char and String using `==' will always yield false
    println(test1.exists(s => s == "Hah"));

  }

}
