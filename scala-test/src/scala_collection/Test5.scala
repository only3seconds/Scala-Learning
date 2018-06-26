package scala_collection

/**
  * List.reverse 用于将列表的顺序反转
  */
object Test5 {

  def main(args: Array[String]): Unit = {
    //字符串列表
    val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil));

    println("site 列表反转前：" + site);
    println("site 列表反转后：" + site.reverse);
  }

}
