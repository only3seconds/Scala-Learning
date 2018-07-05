package scala_trait

/**
  * Scala Trait(特征）相当于 Java 的接口,与接口不同的是，它还可以定义属性和方法的实现。
  * 可以继承多个 trait
  */

trait Equal {
  def isEqual(x: Any): Boolean

  def isNoEqual(x: Any): Boolean = !(isEqual(x))
}

class Point(xc: Int, yc: Int) extends Equal {
  var x: Int = xc;
  var y: Int = yc;

  override def isEqual(obj: Any) =
    obj.isInstanceOf[Point] &&
    obj.asInstanceOf[Point].x == x
}

object Test {
  def main(args: Array[String]): Unit = {
    val p1 = new Point(2, 3);
    val p2 = new Point(2, 4);
    val p3 = new Point(3, 3);

    println(p1.isNoEqual(p2));
    println(p1.isNoEqual(p3));
    println(p1.isNoEqual(2));
  }
}