# I/O 与正则表达式

	在Scala中，它更多的是调用 java 中的 I/O 类或者通过对 java 中的 I/O 类进行相应的封装来
	实现 I/O 操作。scala自身关于I/O的内容比较少,最常用的只有 Source 这个类.
	
## 一. Scala 写文件

代码：

```scala
package scala_io

import java.io.FileWriter

/**
  * Scala 写文件
  */
object ScalaFileWriter {

  def main(args: Array[String]): Unit = {
    val fileWriter = new FileWriter("file.txt")
    fileWriter.write("Scala file writer")
    fileWriter.flush()
    fileWriter.close()
  }

}
```
运行结果:

	// file.txt
	Scala file writer
	
## 二. 读文件

代码：

```scala
package scala_io

import scala.io.Source

/**
  * Scala 读文件
  */
object ScalaFileReader {

  def main(args: Array[String]): Unit = {
    // 读取文件
    val file = Source.fromFile("/Users/thinking/Documents/workspace/Scala-Learning/scala-advance/src/class_and_object/Animal.scala")
    // 返回 Iterator[String]
    val lines = file.getLines()
    // 打印内容
    for(i <- lines) println(i)
    // 关闭文件
    file.close()
    
  }

}
```

## 三. 网络I/O

- Scala 中的网络 I/O 操作可以通过 Source 对象中的 fromURL 方法来实现，也可以使用原生的JAVA 网络I/O操作进行.

Scala 中的网络 I/O 读取百度首页内容代码：


```scala
package scala_io

import java.net.URL
import scala.io.Source.fromURL

/**
  * Scala 网络 IO
  */
object NetworkIO {

  def main(args: Array[String]): Unit = {
    println(fromURL(new URL("http://www.baidu.com")).mkString)
  }

}
```

## 四. 正则表达式

-  Scala 可以直接通过 Java 操作正则表达式的方式使用正则表达式，但 scala 实现了自己的方式，它更为灵活。

代码：

```scala
package scala_io

/**
  * Scala 正则表达式
  */
object RegexMatch {
  def main(args: Array[String]): Unit = {
    // 匹配邮箱
    val sparkRegex1 = "^([\\w-]+(\\.[\\w-]+)*)@[\\w-]+(\\.[\\w-]+)+$".r // r是一个方法调用，返回正则表达式对象
    for(matchString <- sparkRegex1.findAllIn("TripleP3@163.com")) {
      println(matchString)
    }

    // 提取邮箱中的用户名
    for(sparkRegex1(domainName, _*) <- sparkRegex1.findAllIn("TripleP3@163.com")) {
      println("邮箱用户名为：" + domainName)
    }

    // 匹配网址
    val sparkRegex2 = "^[a-zA-Z]+://(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*(\\?\\s*)?$".r
    for(matchString <- sparkRegex2.findAllIn("http://www.baidu.com")) {
      println(matchString)
    }

    // 匹配手机号码
    val sparkRegex3 = "(86)*0*13\\d{9}".r
    for(matchString <- sparkRegex3.findAllIn("15295668721")) {
      println(matchString)
    }

    // 匹配 ip 地址
    val sparkRegex4 = "(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r
    for(matchString <- sparkRegex4.findAllIn("192.168.1.1")) {
      println(matchString)
    }

    // 提取匹配的 ip 子段
    for(sparkRegex4(one, two, three, four) <- sparkRegex4.findAllIn("192.168.1.1")) {
      println("IP 子段1：" + one)
      println("IP 子段2：" + two)
      println("IP 子段3：" + three)
      println("IP 子段4：" + four)
    }
  }

}

```

运行结果：

	TripleP3@163.com
	邮箱用户名为：TripleP3
	http://www.baidu.com
	192.168.1.1
	IP 子段1：192
	IP 子段2：168
	IP 子段3：1
	IP 子段4：1


