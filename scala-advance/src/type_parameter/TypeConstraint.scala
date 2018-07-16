package type_parameter

/**
  * 类型约束
  */

class P
class Q

object TypeConstraint extends App {
  def test[T](name: T)(implicit ev: T <:< java.io.Serializable) = { name }

  // 无需定义一个隐式值，因为 Predef 中的 conforms 会产生一个隐式值

  // String 类型属于 Serializable 的子类
  println(test("TripleP3"))

  // Int 类型不是 Serializable 的子类
  //println(test(45))


  def foo[A, B <: A](a: A, b: B) = (a, b)
  def bar[A, B](a: A, b: B)(implicit ev: B <:< A) = (a, b)

  // <: 当类型不匹配时，采用类型推断
  println(foo(1, List(1, 2, 3)))

  // <:< 当类型不匹配时，不采用类型推断，需要严格类型匹配
  //println(bar(1, List(1, 2, 3)))
  println(bar(1, 0))

  implicit def p2q(p: P) = new Q
  def foo1[P, Q <: P](a: P, b: Q) = println("foo1, OK!")
  def bar1[P, Q](a: P, b: Q)(implicit ev: Q <:< P)= println("bar1, OK!")

  // 隐式转换对 <: 有效
  foo1(new P, new Q)

  // 隐式转换对 <:< 无效
  //bar1(new P, new Q)


}
