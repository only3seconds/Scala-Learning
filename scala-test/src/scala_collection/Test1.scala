package scala_collection

/**
  *
  * Scala 列表类似于数组，它们所有元素的类型都相同，但是它们也有所不同：列表是不可变的，值一旦被定义了就不能改变
  * 列表 具有递归的结构（也就是链接表结构）而数组不是
  *
  * Scala List 有三个基本操作：
  * head 返回列表第一个元素
  * tail 返回一个列表，包含除了第一元素之外的其他元素
  * isEmpty 在列表为空时返回true
  */
object Test1 {
  def main(args: Array[String]): Unit = {
    val site = "Runoob" :: ("Google" :: ("Baidu" :: Nil));
    val nums = Nil;

    println("第一个网站是： " + site.head);
    println("最后一个网站是： " + site.tail);
    println("查看列表 site 是否为空：" + site.isEmpty);
    println("查看列表 nums 是否为空： " + nums.isEmpty);

  }

}
