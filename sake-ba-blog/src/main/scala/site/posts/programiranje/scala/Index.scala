package site.posts.programiranje.scala

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object Index extends ScalaTemplate {

  override def pageTitle = "Scala"
  override def pageLabel = "Početna"

  override def postCreateDate = LocalDate.of(2017, 7, 2)
  override def postSections = List(uvodSection)

  def uvodSection = Section("Početna", "Scala == Java++ ???")
}
