package generic_and_annotation

import java.io._

/**
  * 序列化：继承 Serializable
  */

class Animal extends Serializable {
  @transient var name: String = "cat" // name 不会被序列化
  var age: Int = 2

  override def toString: String = "name = " + name + " age = " + age
}

object Serialize {
  def main(args: Array[String]): Unit = {
    val file = new File("animal.out")
    val oout = new ObjectOutputStream(new FileOutputStream(file))

    val animal = new Animal
    oout.writeObject(animal)
    oout.close()

    val oin = new ObjectInputStream(new FileInputStream(file))
    val newAnimal = oin.readObject()
    oin.close()

    println(newAnimal)

  }

}
