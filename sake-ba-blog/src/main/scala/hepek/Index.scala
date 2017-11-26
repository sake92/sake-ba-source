package hepek

import scalatags.Text.all._

import hepek.templates.SakeBaBlogPage
import hepek.utils.html.SiteMapUtils
import hepek.utils.html.HTMLUtils.rowDiv

object Index extends SakeBaBlogPage {

  override def pageTitle = "Početna stranica"

  override def pageDescription = Option(
    "blog.sake.ba je blog fizičke osobe pod imenom Sakib Hadžiavdić. " +
      "Tutorijali iz programiranja, matematike i slično."
  )

  override def pageContent = frag(
    div(cls := "page-header text-center")(
      h1("Dobrodošli!")
    ),
    rowDiv(
      div(cls := "well well-lg col-md-6 col-md-push-3")(
        p("Mapa sajta:"),
        div(cls := "pages-tree")(SiteMapUtils.siteMapHTML(this))
      )
    )
  )

}
