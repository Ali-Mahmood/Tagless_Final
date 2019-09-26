import dsl.Dsl
import models.User
import Utility._

object Main extends App {

  import interpreter.DSLInterpreter._

  def putAndGet[F[_]: Dsl](name: String): Either[Unit, User] = {
    putUser(User(name, 100))

    val user = getUser[Seq](name)

    user.head match {
      case Right(value) =>
        println(s"Got customer with name: ${value.name}")
        Right(value)
      case Left(error) =>
        println(s"Error: $error")
        Left(error)
    }
  }

  putAndGet[Seq]("Ali")
}