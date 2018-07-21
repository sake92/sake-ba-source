package site

import hepek.templates.SakeBaBlogStaticPage
import hepek.utils.SiteMapHTML
import hepek.utils.Imports._
import hepek.utils.Site
import scalatags.Text.all._

object Index extends SakeBaBlogStaticPage with SiteMapHTML {

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
      div(cls := "well well-lg col-md-6 col-md-push-3 ")(
        row(
          half1(
            p("Mapa sajta:"),
            div(cls := "pages-toc")(siteMap())
          ),
          half2(
            md(s"""
              PDF verzije tutorijala:
              - [Uvod u programiranje](${relTo(Site.programiranjePdf)}) (Java)
              - [Scala](${relTo(Site.scalaPdf)})
              - [Matematika](${relTo(Site.matematikaPdf)})
            """)
          )
        )
      )
    )
  )

}
