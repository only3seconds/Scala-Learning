package scala_collection

/**
  * 连接 List 的 3 种方法
  */
object Test2 {

  def main(args: Array[String]): Unit = {
    var site1 = "Runoob" :: ("Google" :: ("Baidu" :: Nil));
    var site2 = "Facebook" :: ("Taobao" :: Nil);

    //使用 ::: 运算符
    var fruit = site1 ::: site2;
    println("site1 ::: site2 = " + fruit);

    //使用 List.:::() 方法
    fruit = site1.:::(site2);
    println("site1.:::(site2) = " + fruit);

    //使用 concat 方法
    fruit = List.concat(site1, site2);
    println("List.concat(site1, site2) = " + fruit);



  }

}
