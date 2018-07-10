package pattern_matching

/**
  * for 控制结构中的模式匹配
  */
object PatternInForLoop {
  def main(args: Array[String]): Unit = {
    val countries = Map("China" -> "Beijing", "Japan" -> "Tokyo", "America" -> "Washington")

    //利用 for 循环对 Map 进行模式匹配输出
    for((nation, capital) <- countries)
      println(nation + " : " + capital)


    val ipRegex = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r

    // 利用 for 循环对正则表
    // 达式进行模式匹配
    for(ipRegex(one, two, three, four) <- ipRegex.findAllIn("192.168.1.1")) {
      println("IP 子段1：" + one)
      println("IP 子段2：" + two)
      println("IP 子段3：" + three)
      println("IP 子段4：" + four)
    }
  }

}
