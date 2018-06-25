package scala_collection

/**
  * List.fill() 方法来创建一个指定重复数量的元素列表
  */
object Test3 {
  def main(args: Array[String]): Unit = {
    var site = List.fill(3)("Runoob"); //重复 Runoob 3次

    println("site: " + site);

    var nums = List.fill(10)(2); //重复2，10次
    println("nums: " + nums);


  }

}
