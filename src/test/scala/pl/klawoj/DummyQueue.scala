package pl.klawoj

import scala.collection.mutable

trait DummyQueue {

  import DummyQueue._

  def itemsToHandle: Int = queueSource.size

  val queue: mutable.Queue[DeviceTask] = queueSource.to[mutable.Queue]
}
object DummyQueue {
  private val nrOfDevices = 7
  private val nrOfMessages = 100
  private val queueSource = Range(0, nrOfMessages).map(idx => DeviceTask(idx % nrOfDevices, idx / nrOfDevices, new Object))
}
