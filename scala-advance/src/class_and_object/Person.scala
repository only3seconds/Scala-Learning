package class_and_object

/**
  * 不但定义了一个类Person，还定义了主构造器，主构造器的参数为String、Int类型
  * @param name
  * @param age
  */

class Person (var name: String, var age: Int) {

  // println将作为主构建器中的一部分，在创建对象时被执行
  println("Constructing Person ...")

  // 重写 toString 方法
  override def toString: String = name + ": " + age

}

object Test {
  def main(args: Array[String]): Unit = {
    val p = new Person("Mary", 24)

    println("name = " + p.name)
    println("调用 toString 方法：" + p.toString)
    p.age = 21
    println("new age = " + p.age)

  }
}