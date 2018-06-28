# Scala 集合 Array List

## 一. 数组
	Scala 中的 Array 以 Java 中 Array 实现

### 1. 初始化
- 数值型被初始化为 0， 复杂对象类型在数组定义时被初始化为 null
	
### 2. 定长数组 Array

- 两种定长数组的定义方法

```scala
val strArray1 = new Array[String](10)

// 实际上是调用 apply 方法进行数组创建
val strArray2=Array("First","Second")
```

### 3. 变长数组 ArrayBuffer

(1) String 类型 ArrayBuffer 数组缓冲

代码：

```scala
package collection

import scala.collection.mutable.ArrayBuffer

object ArrayBufferString {

  def main(args: Array[String]): Unit = {
    val str = ArrayBuffer[String]()

    // += 是在尾部添加一个或多个元素
    str += "Hello"
    str += ("Pan", "Pingping")
    println("在尾部添加元素后：" + str)

    // ++= 是在尾部添加任何一个集合
    str ++= Array("Lu", "Weiling")
    str ++= List("Love")
    println("在尾部添加集合后：" + str)

    // 在尾部删除 n 个元素
    str.trimEnd(3)
    println("在尾部删除元素后：" + str)

    // 删除任意位置元素
    str.remove(2)
    println("删除某个元素后：" + str)

  }

}
```
运行结果：

	在尾部添加元素后：ArrayBuffer(Hello, Pan, Pingping)
	在尾部添加集合后：ArrayBuffer(Hello, Pan, Pingping, Lu, Weiling, Love)
	在尾部删除元素后：ArrayBuffer(Hello, Pan, Pingping)
	删除某个元素后：ArrayBuffer(Hello, Pan)
	
(2) Int 型 ArrayBuffer 数组缓冲
 代码：
 
``` scala 
package collection

import scala.collection.mutable.ArrayBuffer

object ArrayBufferInt {

  def main(args: Array[String]): Unit = {
    var intArrayVar = ArrayBuffer(1, 2, 3)

    // 在数组为 0 的位置插入元素
    intArrayVar.insert(0, 4)
    intArrayVar.insert(0, 5, 6)
    println("在位置 0 插入元素后为：" + intArrayVar)

    // 从索引 1 开始删除2个元素
    intArrayVar.remove(1, 2)
    println("删除元素后：" + intArrayVar)

    // 变长数组转成定长数组
    intArrayVar.toArray 

    // 定长数组转成变长数组
    intArrayVar.toBuffer

  }

}
```


运行结果：
	
	在位置 0 插入元素后为：ArrayBuffer(5, 6, 4, 1, 2, 3)
	删除元素后：ArrayBuffer(5, 1, 2, 3)
	
### 4. 数组的遍历




