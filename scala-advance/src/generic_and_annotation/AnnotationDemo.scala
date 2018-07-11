package generic_and_annotation

import scala.beans.BeanProperty

/**
  * Annotation 注解
  */

class A

class B extends A {
  // deprecated 注解表示 getName() 方法在未来会被丢弃，不建议使用
  @deprecated def getName() = "Class B"
}

class C extends A {
  // @BeanProperty，要求程序生成相应getter,setter方法，与java命名规范一致
  @BeanProperty var cNo = "Hello, scala!"
}

object AnnotationDemo {

  def main(args: Array[String]): Unit = {
    val b = new B()
    println(b.getName())

    val c = new C()
    println(c.cNo)
  }

}
