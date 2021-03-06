import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Gen, Prop}
import org.scalacheck.Properties
import CommutativeSemigroupOps._
import scala.concurrent.duration._
  
object CommutativeSemigroupSpecification extends Properties("CommutativeSemigroup") {
  property("assoc") = forAll
  {
    (x: Duration, y: Duration, z: Duration) =>
        (x/3 ++ y/3) ++ z/3 == x/3 ++ (y/3 ++ z/3)
  }
  property("commut") = forAll
  {
    (x: Duration, y: Duration) =>
      x/3 ++ y/3 == y/3 ++ x/3
  }
}