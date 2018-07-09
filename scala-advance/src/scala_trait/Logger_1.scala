package scala_trait

import java.io.IOException

trait Logger_1 {
  def log(msg: String): Unit
}

trait ExceptionLogger extends Exception with Logger {

  // 可以不写 override
  def log(msg: String): Unit = {
    println(getMessage)
  }
}

// 注意是 extends，ExceptionLogger 的父类 Exception 自动成为 UnprintedException 的父类
class UnprintedException extends ExceptionLogger {
  // 必须写 override
  override def log(msg: String): Unit = {
    println(" ")
  }
}

// IOException 和 ExceptionLogger 都有父类 Exception, scala 会让 UnprintedException1 只有一个父类 Exception
class UnprintedException1 extends IOException with ExceptionLogger {
  // 必须写 override
  override def log(msg: String): Unit = {
    println(" ")
  }
}
