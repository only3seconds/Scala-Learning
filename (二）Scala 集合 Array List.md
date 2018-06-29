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

    // 数组遍历的各种方法
    // 方法一：数组方式，推荐使用
    for (i <- intArrayVar) println("遍历方法1：" + i);
    // 方法二: to
    for (i <- 0 to intArrayVar.length -1) println("遍历方法2：" + intArrayVar(i));
    // 方法三: until
    for (i <- 0 until  intArrayVar.length) println("遍历方法3：" + intArrayVar(i));
    // 方法四：步长为 2
    for (i <- 0 until (intArrayVar.length, 2)) println("遍历方法4：" + intArrayVar(i));
    // 方法五：逆序输出
    for (i <- (0 to intArrayVar.length - 1).reverse) println("遍历方法5：" + intArrayVar(i));

    // 在数组为 0 的位置插入元素
    intArrayVar.insert(0, 4)
    intArrayVar.insert(0, 5, 6)
    println("在位置 0 插入元素后为：" + intArrayVar)

    // 从索引 1 开始删除2个元素
    intArrayVar.remove(1, 2)
    println("删除元素后：" + intArrayVar)

    // 变长数组转成定长数组
    intArrayVar.toArray  // 怎么打印出 toArray 后的数组？

    // 定长数组转成变长数组
    intArrayVar.toBuffer

  }

}
```


运行结果：
	 
	遍历方法1：1
	遍历方法1：2
	遍历方法1：3
	遍历方法2：1
	遍历方法2：2
	遍历方法2：3
	遍历方法3：1
	遍历方法3：2
	遍历方法3：3
	遍历方法4：1
	遍历方法4：3
	遍历方法5：3
	遍历方法5：2
	遍历方法5：1
	在位置 0 插入元素后为：ArrayBuffer(5, 6, 4, 1, 2, 3)
	删除元素后：ArrayBuffer(5, 1, 2, 3)
	
### 4. 数组转换 & 数组常用算法 & 多维数组

（1）例子

代码：

``` scala
package collection

import scala.collection.mutable.ArrayBuffer

/**
  * 数组转换，生成新的数组，原数组不变
  */
object ArrayConversion {
  def main(args: Array[String]): Unit = {
    var intArrayNoBuffer = Array(1, 2, 3)
    var intArrayBuffer = ArrayBuffer(4, 5, 6)

    // 多维数组
    val multiArr = Array(Array(1, 2, 3), Array(4, 5, 6))
    println("获取第一行第三列：" + multiArr(0)(2))
    // 多维数组遍历
    for (i <- multiArr) println(i.mkString(","))


    // 数组常用算法
    println("intArrayNoBuffer 元素之和：" + intArrayNoBuffer.sum)
    println("intArrayNoBuffer 最大元素：" + intArrayNoBuffer.max)
    println("intArrayNoBuffer 最小元素：" + intArrayNoBuffer.min)
    println("intArrayNoBuffer toString：" + intArrayNoBuffer.toString)
    println("intArrayNoBuffer mkString：" + intArrayNoBuffer.mkString("#"))
    println("intArrayNoBuffer mkString(, , ,)：" + intArrayNoBuffer.mkString("<", "#", ">"))
    
    // 定长数组转转后产生的仍然是定长数组
    var intArrayNoBuffer1 = for (i <- intArrayNoBuffer) yield i * 2
    // println(intArrayNoBuffer1)
    for (i <- intArrayNoBuffer1) print(i + " ")
    println();

    // 缓冲数据转换后产生的仍然是缓冲数组
    var intArrayBuffer1 = for (i <- intArrayBuffer) yield i * 2
    println(intArrayBuffer1)

    // 加入过滤条件
    var intArrayBuffer2 = for (i <- intArrayBuffer if i >= 5 ) yield i * 2
    println(intArrayBuffer2)

  }

}

```
运行结果：

	intArrayNoBuffer 元素之和：6
	intArrayNoBuffer 最大元素：3
	intArrayNoBuffer 最小元素：1
	intArrayNoBuffer toString：[I@34ce8af7
	intArrayNoBuffer mkString：1#2#3
	intArrayNoBuffer mkString(, , ,)：<1#2#3>
	2 4 6 
	ArrayBuffer(8, 10, 12)
	ArrayBuffer(10, 12)

	
（2）yied

	For each iteration of your for loop, yield generates a value which will be
	remembered. It's like the for loop has a buffer you can't see, and for each 
	iteration of your for loop, another item is added to that buffer. When your
	for loop finishes running, it will return this collection of all the yielded 
	values. The type of the collection that is returned is the same type that 
	you were iterating over, so a Map yields a Map, a List yields a List, and so 
	on.
	Also, note that the initial collection is not changed; the for/yield
	construct creates a new collection according to the algorithm you specify.
	
## 列表 List

List 和 Array 相似，但有两个明显区别

- List 是不可变的，其值一旦创建，不可改变

- List 具有递归结构(Recursive Structure)，类似链表

- List 和其他类型集合一样，它具有协变性（convariant)：对于 S 和 T， 如果 S 是 T 的子类型， 则 List[S] 是 List[T] 的子类型。空的 List, 其类型为 Nothing, Nothing 在 Scala 继承层中的最低层。

### 1. List 常用操作






