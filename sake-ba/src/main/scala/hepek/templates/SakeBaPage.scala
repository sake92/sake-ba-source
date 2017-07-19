package hepek.templates

import scalatags.Text.all._

import ba.sake.hepek.core.RelativePath

import hepek.Index
import hepek.images.Image
import hepek.utils.HTMLUtils.aHref

trait SakeBaPage extends Page {

  def pageContent: Frag

  /* SITE SETTINGS */
  override def siteName = "sake.ba"
  override def siteIndexPage = Index
  override def siteFaviconNormal = Image.favicon
  override def siteFaviconInverted = Image.faviconWhite

  // this is an ugly hack indeed
  override def mainPages = hepek.Sections.sections.map { s =>
    new PageSettings with RelativePath {
      override def pageTitle = s.name
      override def relPath = new java.io.File(Index.relPath() + s"#${s.id}")
    }
  }

  override def pageBody = frag(
    div(pageContent),
    footer(cls := "text-center")(
      p("Hvala na Bootstrap 'Cyborg' temi: ")(
        aHref("http://thomaspark.co/")("Thomas Park")
      )
    )
  )

}
