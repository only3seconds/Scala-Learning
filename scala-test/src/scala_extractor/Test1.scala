package scala_extractor

/**
  * 邮件地址的提取器对象
  */
object Test1 {

  def main(args: Array[String]): Unit = {
    println("Apply 方法：" + apply("Zara", "gmail.com"));
    println("Unapply 方法：" + unapply("Zara@gmail.com"));
    println("Unapply 方法：" + unapply("Zara Ali"));
  }

  //注入方法（可选）通过 apply 方法我们无需使用 new 操作就可以创建对象
  def apply(user: String, domain: String) = {
    user + "@" + domain;
  }

  //提取方法（必选）unapply方法算是apply方法的反向操作：unapply接受一个对象，然后从对象中提取值，提取的值通常是用来构造该对象的值。
  def unapply(str: String): Option[(String, String)]= {
    val parts = str split "@";

    if (parts.length == 2) {
      Some(parts(0), parts(1));
    } else {
      None;
    }
  }

}
