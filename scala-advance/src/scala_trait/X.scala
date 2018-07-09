package scala_trait

/**
  * self type 自身类型
  */
trait X {
  def foo()
}

class B{
  // 定义了自身类型, 要求 B 在实例化时或定义 B 的子类时， 必须混入指定的 X 类型，这个 X 类型也可以指定为当前类型
  self:X=>
}

// 类 C 扩展 B 的时候必须混入 trait X
class C extends B with X{
  def foo = println("self type demo")
}

object SelfTypeDemo extends App{
  println(new C().foo)
  // println(println())  （）可以作为 Unit 的实例
}
