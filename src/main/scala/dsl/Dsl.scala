package dsl

import models.User

trait Dsl[F[_]] {
  def getUser(name: String): F[Either[String, User]]

  def putUser(user: User): F[Either[String, User]]
}

object Dsl {
  def apply[F[_]](implicit dsl: Dsl[F]): Dsl[F] = dsl
}
