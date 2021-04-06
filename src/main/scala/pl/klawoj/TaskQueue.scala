package pl.klawoj

import scala.collection.mutable

trait TaskQueue {
  val queue: mutable.Queue[DeviceTask]
}
