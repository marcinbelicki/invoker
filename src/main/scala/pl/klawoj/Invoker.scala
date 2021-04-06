package pl.klawoj

trait Invoker extends TaskQueue with ExpensiveService {

  def delegateTasks(): Unit = {
    //TODO make this more efficient
    while (queue.nonEmpty) {
      handleMessage(queue.dequeue())
    }
  }
}
