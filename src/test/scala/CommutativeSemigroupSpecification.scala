import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Gen, Prop}
import org.scalacheck.Properties
import scala.concurrent.duration._
import CommutativeSemigroupOps._
  
object CommutativeSemigroupSpecification extends Properties("CommutativeSemigroup") {
  property("assoc") = forAll
  {
    (x: Duration, y: Duration, z: Duration) =>
        (x/3 ++ y/3) ++ z/3 == x/3 ++ (y/3 ++ z/3)
  }
  property("commut") = forAll
  {
    (x: Duration, y: Duration) =>
      x/2 ++ y/2 == y/2 ++ x/2
  }
}