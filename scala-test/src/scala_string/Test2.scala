package scala_string

/**
  * 字符串连接
  */
object Test2 {
  def main(args: Array[String]) {
    var str1 = "潘平平的 github 地址是：";
    var str2 =  "https://github.com/only3seconds";
    var str3 =  "潘平平的 Slogan 为：";
    var str4 =  "每一个未曾起舞的日子都是对生命的辜负！";
    println( str1 + str2 );
    println( str3.concat(str4) );
  }
}
