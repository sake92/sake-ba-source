package hepek

import scalatags.Text.all._

import hepek.templates.SakeBaBlogPage
import hepek.utils.SitemapUtils

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
    div(cls := "row")(
      div(cls := "well well-lg col-md-6 col-md-push-3")(
        p("Mapa sajta:"),
        div(cls := "pages-tree")(SitemapUtils.siteMapHTML(this))
      )
    )
  )

}
