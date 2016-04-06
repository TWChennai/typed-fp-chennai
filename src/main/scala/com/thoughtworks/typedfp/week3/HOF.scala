package com.thoughtworks.typedfp.week3

case class Email(
  subject: String,
  text: String,
  sender: String,
  recipient: String
)

object HOF extends App {

  type EmailFilter = Email => Boolean

  def newMailsForUser(mails: Seq[Email], f: EmailFilter) = ???

  val sentByOneOf: Set[String] => EmailFilter = senders => email => ???
  val notSentByAnyOf: Set[String] => EmailFilter = senders => email => ???

  val minimumSize: Int => EmailFilter = ???
  val maximumSize: Int => EmailFilter = ???

  type SizeChecker = Int => Boolean
  val sizeConstraint: SizeChecker => EmailFilter = ???

  val betterMinimumSize: Int => EmailFilter = ???
  val betterMaximumSize: Int => EmailFilter = ???

  def complement[A](predicate: A => Boolean) = ???

  val betterNotSentByAnyOf = ???
  val betterBetterMaxSize = ???

}
