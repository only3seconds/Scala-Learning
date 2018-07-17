package advanced_type

/**
  * 结构类型
  */

class File {
  def close(): Unit = println("Class File closed")

}

object File {
  def close(): Unit = println("Object File closed")
}
object StructureType {

  // 方法中参数是 结构体类型
  def releaseMemory(res: {def close(): Unit}): Unit = {
    res.close()
  }

  // 可以利用关键字 type 进行结构体类型声明
  type X = { def close(): Unit}
  def releaseMemory2(x: X) = x.close()

  def main(args: Array[String]): Unit = {

    // 结构体使用方式
    releaseMemory(new {def close() = println("A closed")})
    releaseMemory(new {def close() = println("B closed")})

    releaseMemory2(new {def close() = println("C closed")})

    // 对于普通的 Scala 类，直接创建对象传入
    releaseMemory(new File())

    // 对于单例对象，直接传入单例
    releaseMemory(File)
  }
}
