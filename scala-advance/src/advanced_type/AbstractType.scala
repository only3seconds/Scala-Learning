package advanced_type

/**
  * 抽象类型
  */
abstract class Employee {
  //定义抽象类型
  type IdentityType

  def getIdentityNo(): IdentityType
}

/**
  * 在子类中对抽象类型进行具体化
  */
class MaleEmployee extends Employee {
  override type IdentityType = String

  override def getIdentityNo() = "NO.1110"
}

class FemaleEmployee extends Employee {
  override type IdentityType = Int

  override def getIdentityNo() = 1110
}
object AbstractType {
  def main(args: Array[String]): Unit = {

    println(new MaleEmployee().getIdentityNo())

    println(new FemaleEmployee().getIdentityNo())
  }

}
