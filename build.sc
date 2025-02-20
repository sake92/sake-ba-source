import $ivy.`ba.sake::mill-hepek::0.1.0`
import mill._
import mill.scalalib._
import ba.sake.millhepek.MillHepekModule

object site extends MillHepekModule with ScalaModule {
  def scalaVersion = "3.6.3"
  def ivyDeps = Agg(
    ivy"ba.sake::hepek:0.29.0"
  )
}
