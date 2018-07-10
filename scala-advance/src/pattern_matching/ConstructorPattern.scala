package pattern_matching

/**
  * 构造器模式
  */
case class Animal(name: String, age: Int)

object ConstructorPattern {
  def main(args: Array[String]): Unit = {
    val animal = new Animal("Dog", 4)

    def constructorPattern(animal: Animal) = animal match {
      case Animal(name, age) => "Animal"
      case _ => "Other"
    }

    println(constructorPattern(animal))

  }

}
