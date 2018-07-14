package type_parameter

/**
  * Scala Ordered 使用
  */
case class Pet(val name: String) extends Ordered[Pet] {
  override def compare(that: Pet): Int = {
    if(this.name == that.name) {
      return 1
    } else {
      return -1
    }
  }
}

class Pair1[T <: Ordered[T]](val first: T, val second: T) {
  def smaller() = {
    if (first < second)
      first
    else
      second
  }
}

object OrderedViewBound extends App {
  val p = new Pair1(Pet("Dog"), Pet("Cat"))
  println(p.smaller())
  println(Pet("Dog").compare(Pet("Cat")))
}
