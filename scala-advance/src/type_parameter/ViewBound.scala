package type_parameter

/**
  * 视图界定
  */

// <% 表示 S 可以是 Comparable 类继承层次结构中的类，也可以是经过隐式转换得到的类，该类实现了 Comparable 接口
case class Teacher[T, S <% Comparable[S]](var name: T, var height: S)

object ViewBound extends App {
  val t1 = Teacher("Bob", "34")

  // Int 类型此时会隐式转换为 RichInt 类型，而 RichInt 类属于 Comparable 继承层次结构
  val t2 = Teacher("Alice", 40)

}
