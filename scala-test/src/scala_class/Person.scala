package scala_class

/**
  * Scala重写一个非抽象方法，必须用override修饰符。
  * (只有主构造函数才可以往基类的构造函数里写参数。)
  */
class Person {
  var name = "";

  override def toString: String = getClass.getName + "[name = " + name + "]"

}

class Employee extends Person {
  var salary = 0.0;

  override def toString: String = super.toString + "[salary = " + salary + "]"
}

object Test extends App {
  val fred = new Employee;

  fred.name = "Fred";
  fred.salary = 50000;
  println(fred);
}
