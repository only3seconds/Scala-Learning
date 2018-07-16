package type_parameter

/**
  * 协变
  */
// 声明协变，类型参数声明为 +
class Children[+T](val name: T, val hobby: T) {

  // 协变要求必须将成员方法定义为泛型
  def reName[U >: T](newName: U): Children[U] = new Children[U](newName, hobby)

  override def toString: String = "name = " + name + "; hobby = " + hobby
}

object Covariance {

  def main(args: Array[String]): Unit = {
    // 协变
    val jack: Children[Any] = new Children[String]("Jack", "painting")
    println(jack)

    println(jack.reName("Bob"))
  }

}
