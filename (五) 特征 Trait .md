# 特征 Traits 

- 对于不存在具体实现及字段的 trait, 它最终生成的字节码文件反编译后等同于 java 中的接口

- 带有具体实现的 trait 是通过 java 中的抽象类来实现的

- 注意：trait 重的抽象属性和方法都不要用 abstract

## 1. trait 构造顺序
trait 构造器按照以下顺序执行：

- 1.如果有超类，则先调用超类的构造器

- 2.如果有父 trait, 它会按照继承层次先调用父 	trait 的构造器

- 3.如果有多个父 trait,则按顺序从左到右执行

- 4.所有父类，父 trait 构造完之后，才会构造本类

代码：

```scala
package scala_trait

import java.io.PrintWriter

/**
  * trait 构造顺序
  */


trait Logger {
  println("Logger")

  def log(msg: String): Unit

}

trait FileLogger extends Logger {
  println("FileLogger")
  val fileOutput = new PrintWriter("file.log")
  fileOutput.println("#")

  def log(msg: String): Unit = {
    fileOutput.print(msg)
    fileOutput.flush()
  }
}

object TraitDemo {
  def main(args: Array[String]): Unit = {

    // 匿名类
    new FileLogger {}.log("trait demo")
  }
}

```

运行结果：

	// 打印输出内容为：
	Logger
	FileLogger

	//创建文件 file.log，内容为：
	#
	trait demo
