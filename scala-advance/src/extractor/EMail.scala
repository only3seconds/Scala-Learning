package extractor

object EMail {
  //apply 方法用于无 new 构造对象
  def apply(user: String, domain: String) = user + "@" + domain

  //unapply 方法用于在模式匹配中充当 extractor
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}
