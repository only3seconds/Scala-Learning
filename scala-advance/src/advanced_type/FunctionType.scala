package advanced_type

/**
  * 函数类型
  *
  */

class A1
class A2
class B2 extends A2

object FunctionType extends App {
  val max = (x: Int, y: Int) => if(x < y) y else x

  // 函数类型
  val fun2 = new ((Int, Int) => Int) {
    def apply(x: Int, y: Int): Int = if(x < y) y else x
  }

  println(max(0, 1) == fun2(0, 1))

  // condition 不满足， assert(condition)将抛出 AssertionError 异常
  // assert(max(0, 1) != fun2(0, 1))

  val x1 = (c1: A1) => new B2
  // 函数类型返回参数是协变的
  val x2: A1 => A2 = x1

  val f1 = (c2: A2) => new A1
  // 函数类型输入类型是逆变的
  val f2: B2 =>A1 = f1

}
