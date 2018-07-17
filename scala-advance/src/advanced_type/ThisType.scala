package advanced_type

/**
  * this.type 返回实际类型
  */
class Person {
  private var name: String = null
  private var age: Int = 0

  def setName(name: String): this.type = {
    this.name = name
    // 返回对象本身
    this
  }

  def setAge(age: Int): this.type = {
    this.age = age
    this
  }

  override def toString: String = "name = " + name + "; age = " + age
}

class Student extends Person {
  private var studentNo: String = null

  def setStudentNo(studentNo: String) = {
    this.studentNo = studentNo
    this
  }

  override def toString: String = "studentNo = " + studentNo
}

object ThisType extends App {

  // 链式调用，如果不用 this.type，则不能编译通过，因为 setName, setAge 返回的类型是 Person, 而 Person 类没有 setStudentNo 方法
  println(new Student().setName("Mary").setAge(24).setStudentNo("29184592"))
}
