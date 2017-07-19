package hepek

import scalatags.Text.all._

import hepek.templates.SakeBaBlogPage

object Index extends SakeBaBlogPage {

  override def pageTitle = "Početna stranica"

  override def pageContent = frag(
    div(cls := "jumbotron")(
      h1("Dobrodošli!"),
      p(
        "Nadam se da ćete se okoristiti ovim sadržajem. Uživajte!"
      )
    )
  )

}
