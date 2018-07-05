package class_and_object

/**
  * 伴生对象和伴生类
  * 可以互相访问对方的成员包括私有成员
  *
  * @param name
  * @param age
  */
class StudentSample(var name: String, var age: Int) {
  private var sex: Int = 0

  // 直接访问伴生对象的私有成员
  def printCompanionObject() = println(StudentSample.studentNo)
}

object StudentSample {

  private var studentNo: Int = 0;

  def uniqueStudentNo() = {
    studentNo += 1
    studentNo
  }

  // 定义自己的 apply 方法
  def apply(name: String, age: Int) = new StudentSample(name, age)


  def main(args: Array[String]): Unit = {
    println("studentNo = " + StudentSample.uniqueStudentNo())

    val s1 = new StudentSample("Mary", 24)
    // 直接访问伴生类中的私有成员
    println("sex = " + s1.sex)

    // 直接利用类名进行对象的创建
    val s2 = StudentSample("Mary", 24)
    println("name = " + s2.name)
    println("age = " + s2.age)

  }

}
