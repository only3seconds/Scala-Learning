package scala_array
import Array._

/**
  * 二维数组
  */
object Test2 {

  def main(args: Array[String]): Unit = {
    var myMatrix = ofDim[Int](3, 3);

    //创建矩阵
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        myMatrix(i)(j) = j;
      }
    }

    //打印二维阵列
    for (i <- 0 to 2) {
      for (j <- 0 to 2) {
        print(" " + myMatrix(i)(j));
      }
      println();
    }
  }

}
