package collection

/**
  * List 伴生对象方法
  */
object ListCompanionObjectMethod {
  def main(args: Array[String]): Unit = {
    println("apply 方法：" + List.apply(1, 2, 3))

    println("range 方法：" + List.range(2, 6))
    println("range 方法，步长为 2：" + List.range(2, 6, 2))
    println("range 方法，步长为 -1：" + List.range(6, 2, -2))

    println("fill 方法，构建相同元素：" + List.fill(5)("hey"))

    val nums = List.apply(1, 2, 3, 4)
    val chars = List.apply('a', 'b', 'c', 'd')

    println("concat 方法，List 连接：" + List.concat(nums, chars))

    val zipped = nums zip chars
    println("unzip 方法" + zipped.unzip)

    val xss = List(List('a', 'b'), List('c'), List('d', 'e'))
    println("flatten，将 List 平滑成第一个元素：" + xss.flatten)

  }

}
