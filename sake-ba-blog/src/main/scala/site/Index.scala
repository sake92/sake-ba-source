package site

import scalatags.Text.all._
import utils._

object Index extends templates.SakeBaBlogStaticPage with SiteMapHTML {

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
          div(siteMap)
        ),
        half(
          s"""
              PDF verzije tutorijala:
              - [Uvod u programiranje](${relTo(Site.programiranjePdf)}) (Java)
              - [Scala](${relTo(Site.scalaPdf)})
              - [Matematika](${relTo(Site.matematikaPdf)})
            """.md
        )
      )
    )
  )

}
