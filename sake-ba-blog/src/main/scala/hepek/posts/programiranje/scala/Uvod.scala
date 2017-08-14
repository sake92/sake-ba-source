package hepek.posts.programiranje.scala

import java.time.LocalDate

import scalatags.Text.all._

import hepek.templates.Section
import hepek.utils.HTMLUtils._

object Uvod extends ScalaTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Uvod u Scalu"
  override def pageLabel = "Uvod"
  override def pageDescription = Option(
    "Uvod u Scala programski jezik."
  )

  override def dateCreated = LocalDate.now()

  val uvodSectionContent = div(
    "Scala ima dvije vrste varijabli, var i val:",
    scalaSnippet("""
        |val unchangeable = 5
        |var changeable = "Whatever"
      """.stripMargin.trim)
  )

  val uvodSection = Section("Uvod", uvodSectionContent)

  override def sections = Seq(uvodSection)

}
