package collection

/**
  * List 常用操作
  */
object ListOperation {
  def main(args: Array[String]): Unit = {
    val nums = 1:: (2:: (3:: (4:: Nil)))
    val chars = 'a' :: 'b' :: 'c' :: 'd' :: Nil
    val testNums = 5 :: 6 :: 2 :: 0 ::9 :: Nil


    println("判断是否为空：" + nums.isEmpty)

    println("取第一个元素：" + nums.head)

    println("取最后一个元素" + nums.last)

    println("取除第一个元素外剩余的元素，返回的是列表：" + nums.tail)

    println("取除了最后一个元素外剩余的元素，返回的是列表：" + nums.init)

    println("取第二个元素：" + nums.tail.head)

    println("取前 n 个元素(方式一）：" + (nums take 3))
    println("取前 n 个元素(方式二）：" + nums.take(3))

    println("丢弃前 n 个元素(方式一）：" + (nums drop 3))
    println("丢弃前 n 个元素(方式二）：" + nums.drop(3))

    println("列表元素倒置：" + nums.reverse)

    println("将列表进行分割：" + nums.splitAt(2))

    println("List toString 方法：" + nums.toString)
    println("List mkString 方法：" + nums.mkString("#"))

    println("List 转换成 Array：" + nums.toArray)

    println("连接 nums 和 chars：" + nums.:::(chars))

    println("List zip 操作(方式一)：" + (nums zip chars))
    println("List zip 操作(方式二)：" + nums.zip(chars))

    println("List 插入排序：" + insertSort(testNums))

  }

  /**
    * List 插入排序算法实现
    * @param xs
    * @return
    */
  def insertSort(xs: List[Int]): List[Int] = {
    if(xs.isEmpty) Nil
    else insert(xs.head, insertSort(xs.tail))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = {
    if(xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)
  }
}
