package scala_class

/**
  * 在 Scala 中，没有 static，使用关键字 object 可以实现单例模式。
  * Scala 中使用单例模式时，除了定义的类之外，还要定义一个同名的 object 对象，它和类的区别是，object对象不能带参数。
  * 单例对象与某个类同名时，被称作是这个类的伴生对象，必须在同一个源文件里定义类和它的伴生对象，类和它的伴生对象可以互相访问私有成员
  *
  */

//私有构造方法
class Marker private (val color: String) {
  println("创建" + this);

  override def toString: String = "颜色标记：" + color

}

// 伴生对象，与类共享名字，可以访问类的私有属性和方法
object Marker {
  private val markers: Map[String, Marker] = Map (
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("green")
  )

  def apply(color: String) = {
    if(markers.contains(color)) markers(color) else null;
  }

  def getMarker(color: String) = {
    if(markers.contains(color)) markers(color) else null;
  }

  def main(args: Array[String]): Unit = {
    println(Marker("red"));
    // 单例函数调用，省略了.(点)符号
    println(Marker getMarker "blue");
  }
}
