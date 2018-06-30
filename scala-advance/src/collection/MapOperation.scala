package collection

import scala.collection.mutable

/**
  * Map 操作
  */
object MapOperation {

  def main(args: Array[String]): Unit = {

    // 初始化
    val studentInfoMutable1 = mutable.Map("Jhon" -> 20, "Stephen" -> 21, "Lucy" -> 22)
    val studentInfoMutable2 = mutable.Map(("Jhon", 20), ("Stephen", 21), ("Lucy", 22))

    // 遍历操作
    println("遍历方式一：")
    for(i <- studentInfoMutable1) println(i)

    println("遍历方式二：")
    studentInfoMutable1.foreach(e =>
    {val (k, v) = e
    println(k + ":" + v)
    }
    )

    println("遍历方式三：")
    studentInfoMutable1.foreach(e =>
    {
      println(e._1 + ":" + e._2)
    }
    )


    // clear: 清空
    println("clear 清空 studentInfoMutable2 后：" + studentInfoMutable2.clear())

    // put: 添加元素
    studentInfoMutable2.put("spark", 1)

    // contains: 是否包含该关键字
    println("Map 中是否包含关键字 spark: " + studentInfoMutable2.contains("spark"))

    // get: 获取元素
    println("获取 键 spark 对应的 Option：" + studentInfoMutable2.get("spark"))
    println("获取 键 hive 对应的 Option：" + studentInfoMutable2.get("hive"))
    println("获取 键 spark 对应的 value：" + show(studentInfoMutable2.get("spark")))
    println("获取 键 hive 对应的 value：" + show(studentInfoMutable2.get("hive")))


  }

  // 模式匹配获取 Option 中的内容， 这个函数的返回类型为 Any
  def show(x: Option[Int]) = x match {
    case Some(s) => s
    case None => "???"

  }


}
