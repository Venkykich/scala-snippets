package testrx
import akka.actor._

import rx.lang.scala._ // the additional import for RxJava

object testrx2 extends App {
  trait Message
  case class Hello(text: String) extends Message
  sealed trait SubUnsub extends Message
  case class Subscribe(onNext: Message => Unit) extends SubUnsub
  case object Unsubscribe extends SubUnsub

  class ObservableActor2 extends Actor with ActorLogging {
    def receive = {
      case Subscribe(onNext) =>
        log debug "subscribe"
        context become subscribed(onNext)
    }

    def subscribed(onNext: Message => Unit): Actor.Receive = {
      case Unsubscribe =>
        log debug "unsubscribe"
        context become receive

      case message: Message =>
        log debug s"incoming: $message"
        onNext(message)
    }
  }

}