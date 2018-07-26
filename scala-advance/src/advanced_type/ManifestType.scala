package advanced_type

import scala.reflect.runtime.universe
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

  def getTypeTag[T: ]


}
