package basic_concepts


/**
  * private 成员，仅在包含了成员定义的类或对象内部可见。
  * 内部类可以调用外部类private成员，反过来不行。
  */
class Outer {

  class Inner {
    private def f() {
      println("f")
    }

    class InnerMost {
      f(); //正确
    }

  }

  //(new Inner).f(); //错误
}
