package collection

import scala.collection.mutable.ArrayBuffer

/**
  * 数组转换，生成新的数组，原数组不变
  */
object ArrayConversion {
  def main(args: Array[String]): Unit = {
    var intArrayNoBuffer = Array(1, 2, 3)
    var intArrayBuffer = ArrayBuffer(4, 5, 6)

    // 多维数组
    val multiArr = Array(Array(1, 2, 3), Array(4, 5, 6))
    println("获取第一行第三列：" + multiArr(0)(2))
    // 多维数组遍历
    for (i <- multiArr) println(i.mkString(","))


    // 数组常用算法
    println("intArrayNoBuffer 元素之和：" + intArrayNoBuffer.sum)
    println("intArrayNoBuffer 最大元素：" + intArrayNoBuffer.max)
    println("intArrayNoBuffer 最小元素：" + intArrayNoBuffer.min)
    println("intArrayNoBuffer toString：" + intArrayNoBuffer.toString)
    println("intArrayNoBuffer mkString：" + intArrayNoBuffer.mkString("#"))
    println("intArrayNoBuffer mkString(, , ,)：" + intArrayNoBuffer.mkString("<", "#", ">"))

    // 定长数组转转后产生的仍然是定长数组
    var intArrayNoBuffer1 = for (i <- intArrayNoBuffer) yield i * 2
    // println(intArrayNoBuffer1)
    for (i <- intArrayNoBuffer1) print(i + " ")
    println();

    // 缓冲数据转换后产生的仍然是缓冲数组
    var intArrayBuffer1 = for (i <- intArrayBuffer) yield i * 2
    println(intArrayBuffer1)

    // 加入过滤条件
    var intArrayBuffer2 = for (i <- intArrayBuffer if i >= 5 ) yield i * 2
    println(intArrayBuffer2)

  }

}
