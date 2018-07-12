package type_parameter

/**
  * 类型变量界定 <:
  *
  */

case class Person(var name: String, var age: Int) extends Comparable[Person] {
    def compareTo(o: Person): Int = {
    if(this.age > o.age) 1
    else if(this.age == o.age) 0
    else -1
  }
}

// 对类中的泛型进行范围限定
case class Student[S, T <: AnyVal](var name: S, var height: T)

class TypeVariableBound {
  def compare[T <: Comparable[T]](first: T, second: T) = {
    if(first.compareTo(second) > 0)
      first
    else
      second
  }

}

object TypeVariableBound {
  def main(args: Array[String]): Unit = {
    val tvb = new TypeVariableBound

    println(tvb.compare("A", "B"))
    println(tvb.compare(Person("Alice", 23), Person("Mary", 24)))

    val s1 = Student("Bob", 170.0)
    val s2 = Student("Stephen", 170L)
    // val s3 = Student("Mary", "160") 报错：type mismatch
  }
}
