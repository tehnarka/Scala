import scala.language.implicitConversions
import scala.concurrent.duration._


trait CommutativeSemigroup[A] {
  def addition(x: A, y: A): A
}

object CommutativeSemigroup{
  implicit val durationCommSemigroup = new CommutativeSemigroup[Duration] 
  {
    override def addition(x: Duration, y: Duration):
    Duration = x.plus(y)
  }
}

class CommutativeSemigroupOps[A: CommutativeSemigroup](x: A)(implicit foo: CommutativeSemigroup[A])
{
  def ++(y: A): A = foo.addition(x, y)
}

object CommutativeSemigroupOps{
    implicit def fun[A](x: A)(implicit foo: CommutativeSemigroup[A]): CommutativeSemigroupOps[A] = 
    {
      new CommutativeSemigroupOps[A](x)
    }
}