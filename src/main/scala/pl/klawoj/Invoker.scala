package pl.klawoj

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Keep, Sink, Source}

import scala.concurrent.Await
import scala.concurrent.duration.Duration

trait Invoker extends TaskQueue with ExpensiveService {

  implicit val system: ActorSystem = ActorSystem("Invoker")

  def delegateTasks(): Unit = {

    val executingTasks = Source(queue.toList)
      .groupBy(Integer.MAX_VALUE, _.deviceId)
      .map(handleMessage).async
      .mergeSubstreams
      .toMat(Sink.ignore)(Keep.right)
      .run

    Await.result(executingTasks,Duration.Inf)
  }
}
