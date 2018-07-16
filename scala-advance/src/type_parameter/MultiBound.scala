package type_parameter

/**
  * 多重界定
  */

class A[T]
class B[T]

object MultiBound extends App {

  // 多重上下文界定，必须存在两个隐式值
  implicit val a = new A[Int]
  implicit val b = new B[Int]

  def multiContextBound[T:A:B](x: T) = println(x)
  multiContextBound(12)

  // 多重视图界定，必须存在两个隐式转换
  implicit def t2A[T](x: T) = new A[T]
  implicit def t2B[T](x: T) = new B[T]

  def multiViewBound[T <% A[T] <% B[T]](x: T) = println(x)
  multiViewBound("Journey")

}
