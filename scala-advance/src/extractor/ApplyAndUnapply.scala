package extractor

/**
  * apply 与 unapply 方法
  */
object ApplyAndUnapply extends App {

  def patternMatching(x:String) = x match {
    case EMail(user, domain) => println("user = " + user + " domain = " + domain)
    case _ => println("Illegal email")
  }

  val email = EMail("only3seconds", "163.com")
  patternMatching(email)
  patternMatching("Hello World")
}
