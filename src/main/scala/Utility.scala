import dsl.Dsl
import models.User


object Utility {
  def getUser[F[_] : Dsl](name: String): F[Either[String, User]] = Dsl[F].getUser(name)

  def putUser[F[_] : Dsl](user: User): F[Either[String, User]] = Dsl[F].putUser(user)
}
