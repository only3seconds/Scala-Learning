# Scala 基本类型及操作、程序控制结构

## Scala 基本类型
	Byte Short  Int Long
	Float Double 
	Char String
	Boolean
	
## 基本类型操作
	在 Scala 中一切皆为对象，一切操作皆为方法。
	
### 算术操作

### 关系运算

### 逻辑运算

### 位运算

### 运算符优先级
	

### 对象比较
- Scala中的对象比较 == 不同于 Java 中的对象比较, Scala基于内容比较，而java中比较的是引用，进行内容比较时须定义比较方法。

```scala
scala> val x = new String("Pan Pingping")
x: String = Pan Pingping

scala> val y = new String("Pan Pingping")
y: String = Pan Pingping

scala> x == y
res0: Boolean = true
```

## Scala 程序控制结构

- 注意：与if不同的是，while 与 do while 不能用作表达式，也即其返回值为Unit，可见Scala并不是纯函数式编程语言（另外一个重要原因是，scala函数定义时仍然可以用var指定参数）

- 利用if替代while控制结构，可以减少var变量的使用

- 函数式编程特有的特点

```scala
var line = ""
while ((line = readLine()) != "") // 不能这么用，因为Scala中的赋值操作返回的值是Unit，而""是String类型，不能进行比较，这是函数式编程语言特有的特点
println("Read: "+ line)
```

### for 循环
- 生成器（generator)  <-

```scala
scala> for(i <- 1 to 5) println("P "+i)
P 1
P 2
P 3
P 4
P 5

//如果不需要5出现，则用
scala> for(i <- 1 until 5) println("Iteration"+i)
P 1
P 2
P 3
P 4
```

- 在 for 循环结构中还可以加入 if 进行过滤操作

```scala
val filesHere = (new java.io.File(".")).listFiles

// 加入多个过滤条件，用;隔开
for (
file <- filesHere
if file.isFile;
if file.getName.endsWith(".scala")
) println(file)
```

- 多重循环

```scala
package control_structure

import java.io.File

object MultipleFor {

  val filesHere = (new File(".")).listFiles

  def main(args: Array[String]): Unit = {
    println(filesHere);
    grep("Scala");

  }

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList

  //多重循环 每次循环将结果保留,当整个循环执行完毕,所有保留的值将会生成一个集合并返回
  def grep(pattern: String) =
    for (
      file <- filesHere
      if file.getName.endsWith(".md"); //这里的 ; 一定要有

      line <- fileLines(file)
      if line.trim.matches(pattern)
    ) println(file + ": " + line.trim)

}
```