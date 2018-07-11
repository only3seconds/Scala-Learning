package generic_and_annotation

/**
  * 泛型类
  * @param name
  * @tparam T
  */
class Person[T] (var name: T)

// 单个泛型参数
class Student[T] (name: T) extends Person[T] (name)

// 多个泛型参数
class Teacher[T, S] (name: T, var age: S) extends Person[T] (name)

object GenericDemo {
  def main(args: Array[String]): Unit = {
    println(new Student[String]("Mary").name)

    println(new Teacher[String, Int]("Bob", 35).name)
    println(new Teacher[String, Int]("Bob", 35).age)
  }
}
