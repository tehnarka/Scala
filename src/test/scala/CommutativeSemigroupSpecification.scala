import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Gen, Prop}
import org.scalacheck.Properties
import CommutativeSemigroupOps._
  
object CommutativeSemigroupSpecification extends Properties("CommutativeSemigroup") {
  property("assoc") = forAll
  {
    (x: Duration, y: Duration, z: Duration) =>
        (x ++ y) ++ z == x ++ (y ++ z)
  }
  property("commut") = forAll
  {
    (x: Duration, y: Duration) =>
      x ++ y == y ++ x
  }
}