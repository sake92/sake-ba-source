package site

import scalatags.Text.all._
import ba.sake.hepek.implicits._
import utils._

object Index extends templates.SakeBaBlogStaticPage with SiteMapHTML {

  override def pageSettings =
    PageSettings("Početna stranica")
      .withDescription(
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
            div(cls := "pages-toc")(siteMap)
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
