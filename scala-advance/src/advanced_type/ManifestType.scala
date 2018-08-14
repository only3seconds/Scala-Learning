package advanced_type

import scala.reflect.runtime.universe._

/**
  * Manifest
  */
object ManifestType extends App {
  def print1[T](x: List[T]) (implicit m: Manifest[T]): Unit = {
    if(m <:< manifest[String])
      println("字符串类型的 List")
    else
      println("非字符串类型的 List")
  }
  print1(List("one", "two"))
  print1(List(1, 2))
  print1(List("one", 2))

  def getTypeTag[T: TypeTag](a: T) = typeTag[T]
  println(getTypeTag(List(1, 2, 3)))

  def patternMatch[A: TypeTag](xs:List[A]) = typeOf[A] match {
    //利用类型约束进行精确匹配
    case t if t =:= typeOf[String] => "List of Strings"
    case t if t =:= typeOf[Int] => "List of Ints"
  }

  println(patternMatch(List(1, 2, 3)))
}

