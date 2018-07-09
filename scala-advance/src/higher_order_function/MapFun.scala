package higher_order_function

/**
  * map 函数, 将一个函数传入map中，然后利用传入的这个函数，将集合中的每个元素处理，并将处理后的结果返回
  */
object MapFun {

  def main(args: Array[String]): Unit = {
    // Array 类型
    val array1 = Array("spark", "hive", "hadoop")
    print("array1 = ")
    for(i <- array1) {
      print(i + " ")
    }

    val array2 = array1.map((x: String) => x * 2)
    print("\narray2 = ")
    for(i <- array2) {
      print(i + " ")
    }

    // List 类型
    val list1 = List("spark" -> 1, "hive" -> 2, "hadoop" -> 3)
    println("\nlist1 = " + list1)

    val list2 = list1.map(x => x._1)
    println("list2 = " + list2)

    // Map 类型
    val map1 = Map("spark" -> 1, "hive" -> 2, "hadoop" -> 3)
    println("map1 = " + map1)

    val map2 = map1.map(_._2)
    println("map2 = " + map2)

  }

}
