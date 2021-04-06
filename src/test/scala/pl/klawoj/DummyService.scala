package pl.klawoj

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

trait DummyService {

  private[this] val r = scala.util.Random
  private[this] val deviceIdToLastSeqMap = new ConcurrentHashMap[Int, Int]

  private[this] val _itemsHandled = new AtomicInteger(0)

  def itemsHandled: Int = _itemsHandled.get()

  def handleMessage(task: DeviceTask): Unit = {
    ensureProperInvocationOrder(task)
    val waitTimeMillis = r.nextInt(60) + 30
    Thread.sleep(waitTimeMillis)
    _itemsHandled.incrementAndGet()
  }

  private def ensureProperInvocationOrder(task: DeviceTask) = {
    deviceIdToLastSeqMap.compute(task.deviceId, (_, lastSeqValue) => Option(lastSeqValue) match {
      case Some(seq) if seq > task.seq => throw new IllegalStateException(s"Order not preserved. For device ${task.deviceId} $seq handled before ${task.seq}  ")
      case _ => task.seq
    })
  }


}
