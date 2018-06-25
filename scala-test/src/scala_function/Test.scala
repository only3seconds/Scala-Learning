package scala_function

/**
  * 传名调用
  */
object Test {

  def main(args: Array[String]) {
    delayed(time());
  }

  def time() = {
    print("获取时间，单位为纳秒");
    System.nanoTime;
  }

  /**
    * 在变量名和变量类型使用 => 符号来设置传名调用
    * @param t
    * @return
    */
  def delayed(t: =>Long) = {
    println("在 delayed 方法内"); //打印一条信息表示进入 delayed 方法
    println("参数： " + t);
    t
  }

}
