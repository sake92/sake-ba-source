package hepek

import scalatags.Text.all._

import hepek.templates.SakeBaPage
import hepek.templates.Section
import hepek.utils.HTMLUtils._

/* Ovaj objekat sadrži SEKCIJE na index.html stranici.
 * Radzdvojen je jer se koristi i u samom Page templejtu.
 * U protivnom postoji problem inicijalizacije.
 * */
object Sections {

  val address = tag("address")

  val whoSection = Section(
    "Ko?",
    address(
      div(strong("Sakib Hadžiavdić")),
      div(
        aHref("mailto:sakib@sake.ba")(
          span(cls := "glyphicon glyphicon-envelope"), " sakib@sake.ba"
        )
      ),
      div(
        raw("""<a href="https://twitter.com/sake_92" class="twitter-follow-button" data-show-count="false">@sake_92</a>""" +
          """<script async src="http://platform.twitter.com/widgets.js" charset="utf-8"></script>""")
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
      "Džaba.", br,
      "Fakat? Fakat."
    )
  )

  val sections: Seq[Section] = Seq(whatSection, priceSection, whoSection)
}

object Index extends SakeBaPage {

  override def pageTitle = "Početna stranica"

  override def pageContent = frag {
    Sections.sections map { section =>
      div(id := section.id, cls := "container-fluid sekcija")(
        h1(section.name),
        p(section.content)
      )
    }
  }

}
