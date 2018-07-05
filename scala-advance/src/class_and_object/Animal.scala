package class_and_object

/**
  * 抽象类
  */
abstract class Animal {
  var age: Int

  def eat: Unit

}

class Dog(var age: Int) extends Animal {

  // 注意这里可以不加 override 关键字
  def eat() = {
    println("Dog eat meat")
  }
}

// 通过扩展 App 创建程序的入口
object Dog extends App {
  new Dog(2).eat()
}
