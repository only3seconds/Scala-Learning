package basic_concepts

object add {

  def main(args: Array[String]): Unit = {
    System.out.println("Returned value: " + addInt(1, 2));
  }

  def addInt(a:Int, b:Int) : Int = {
    var sum : Int = 0;
    sum = a + b;
    return sum;
  }

}
