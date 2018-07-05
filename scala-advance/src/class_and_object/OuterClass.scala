package class_and_object

class OuterClass {

  // 即使定义为 private[this] var x: Int = 0, 内部类也可以获得
  private var x: Int = 0

  class InnerClass {
    private var y: Int = 0

    def getOuterX = x
  }
}

object AppDemo {
  def main(args: Array[String]): Unit = {
    val o = new OuterClass

    // 创建内部类对象， InnerClass 就像 OuterClasss 的成员变量一样
    val i = new o.InnerClass
    println("外部类的 x 值为：" + i.getOuterX)

  }
}
