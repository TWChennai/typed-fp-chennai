package com.thoughtworks.typedfp.week3

case class Email(
  subject: String,
  text: String,
  sender: String,
  recipient: String
)

object HOF extends App {

  type EmailFilter = Email => Boolean

  def newMailsForUser(mails: Seq[Email], f: EmailFilter): Seq[Email] = mails filter f

  val sentByOneOf: Set[String] => Email => Boolean = senders => email => senders.contains(email.sender)
  val notSentByAnyOf: Set[String] => EmailFilter = senders => email => !senders.contains(email.sender)

  val minimumSize: Int => EmailFilter = size => email => email.text.length >= size
  val maximumSize: Int => EmailFilter = size => email => email.text.length <= size

  type SizeChecker = Int => Boolean
  val sizeConstraint: SizeChecker => EmailFilter = f => email => f(email.text.length)

  val betterMinimumSize: Int => EmailFilter = minSize => sizeConstraint(_ >= minSize)
  val betterMaximumSize: Int => EmailFilter = maxSize => sizeConstraint(_ <= maxSize)

  def complement[T](predicate: T => Boolean) = !predicate(_)

  val betterNotSentByAnyOf: Set[String] => EmailFilter = strings => complement(sentByOneOf(strings))
  val betterBetterMaxSize: Int => EmailFilter = betterMinimumSize andThen complement

}
