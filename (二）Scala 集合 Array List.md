# Scala 集合

可变（mutable)集合 和 不可变(immutable)集合
	
	Scala collections systematically distinguish between mutable and immutable 
	collections. A mutable collection can be updated or extended in place. 
	This means you can change, add, or remove elements of a collection as a side 
	effect. Immutable collections, by contrast, never change. You have still
	operations that simulate additions, removals, or updates, but those 
	operations will in each case return a new collection and leave the old 
	collection unchanged.
	
	(1) scala 中的集合分为两种，一种是可变的集合，另一种是不可变的集合
	(2) 可变集合可以更新或修改，添加、删除、修改元素将作用于原集合
	(3) 不可变集合一量被创建，便不能被改变，添加、删除、更新操作返回的是新的集合，原集合保持不
	变
	
函数式编程语言推崇使用不可变集合， 在 scala 中，默认使用的都是 不可变集合，如果要用可变集合，需要在程序中引入
	
	

## 一. Array 数组 
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
	
## 二. List 列表

List 和 Array 相似，但有两个明显区别

- List 是不可变的，其值一旦创建，不可改变

- List 具有递归结构(Recursive Structure)，类似链表

- List 和其他类型集合一样，它具有协变性（convariant)：对于 S 和 T， 如果 S 是 T 的子类型， 则 List[S] 是 List[T] 的子类型。空的 List, 其类型为 Nothing, Nothing 在 Scala 继承层中的最低层。

### 1. List 常用操作

代码：

``` scala
package collection

/**
  * List 常用操作
  */
object ListOperation {
  def main(args: Array[String]): Unit = {
    val nums = 1:: (2:: (3:: (4:: Nil)))
    val chars = 'a' :: 'b' :: 'c' :: 'd' :: Nil
    val testNums = 5 :: 6 :: 2 :: 0 ::9 :: Nil


    println("判断是否为空：" + nums.isEmpty)

    println("取第一个元素：" + nums.head)

    println("取最后一个元素" + nums.last)

    println("取除第一个元素外剩余的元素，返回的是列表：" + nums.tail)

    println("取除了最后一个元素外剩余的元素，返回的是列表：" + nums.init)

    println("取第二个元素：" + nums.tail.head)

    println("取前 n 个元素(方式一）：" + (nums take 3))
    println("取前 n 个元素(方式二）：" + nums.take(3))

    println("丢弃前 n 个元素(方式一）：" + (nums drop 3))
    println("丢弃前 n 个元素(方式二）：" + nums.drop(3))

    println("列表元素倒置：" + nums.reverse)

    println("将列表进行分割：" + nums.splitAt(2))

    println("List toString 方法：" + nums.toString)
    println("List mkString 方法：" + nums.mkString("#"))

    println("List 转换成 Array：" + nums.toArray)

    println("连接 nums 和 chars：" + nums.:::(chars))

    println("List zip 操作(方式一)：" + (nums zip chars))
    println("List zip 操作(方式二)：" + nums.zip(chars))

    println("List 插入排序：" + insertSort(testNums))

  }

  /**
    * List 插入排序算法实现
    * @param xs
    * @return
    */
  def insertSort(xs: List[Int]): List[Int] = {
    if(xs.isEmpty) Nil
    else insert(xs.head, insertSort(xs.tail))
  }

  def insert(x: Int, xs: List[Int]): List[Int] = {
    if(xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)
  }
}
```

