package scala_collection

/**
  * Iterator 迭代器不是一个容器，更确切的说是逐一访问容器内元素的方法。
  *
  * it.size 或 it.length 方法来查看迭代器中的元素个数
  */
object Test14 {
  def main(args: Array[String]): Unit = {
    val it = Iterator("Baidu", "Google", "Taobao", "Runoob");

    while (it.hasNext) {
      println(it.next());
    }

    //要注意迭代器的更新
    val it1 = Iterator(1, 2, 3, 4, 5);
    println("it1 的 size 为：" + it1.size);
    //println("最大元素是：" + it1.max);
    println("it1 的 size 为：" + it1.size);

    val it2 = Iterator(1, 2, 3, 4, 5);
    println("it2 的 length 为：" + it2.length);
    //println("最小元素是：" + it2.min);
    println("it2 的 length 为：" + it2.length);

  }

}
