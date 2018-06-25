
/**
  * protected 成员，只允许保护成员在定义了该成员的的类的子类中被访问，同一个包中也不能访问
 */
package basic_concepts

class Super {
    protected def f() {println("f")}

  }

  class Sub extends Super {
    f(); //正确
  }

  class Other {
    //(new Super).f(); //错误
  }