运行结果：

	判断是否为空：false
	取第一个元素：1
	取最后一个元素4
	取除第一个元素外剩余的元素，返回的是列表：List(2, 3, 4)
	取除了最后一个元素外剩余的元素，返回的是列表：List(1, 2, 3)
	取第二个元素：2
	取前 n 个元素(方式一）：List(1, 2, 3)
	取前 n 个元素(方式二）：List(1, 2, 3)
	丢弃前 n 个元素(方式一）：List(4)
	丢弃前 n 个元素(方式二）：List(4)
	列表元素倒置：List(4, 3, 2, 1)
	将列表进行分割：(List(1, 2),List(3, 4))
	List toString 方法：List(1, 2, 3, 4)
	List mkString 方法：1#2#3#4
	List 转换成 Array：[I@17550481
	连接 nums 和 chars：List(a, b, c, d, 1, 2, 3, 4)
	List zip 操作(方式一)：List((1,a), (2,b), (3,c), (4,d))
	List zip 操作(方式二)：List((1,a), (2,b), (3,c), (4,d))
	List 插入排序：List(0, 2, 5, 6, 9)
	
### 2. List 伴生对象方法

代码：

```scala
package collection

/**
  * List 伴生对象方法
  */
object CompanionObjectMethod {
  def main(args: Array[String]): Unit = {
    println("apply 方法：" + List.apply(1, 2, 3))

    println("range 方法：" + List.range(2, 6))
    println("range 方法，步长为 2：" + List.range(2, 6, 2))
    println("range 方法，步长为 -1：" + List.range(6, 2, -2))

    println("fill 方法，构建相同元素：" + List.fill(5)("hey"))

    val nums = List.apply(1, 2, 3, 4)
    val chars = List.apply('a', 'b', 'c', 'd')

    println("concat 方法，List 连接：" + List.concat(nums, chars))

    val zipped = nums zip chars
    println("unzip 方法" + zipped.unzip)

    val xss = List(List('a', 'b'), List('c'), List('d', 'e'))
    println("flatten，将 List 平滑成第一个元素：" + xss.flatten)

  }

}
```

运行结果：

	apply 方法：List(1, 2, 3)
	range 方法：List(2, 3, 4, 5)
	range 方法，步长为 2：List(2, 4)
	range 方法，步长为 -1：List(6, 4)
	fill 方法，构建相同元素：List(hey, hey, hey, hey, hey)
	concat 方法，List 连接：List(1, 2, 3, 4, a, b, c, d)
	unzip 方法(List(1, 2, 3, 4),List(a, b, c, d))
	flatten，将 List 平滑成第一个元素：List(a, b, c, d, e)
	
## 三. Set 集
Set (集）是一种不存在重复元素的集合，它与数学上定义的集合是对应的

- 默认情况下，Set 的实现方式是 HashSet 实现方式，Set 中的元素通过 HashCode 值进行组织
- Set 插入元素时并不保持元素顺序

代码：

```scala
package collection

import scala.collection.mutable

object SetOperation {
  def main(args: Array[String]): Unit = {

    val numsSet = mutable.Set(3.0, 5)
    println(numsSet)

    // Set 插入元素时，并不保持元素顺序
    println("向 Set 中插入一个元素：" + (numsSet + 6))

    // 可以用 LinkedHashSet 保持元素插入顺序
    val linkedHashSet = mutable.LinkedHashSet(3.0, 5)
    println("向 LinkedHashSet 插入一个元素：" + (linkedHashSet + 6))

  }

}
```

运行结果：

	Set(5.0, 3.0)
	向 Set 中插入一个元素：Set(5.0, 6.0, 3.0)
	向 LinkedHashSet 插入一个元素：Set(3.0, 5.0, 6.0)

## 四. Map 映射
	Map 是一种键值对的集合
	
### 1. Option, Some, None 类型

- Some, None 是 Option 的子类

- 在 Java 中，对于定义好的 HashMap, 如果 get 方法传入的键不存在，方法会返回 null, 如果没有对 null 这种情况进行特殊处理，就会有 NullPointerException. 在 scala 中通过 Option 来解决这个问题

- 在 Scala 中通过模式匹配来获得 Option 的最终结果

### 2. 例子

代码：

```scala
package collection

import scala.collection.mutable

/**
  * Map 操作
  */
object MapOperation {

  def main(args: Array[String]): Unit = {

    // 初始化
    val studentInfoMutable1 = mutable.Map("Jhon" -> 20, "Stephen" -> 21, "Lucy" -> 22)
    val studentInfoMutable2 = mutable.Map(("Jhon", 20), ("Stephen", 21), ("Lucy", 22))

    // 遍历操作
    println("遍历方式一：")
    for(i <- studentInfoMutable1) println(i)

    println("遍历方式二：")
    studentInfoMutable1.foreach(e =>
    {val (k, v) = e
    println(k + ":" + v)
    }
    )

    println("遍历方式三：")
    studentInfoMutable1.foreach(e =>
    {
      println(e._1 + ":" + e._2)
    }
    )


    // clear: 清空
    println("clear 清空 studentInfoMutable2 后：" + studentInfoMutable2.clear())

    // put: 添加元素
    studentInfoMutable2.put("spark", 1)

    // contains: 是否包含该关键字
    println("Map 中是否包含关键字 spark: " + studentInfoMutable2.contains("spark"))

    // get: 获取元素
    println("获取 键 spark 对应的 Option：" + studentInfoMutable2.get("spark"))
    println("获取 键 hive 对应的 Option：" + studentInfoMutable2.get("hive"))
    println("获取 键 spark 对应的 value：" + show(studentInfoMutable2.get("spark")))
    println("获取 键 hive 对应的 value：" + show(studentInfoMutable2.get("hive")))


  }

  // 模式匹配获取 Option 中的内容， 这个函数的返回类型为 Any
  def show(x: Option[Int]) = x match {
    case Some(s) => s
    case None => "???"

  }


}
```

运行结果：

	遍历方式一：
	(Stephen,21)
	(Jhon,20)
	(Lucy,22)
	遍历方式二：
	Stephen:21
	Jhon:20
	Lucy:22
	遍历方式三：
	Stephen:21
	Jhon:20
	Lucy:22
	clear 清空 studentInfoMutable2 后：()
	Map 中是否包含关键字 spark: true
	获取 键 spark 对应的 Option：Some(1)
	获取 键 hive 对应的 Option：None
	获取 键 spark 对应的 value：1
	获取 键 hive 对应的 value：???


## 五. Tuple 元组
	Tuple 是不同类型值的聚集
	
代码：

```scala
package collection

object TupleOperation {

  def main(args: Array[String]): Unit = {

    // 定义 tuple
    val tuple = ("Hello", 520, 'a')
    println("tuple = " + tuple)

    // 访问元组元素
    println("通过下标访问数组元素：")
    println("第一个元素为：" + tuple._1)
    println("第二个元素为：" + tuple._2)
    println("第三个元素为：" + tuple._3)

    // 通过模式匹配访问元组元素
    println("通过模式匹配访问元组元素：")
    val (first, second, third) = tuple
    println("第一个元素为：" + first)
    println("第二个元素为：" + second)
    println("第三个元素为：" + third)
  }

}
```

运行结果：

	tuple = (Hello,520,a)
	通过下标访问数组元素：
	第一个元素为：Hello
	第二个元素为：520
	第三个元素为：a
	通过模式匹配访问元组元素：
	第一个元素为：Hello
	第二个元素为：520
	第三个元素为：a

## 六. Queue 队列

代码：

```scala
package collection

object QueueOperation {

  def main(args: Array[String]): Unit = {
    var queue1 = scala.collection.mutable.Queue(1, 2, 3)
    var queue2 = scala.collection.immutable.Queue(1, 2, 3)

    // 出队
    println("出队（可变队列）：" + queue1.dequeue)
    println("出队（不可变队列）：" + queue2.dequeue)

    // 入队
    queue1.enqueue(4)
    println("入队（可变队列）：" + queue1)
    println("入队（不可变队列）：" + queue2.enqueue(4))

    println("可变队列：" + (queue1 += 5))
    //queue2 += 5 报错，不可变队列是不能修改的

    // 集合方式
    println("可变队列追加一个集合：" + (queue1 ++= List(6, 7, 8)))

    queue2 ++= List(6, 7, 8) // 将会生成一个新的队列，注意 ++ 操作 与 + 操作的区别
    println("不可变队列追加一个集合：" + queue2)

  }
}
```

运行结果：

	出队（可变队列）：1
	出队（不可变队列）：(1,Queue(2, 3))
	入队（可变队列）：Queue(2, 3, 4)
	入队（不可变队列）：Queue(1, 2, 3, 4)
	可变队列：Queue(2, 3, 4, 5)
	可变队列追加一个集合：Queue(2, 3, 4, 5, 6, 7, 8)
	不可变队列追加一个集合：Queue(1, 2, 3, 6, 7, 8)
	
	
## 七. Stack 栈

代码：

```scala
package collection

import scala.collection.mutable.Stack

/**
  * Stack 操作
  */
object StackOperation {

  def main(args: Array[String]): Unit = {
    // apply 创建方式
    val stack = Stack(1, 2, 3)

    // 出栈：pop
    println("pop 出栈：" + stack.pop())

    // 入栈：push
    println("push 入栈：" + stack.push(4))

    // 取栈顶元素：top
    println("top 取栈顶元素：" + stack.top)
    println("top 后的栈：" + stack) //top 操作并不会影响到栈


  }

}
```

运行结果：

	pop 出栈：1
	push 入栈：Stack(4, 2, 3)
	top 取栈顶元素：4
	top 后的栈：Stack(4, 2, 3)
	
	








