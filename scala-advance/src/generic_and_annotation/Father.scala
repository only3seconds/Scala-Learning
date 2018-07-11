package generic_and_annotation

/**
  * 常用注解
  */
abstract class Father {
  // native 用于标记 cplusplusMethod 为 c/c++ 中实现的本地方法
  @native def cplusplusMethod()

}

// 标记 B 可被序列化，声明序列化版本
@SerialVersionUID(1000330L)
class Son extends Father with Serializable {
  // volatile 标记 name 非线程安全
  @volatile var name: String = "B"

  // transient 标记 age 不被序列化
  @transient var age: Int = 24

}
