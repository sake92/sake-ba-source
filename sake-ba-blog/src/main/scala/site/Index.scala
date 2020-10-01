package site

import scalatags.Text.all._
import utils._
import utils.Imports._, grid._, Image._

object Index extends templates.SakeBaBlogStaticPage {

  override def pageSettings =
    super.pageSettings
      .withTitle("Početna stranica")
      .withDescription(
        "blog.sake.ba je blog fizičke osobe pod imenom Sakib Hadžiavdić. " +
          "Tutorijali iz programiranja, matematike i slično."
      )

  override def stylesInline =
    super.stylesInline ++ List("""
        body { padding-top: 55px; }
      """)

  override def pageContent = frag(
    div(cls := "page-header text-center")(
      h1("Dobrodošli!")
    ),
    div(cls := "well well-lg col-md-6 col-md-push-3 pages-toc")(
      row(
        half(
          "Mapa sajta:",
          div(SiteMapHTML.siteMap)
        ),
        half(
          s"""
            PDF verzije tutorijala:
            - [Uvod u programiranje](${Site.programiranjePdf.ref}) (Java)
            - [Scala](${Site.scalaPdf.ref})
            - [Matematika](${Site.matematikaPdf.ref})
          """.md
        )
      )
    )
  )

}
