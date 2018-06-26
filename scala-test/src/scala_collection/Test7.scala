package scala_collection

import scala.collection.mutable.Set;

/**
  * Scala Set(集合)是没有重复的对象集合，所有的元素都是唯一的。
  *
  * 可变Set和不可变Set都有添加或删除元素的操作,但是对不可变Set进行操作，会产生一个新的set,与List一样
  * 对可变Set进行操作，改变的是该Set本身，与ListBuffer类似。
  */
object Test7 {
  def main(args: Array[String]): Unit = {

    val mutableSet = Set(1, 2, 3);
    println(mutableSet.getClass.getName);

    mutableSet.add(4);
    mutableSet.remove(1);
    mutableSet += 5;
    mutableSet -= 2;

    println(mutableSet);

    val another = mutableSet.toSet;
    println(another.getClass.getName);

  }

}
