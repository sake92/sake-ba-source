package hepek.posts.programiranje.scala

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.images.Images
import hepek.utils.Imports._

object Uvod extends ScalaTemplate {

  /* PAGE SETTINGS */
  override def pageTitle       = "Uvod u Scalu"
  override def pageLabel       = "Uvod"
  override def pageDescription = Option("Uvod u Scala programski jezik.")

  override def postSections = List(uvodSection)

  def uvodSection = Section("Uvod", uvodSectionContent)

  def uvodSectionContent = div(
    "Scala ima dvije vrste varijabli, ",
    chl.scala.inline("val"),
    " i val:",
    chl.scala("""
        val unchangeable = 5
        var changeable = "Whatever"
      """)
  )

}
