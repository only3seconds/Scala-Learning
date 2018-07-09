package scala_io

/**
  * Scala 正则表达式
  */
object RegexMatch {
  def main(args: Array[String]): Unit = {
    // 匹配邮箱
    val sparkRegex1 = "^([\\w-]+(\\.[\\w-]+)*)@[\\w-]+(\\.[\\w-]+)+$".r // r是一个方法调用，返回正则表达式对象
    for(matchString <- sparkRegex1.findAllIn("TripleP3@163.com")) {
      println(matchString)
    }

    // 提取邮箱中的用户名
    for(sparkRegex1(domainName, _*) <- sparkRegex1.findAllIn("TripleP3@163.com")) {
      println("邮箱用户名为：" + domainName)
    }

    // 匹配网址
    val sparkRegex2 = "^[a-zA-Z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\s*)?$".r
    for(matchString <- sparkRegex2.findAllIn("http://www.baidu.com")) {
      println(matchString)
    }

    // 匹配手机号码
    val sparkRegex3 = "(86)*0*13\\d{9}".r
    for(matchString <- sparkRegex3.findAllIn("15295668721")) {
      println(matchString)
    }

    // 匹配 ip 地址
    val sparkRegex4 = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r
    for(matchString <- sparkRegex4.findAllIn("192.168.1.1")) {
      println(matchString)
    }

    // 提取匹配的 ip 子段
    for(sparkRegex4(one, two, three, four) <- sparkRegex4.findAllIn("192.168.1.1")) {
      println("IP 子段1：" + one)
      println("IP 子段2：" + two)
      println("IP 子段3：" + three)
      println("IP 子段4：" + four)
    }
  }

}
