package pl.klawoj

import java.time.Duration

import org.scalatest.{GivenWhenThen, WordSpecLike}

class InvokerTest
  extends WordSpecLike
    with GivenWhenThen {

  "Invoker" must {
    "must handle all messages when order of invocations has to be preserved " in {
      val invoker = new DummyInvoker
      invoker.delegateTasks()
      assert(invoker.itemsHandled == invoker.itemsToHandle)
    }

    "handle all messages within the time limit" in {
      val invoker = new DummyInvoker
      mustBeDoneWithin(1) {
        invoker.delegateTasks()
      }
    }
  }


  def mustBeDoneWithin[R](seconds: Long)(block: => R): Unit = {
    val t0 = System.nanoTime()
    block
    val t1 = System.nanoTime()
    val elapsed = Duration.ofNanos(t1 - t0)
    println(s"Elapsed time: $elapsed")
    assert(elapsed.toMillis <= seconds * 1000)
  }

}
