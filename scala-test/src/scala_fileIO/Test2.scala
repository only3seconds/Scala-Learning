package scala_fileIO

/**
  * 接受用户从屏幕输入
  */

import java.io.{BufferedReader, InputStreamReader}

object Test2 {
  def main(args: Array[String]): Unit = {
    print("请输入 Scala 的创始人：");

    //val line = Console.readLine() 已经过时
    val br = new BufferedReader(new InputStreamReader(System.in));
    val line = br.readLine();

    println("谢谢，你的输入是：" + line);


  }

}
