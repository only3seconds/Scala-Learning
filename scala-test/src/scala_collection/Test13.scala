package scala_collection

/**
  * Option(选项)类型用来表示一个值是可选的（有值或无值)。
  * Option[T] 是一个类型为 T 的可选值的容器：若值存在，Option[T]就是一个Some[T]，若不存在，Option[T]就是对象None
  *
  * getOrElse() 方法来获取元组中存在的元素或者使用其默认的值
  * isEmpty() 方法来检测元组中的元素是否为 None
  */
object Test13 {

  def main(args: Array[String]): Unit = {
    val sites = Map("runoob" -> "www.runoob.com", "google" -> "www.google.com");

    println("sites.get(\"runoob\") : " + sites.get("runoob"));
    println("sites.get(\"baidu\") : " + sites.get("baidu"));

    println("show(sites.get(\"runoob\"): " + show(sites.get("runoob")));
    println("show(sites.get(\"baidu\"): " + show(sites.get("baidu")));


    val a:Option[Int] = Some(5);
    val b:Option[Int] = None;

    println(a.getOrElse(1));
    println(b.getOrElse(99));

    println("a is empty: " + a.isEmpty);
    println("b is enpty: " + b.isEmpty);
  }

  //模式匹配输出匹配值
  def show(x: Option[String]) = x match {
    case Some(s) => s; //匿名函数，如果结果为Some(s),则 return s
    case None => "?";
  }


}
