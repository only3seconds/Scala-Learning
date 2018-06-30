package collection

object QueueOperation {

  def main(args: Array[String]): Unit = {
    var queue1 = scala.collection.mutable.Queue(1, 2, 3)
    var queue2 = scala.collection.immutable.Queue(1, 2, 3)

    // 出队
    println("出队（可变队列）：" + queue1.dequeue)
    println("出队（不可变队列）：" + queue2.dequeue)

    // 入队
    queue1.enqueue(4)
    println("入队（可变队列）：" + queue1)
    println("入队（不可变队列）：" + queue2.enqueue(4))

    println("可变队列：" + (queue1 += 5))
    //queue2 += 5 报错，不可变队列是不能修改的

    // 集合方式
    println("可变队列追加一个集合：" + (queue1 ++= List(6, 7, 8)))

    queue2 ++= List(6, 7, 8) // 将会生成一个新的队列，注意 ++ 操作 与 + 操作的区别
    println("不可变队列追加一个集合：" + queue2)

  }
}
