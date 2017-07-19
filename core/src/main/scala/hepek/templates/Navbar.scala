package hepek.templates

import scalatags.Text.all._

trait Navbar { self: Page =>

  /* Misc tags, not defined in scalatags */
  private val nav = tag("nav")
  private val btn = tag("btn")(tpe := "button", cls := "btn ")

  private val categoryLiTags = for {
    page <- mainPages
    klasa = if (page.pageCategory == this.pageCategory) "active" else ""
    labela = page.pageCategory.getOrElse(page.pageLabel)
  } yield li(cls := klasa)(
    a(href := relTo(page))(labela)
  )

  def navbar =
    nav(cls := "navbar navbar-default navbar-fixed-top")(
      div(cls := "container")(
        // Brand and toggle get grouped for better mobile display
        div(cls := "navbar-header")(
          btn(
            cls := "navbar-toggle collapsed",
            data.toggle := "collapse", data.target := "#main-navbar"
          )(
              span(cls := "sr-only")("Toggle navigation"),
              span(cls := "icon-bar"),
              span(cls := "icon-bar"),
              span(cls := "icon-bar")
            ),
          a(cls := "navbar-brand", href := relTo(siteIndexPage))(
            span(
              img(src := relTo(siteFaviconInverted))
            ),
            " " + siteName
          )
        ),
        // Collect the nav links, forms, and other content for toggling
        div(cls := "collapse navbar-collapse", id := "main-navbar")(
          ul(cls := "nav navbar-nav navbar-right")(
            categoryLiTags
          )
        )
      )
    )
}
