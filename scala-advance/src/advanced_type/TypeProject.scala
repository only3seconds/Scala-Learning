package advanced_type

import scala.reflect.runtime.universe._

/**
  * 类型投影
  */
class Outer {
  private var x: Int = 0
  private var i: Inner = new Outer.this.Inner

  //类型投影，可以接受任何 Outer 对象中的 Inner 类型对象
  def print(i: Outer#Inner) = i

    // 内部类
  class Inner {

      def test() = x

      override def toString: String = "Inner 类"
  }
}

object TypeProject extends App {
  val outer1 = new Outer
  val inner1 = new outer1.Inner

  val outer2 = new Outer
  val inner2 = new outer2.Inner

  println(outer1.print(inner1))
  println(outer1.print(inner2))

  // 仍返回 false, 因为只是对 print 方法中的参数进行类型投影，但 outer1.Inner 和 outer2.Inner 仍是不同类
  println(typeOf[outer1.Inner] == typeOf[outer2.Inner])
}
