package scala_string

object Test3 {

  def main(args: Array[String]): Unit = {
    var intVar = 2000;
    var floatVar = 1.314;
    var stringVar = "野白色";

    var fs = printf("整型变量为: %d," + "浮点型变量为: %f," + "字符串为: %s", intVar,floatVar,stringVar);

    println(fs);

  }

}
