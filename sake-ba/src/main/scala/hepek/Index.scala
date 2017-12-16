package hepek

import scalatags.Text.all._

import hepek.templates.SakeBaPage
import hepek.templates.Section
import hepek.utils.html.HTMLUtils._

/* This object contains SECTIONS of the index.html page.
 * Splitted here bcoz initialization problem
 * */
object Sections {

  val address = tag("address")

  val whoSection = Section(
    "Ko?",
    address(
      div(strong("Sakib Hadžiavdić")),
      div(
        aHref("mailto:sakib@sake.ba")(
          span(cls := "glyphicon glyphicon-envelope"),
          " sakib@sake.ba"
        )
      ),
      div(
        raw(
          """<a href="https://twitter.com/sake_92" class="twitter-follow-button" data-show-count="false">@sake_92</a>""" +
            """<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>"""
        )
      ),
      div(
        raw(
          """<a href="https://stackoverflow.com/users/4496364/insan-e">""" +
            """<img src="https://stackoverflow.com/users/flair/4496364.png?theme=dark" width="208" height="58" """ +
            """alt="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers" title="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers">""" +
            """</a>"""
        )
      )
    )
  )

  val whatSection = Section(
    "Šta?",
    div(
      aHref("https://blog.sake.ba")(
        span(cls := "glyphicon glyphicon-education"),
        " Tutorijali"
      )
    )
  )

  val priceSection = Section(
    "Cijena?",
    div(
      "Džaba.",
      br,
      "Fakat? Fakat."
    )
  )

  val sections: Seq[Section] = Seq(whatSection, priceSection, whoSection)
}

object Index extends SakeBaPage {

  override def pageTitle = "Početna stranica"

  override def pageDescription = Option(
    "sake.ba je web stranica fizičke osobe pod imenom Sakib Hadžiavdić. " +
      "Tutorijali iz programiranja, matematike i slično."
  )

  // @see https://www.w3schools.com/bootstrap/bootstrap_scrollspy.asp
  override def pageContent = frag {
    Sections.sections.map { section =>
      div(id := section.id, cls := "container-fluid sekcija")(
        h1(section.name),
        p(section.content)
      )
    }
  }

}
