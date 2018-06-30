package collection

import scala.collection.mutable.Stack

/**
  * Stack 操作
  */
object StackOperation {

  def main(args: Array[String]): Unit = {
    // apply 创建方式
    val stack = Stack(1, 2, 3)

    // 出栈：pop
    println("pop 出栈：" + stack.pop())

    // 入栈：push
    println("push 入栈：" + stack.push(4))

    // 取栈顶元素：top
    println("top 取栈顶元素：" + stack.top)
    println("top 后的栈：" + stack) //top 操作并不会影响到栈


  }

}
