package pattern_matching

/**
  * case class 样例类
  */

// sealed的作用：模式匹配时，如果没有匹配所有的情况，编译器会提示
sealed abstract class Person

// 样例类
case class Student(name: String, age: Int, studentNo: Int) extends Person
case class Teacher(name: String, age: Int, teacherNo: Int) extends Person
case class Nobody(name: String) extends Person

// 接受多个 Person 类型参数
case class SchoolClass(description: String, persons: Person*)

object CaseClassDemo {

  def main(args: Array[String]): Unit = {
    val p: Person = Student("Mary", 24, 1001)

    p match {
      case Student(_, age, studentNo) => println("Student:" + " age = " + age + " studentNo = " + studentNo)
      case Teacher(name, age, teacherNo) => println("Teacher: name = " + name + " age = " + age + " studentNo = " + teacherNo)
      //case Nobody(name) => println("Nobody: name = " + name)
    }

    val t = Teacher("John", 38, 2918)

    // 无参 copy 方法
    val t1 = t.copy()
    println(t1)
    // copy 方法是深拷贝
    println("t equals t1 = " + (t equals t1))
    println("t eq t1 = " + (t eq t1))

    println("带一个参数的 copy 方法：" + t.copy(name = "Bob"))
    println("带两个参数的 copy 方法：" + t.copy(name = "Bob", age = 40))
    println("带三个参数的 copy 方法：" + t.copy(name = "Bob", age = 40, teacherNo = 2919))

    // hashcode 方法
    println("hashcode = " + t.hashCode)

    // toString 方法
    println("toString = " + t.toString)

    val sc = SchoolClass("Scala Learning", Teacher("Bob", 35, 2918), Student("Mary", 24, 1001))

    sc match {
      case SchoolClass(_, _, Student(name, age, studentNo)) => println("SchoolClass Student: " + name)
      case _ => println("Nobody")
    }
  }
}