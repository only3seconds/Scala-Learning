package scala_class

/**
  * Scala中的类不声明为public，一个Scala源文件中可以有多个类。
  * Scala 的类定义可以有参数，类参数在整个类中都可以访问。
  * @param xc
  * @param yc
  */
class Point(val xc: Int, val yc: Int) {
  var x: Int = xc;
  var y: Int = yc;

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx;
    y = y + dy;

    println("x 的坐标点：" + x);
    println("y 的坐标点：" + y);

  }
}

object Test1 {
  def main(args: Array[String]): Unit = {
    val pt = new Point(10, 20);

    pt.move(10, 10);
  }
}

/**
  * Scala 只允许继承一个父类。
  * override val xc 为重写了父类的字段
  * @param xc
  * @param yc
  * @param zc
  */
class Location(override val xc: Int, override val yc: Int, val zc: Int) extends Point(xc, yc) {
  var z: Int = zc;

  def move(dx: Int, dy: Int, dz: Int): Unit = {
    x = x + dx;
    y = y + dy;
    z = z + dz;

    println("x 的坐标点：" + x);
    println("y 的坐标点：" + y);
    println("z 的坐标点：" + z);

  }
}

object Test2 {
  def main(args: Array[String]): Unit = {
    val loc = new Location(10, 20, 30);

    loc.move(10, 10, 10);
  }
}


