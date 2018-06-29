package collection

import scala.collection.mutable

object SetOperation {
  def main(args: Array[String]): Unit = {

    val numsSet = mutable.Set(3.0, 5)
    println(numsSet)

    // Set 插入元素时，并不保持元素顺序
    println("向 Set 中插入一个元素：" + (numsSet + 6))

    // 可以用 LinkedHashSet 保持元素插入顺序
    val linkedHashSet = mutable.LinkedHashSet(3.0, 5)
    println("向 LinkedHashSet 插入一个元素：" + (linkedHashSet + 6))

  }

}
