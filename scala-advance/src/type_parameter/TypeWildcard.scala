package type_parameter

/**
  * 类型通配符
  */
class Plant(val name: String) {
  override def toString: String = name
}

class Tree(name: String) extends Plant(name)
class Flower(name: String) extends Plant(name)

class Pair[T](val first: T, val second: T) {
  override def toString: String = "first = " + first + "; second = " + second
}

object TypeWildcard extends App {
  // 在使用类时才使用类型通配符
  def makeFriends(p: Pair[_<: Plant]) = {
    println(p.first + " make friends with " + p.second)
  }

  makeFriends(new Pair(new Tree("tree"), new Flower("flower")))

}
