package type_parameter

/**
  * 上下文界定，隐式转换，Ordering 转换成 Ordered
  */
// AnimalOrdering 混入了 Ordering，它与实现了 Comparator 接口的类的功能一致
class AnimalOrdering extends Ordering[Animal] {
  override def compare(x: Animal, y: Animal): Int = {
    if(x.name > y.name)
      1
    else
      -1
  }
}

case class Animal(val name: String) {
  println("正在构造对象" + name)

}

// 下面定义一个上下文界定，在对应的作用域中，必须存在一个类型为 Ordering[T] 的隐式值，该隐式值可以作用于内部的方法
class Pair2[T: Ordering](val first: T, val second: T) {
  // 引入 Ordering 到 Ordered 的转换
  import Ordered.orderingToOrdered

  // 编译器看到 < ,会自动进行隐式转换，将 Ordering 转换为 Ordered，调用 Ordered 的 < 方法
  def smaller = {
    if (first < second)
      first
    else
      second
  }
}

object ContextBound extends App {
  implicit val ord1 = new AnimalOrdering

  val p = new Pair2(Animal("Dog"), Animal("Cat"))

  // 不给函数指定参数，此时会查找一个隐式值，该隐式值类型为 Ordering[Animal]，根据上下文界定的要求，该类型满足要求，可以作为 smaller 的隐式参数传入
  println(p.smaller)

}
