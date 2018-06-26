package scala_collection

/**
  * 可以使用 ++ 运算符或 Set.++() 方法来连接两个集合.如果元素有重复的就会移除重复的元素.
  */
object Test8 {
  def main(args: Array[String]): Unit = {
    val site1 = Set("Runoob", "Google", "Baidu");
    val site2 = Set("Facebook", "Taobao");

    //++作为运算符使用
    var site = site1 ++ site2;
    println("site1 ++ site 2 = " + site);

    //++作为方法使用
    site = site1.++(site2);
    println("site1.++(site2) = " + site);
  }

}
