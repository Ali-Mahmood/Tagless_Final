package interpreter

import dsl.Dsl
import models.User

import scala.collection.mutable.ListBuffer

object DSLInterpreter {

  implicit object DslInterpreter extends Dsl[Seq] {
    var data = new ListBuffer[User]()

    override def getUser(name: String): Seq[Either[String, User]] = {
      data.find(d => d.name == name) match {
        case Some(customer) => Seq(Right(customer))
        case None => Seq(Left(s"Couldn't find the user with the name: $name"))
      }
    }

    override def putUser(user: User): Seq[Either[String, User]] = {
      data += user
      Seq(Right(user))
    }
  }

}
