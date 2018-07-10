package pattern_matching

/**
  * Option 类型模式匹配
  */
object OptionDemo extends App{
  val map = Map("hive" -> 2, "spark" -> 3, "Spark MLlib" -> 4)

  def mapPattern(s: String) = map.get(s) match {
    case Some(x) => x
    case None => println("None"); -1
  }

  println(mapPattern("spark"))
  println(mapPattern("Hive"))

}
