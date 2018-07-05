package class_and_object

/**
  * 只有辅助构造函数的类
  * 在定义辅助构造函数时，需要注意构造函数的顺序
  */
class Student {
  // 类成员
  private var name: String = null
  private var age: Int = 18
  private var sex: Int = 0

  // 辅助构造器 名字为 this
  def this(name: String){
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }

  def this(name: String, age: Int, sex: Int) {
    this(name, age)
    this.sex = sex
  }
}
