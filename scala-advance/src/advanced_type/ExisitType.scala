package advanced_type

/**
  * 存在类型
  */
object ExistType extends App{

  def print(x: Array[_]) = println(x)

  def print2(x: Array[T] forSome {type T}) = println(x)

  def print3(x: Map[_, _]) = println(x)

  print(Array("TripleP3", "Journey"))

  print2(Array("TripleP3", "Journey"))

  print3(Map("TripleP3" -> "Journey"))


}
