package hepek

import ba.sake.hepek.bootstrap3.statik.BootstrapStaticPage
import hepek.templates.SakeBaBlogStaticPage
import hepek.utils.SiteMapHTML
import hepek.utils.Imports._

import scalatags.Text.all._

object Index extends SakeBaBlogStaticPage {

  override def pageTitle = "Početna stranica"

  override def pageDescription = Option(
    "blog.sake.ba je blog fizičke osobe pod imenom Sakib Hadžiavdić. " +
      "Tutorijali iz programiranja, matematike i slično."
  )

  override def pageContent = frag(
    div(cls := "page-header text-center")(
      h1("Dobrodošli!")
    ),
    row(
      div(cls := "well well-lg col-md-6 col-md-push-3")(
        p("Mapa sajta:"),
        div(cls := "pages-toc")(SiteMapHTML.siteMap(this))
      )
    )
  )

}
