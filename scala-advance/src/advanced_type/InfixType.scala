package advanced_type

/**
  * 中置类型
  */
case class People[T, S](val name:T, val age:S)

object InfixType extends App{
  // 中置表达方法 相当于 val animal: Animal[String, Int] = null
  val p: String People Int = People("TripleP3", 24)

  // 中置表达式的模式匹配用法
  p match {
    case "TripleP3" People 24 => println("matching is ok.")
    case name People age => println("name = " + name + "age = " + age)
  }

}
