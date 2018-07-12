package type_parameter

/**
  * 上界与下界
  */

class Pairs[T](val first: T, val second: T) {
  def replaceFirst[R >: T](newFirst: R) = new Pairs[R](newFirst, second)

  override def toString: String = "first: " + first + "; second: " + second
}

class A(val name: String) {
  override def toString: String = "A " + name
}

class B1(name: String) extends A(name) {
  override def toString: String = "B1 " + name
}
class B2(name: String) extends A(name) {
  override def toString: String = "B2 " + name
}
class C2(name: String) extends B2(name) {
  override def toString: String = "C2 " + name
}

object LowerBound extends App {

  val first = new B1("b1")
  val second = new B2("b2")

  val p0 = new Pairs(first, second) // p0 = Pairs[A]
  println(p0)

  val newA = new A("newA")
  val p1 = p0.replaceFirst(newA) // p1 = Pairs[A]
  println(p1)

  val newC2: C2 = new C2("newC2")
  val p2 = p0.replaceFirst(newC2) // ???
  println(p2)

  val p3 = new Pairs(second, first) // p3 = Pairs[B2]
  println(p3)

  val p4 = p3.replaceFirst(newA) //p4 = Pairs[A]
  println(p4)

  val p5 = p3.replaceFirst(newC2) //
  println(p5)
}
