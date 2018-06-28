package collection

import scala.collection.mutable.ArrayBuffer

object ArrayBufferString {

  def main(args: Array[String]): Unit = {
    val str = ArrayBuffer[String]()

    // += 是在尾部添加一个或多个元素
    str += "Hello"
    str += ("Pan", "Pingping")
    println("在尾部添加元素后：" + str)

    // ++= 是在尾部添加任何一个集合
    str ++= Array("Lu", "Weiling")
    str ++= List("Love")
    println("在尾部添加集合后：" + str)

    // 在尾部删除 n 个元素
    str.trimEnd(3)
    println("在尾部删除元素后：" + str)

    // 删除任意位置元素
    str.remove(2)
    println("删除某个元素后：" + str)

  }

}
