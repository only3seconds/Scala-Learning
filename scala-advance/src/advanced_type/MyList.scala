package advanced_type

/**
  * Type Specialization 类型专门化
  */
abstract class MyList[@specialized T] {
  //指定生成 Int 类型的版本
  def apply[@specialized (Int) S](x: S): S

  def map[@specialized (Boolean, Double) S](f: T => S)

}
