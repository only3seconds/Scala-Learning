package collection

import scala.collection.mutable.ArrayBuffer

object ArrayBufferInt {

  def main(args: Array[String]): Unit = {
    var intArrayVar = ArrayBuffer(1, 2, 3)

    // 数组遍历的各种方法
    // 方法一：数组方式，推荐使用
    for (i <- intArrayVar) println("遍历方法1：" + i);
    // 方法二: to
    for (i <- 0 to intArrayVar.length -1) println("遍历方法2：" + intArrayVar(i));
    // 方法三: until
    for (i <- 0 until  intArrayVar.length) println("遍历方法3：" + intArrayVar(i));
    // 方法四：步长为 2
    for (i <- 0 until (intArrayVar.length, 2)) println("遍历方法4：" + intArrayVar(i));
    // 方法五：逆序输出
    for (i <- (0 to intArrayVar.length - 1).reverse) println("遍历方法5：" + intArrayVar(i));

    // 在数组为 0 的位置插入元素
    intArrayVar.insert(0, 4)
    intArrayVar.insert(0, 5, 6)
    println("在位置 0 插入元素后为：" + intArrayVar)

    // 从索引 1 开始删除2个元素
    intArrayVar.remove(1, 2)
    println("删除元素后：" + intArrayVar)

    // 变长数组转成定长数组
    intArrayVar.toArray  // 怎么打印出 toArray 后的数组？

    // 定长数组转成变长数组
    intArrayVar.toBuffer

  }

}
