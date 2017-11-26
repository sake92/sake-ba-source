package hepek.posts.programiranje.scala

import java.time.LocalDate

import scalatags.Text.all._

import hepek.templates.Section

object Index extends ScalaTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Scala"
  override def pageLabel = "Početna"

  override def dateCreated = LocalDate.of(2017, 7, 2)

  val uvodSection = Section("Početna", "Scala == Java++ ???")

  override def sections = Seq(uvodSection)

}
