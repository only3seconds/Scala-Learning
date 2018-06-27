package scala_patternMatch

/**
  * 使用了case关键字的类定义就是就是样例类(case classes)
  */
object Test3 {
  def main(args: Array[String]): Unit = {
    val alice =  Person("Alice", 25);
    val bob = new Person("Bob", 22);
    val mary = new Person("Mary", 20);

    for (person <- List(alice, bob, mary)) {
      person match {
        case Person("Alice", 25) => println("Hi, Alice!");
        case Person("Bob", 22) => println("Hi, Bob!");
        case Person(name, age) => println("name = " + name + " Age = " +  age);
      }
    }
  }

  /**
    *  声明样例类时,自动发生了:
    *  (1) 构造器的每个参数都成为val，除非显式被声明为var，但是并不推荐这么做
    *  (2) 在伴生对象中提供了apply方法，所以可以不使用new关键字就可构建对象；
    *  (3) 提供unapply方法使模式匹配可以工作
    *  (4) 生成toString、equals、hashCode和copy方法，除非显示给出这些方法的定义。
    */
  case class Person(name: String, age: Int)

}