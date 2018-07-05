package class_and_object

/**
  * 带主构造函数、辅助构造函数的类
  */
class Employee(var name:String, var age: Int) {
  // 类成员
  private var sex: Int = 0

  // 辅助构造器
  def this(name: String, age:Int, sex: Int) {
    this(name, age)
    this.sex = sex
  }

}
