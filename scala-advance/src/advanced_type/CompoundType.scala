package advanced_type

/**
  * 复合类型
  */
class A

class B extends A with Cloneable

object CompoundType {

  // 可以利用关键字 type  来声明一个复合类型
  type X = A with Cloneable

  def test(x: X) = println("test ok")

  def main(args: Array[String]): Unit = {
    test(new B)
  }

}
