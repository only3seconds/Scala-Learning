# 提取器(Extractor)

## 一. apply 和 unapply 方法

- 在用类进行模式匹配的时候可以将类声明为 case class，也可以不通过case class，而是定义一个普通的类实现自己的 apply 和 unapply 方法来实现模式匹配

代码：

```scaka
package extractor

object EMail {
  //apply 方法用于无 new 构造对象
  def apply(user: String, domain: String) = user + "@" + domain

  //unapply 方法用于在模式匹配中充当 extractor
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

/**
  * apply 与 unapply 方法
  */
object ApplyAndUnapply extends App {

  def patternMatching(x:String) = x match {
    case EMail(user, domain) => println("user = " + user + " domain = " + domain)
    case _ => println("Illegal email")
  }

  val email = EMail("only3seconds", "163.com")
  patternMatching(email)
  patternMatching("Hello World")
}
```

运行结果：

```
user = only3seconds domain = 163.com
Illegal email
```

## 二. 提取器与序列模式

- 与一般的提取器不同的是，序列模式采用 unapplySeq 代替 unapply 方法，并且返回的类型是Option[Seq[T]] 

- 序列模式中的匹配经常会使用占位符 _ 或 _* 的方式匹配序列中的其它元素，这种方式为序列模式所独有