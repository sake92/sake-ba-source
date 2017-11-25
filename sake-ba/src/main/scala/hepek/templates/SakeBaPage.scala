package hepek.templates

import scalatags.Text.all._

import ba.sake.hepek.core.RelativePath

import hepek.Index
import hepek.Resources.images

trait SakeBaPage extends Page {

  def pageContent: Frag

  /* SITE SETTINGS */
  override def siteName = "sake.ba"
  override def siteIndexPage = Index
  override def siteFaviconNormal = images.ico("favicon")
  override def siteFaviconInverted = images.ico("favicon-white")

  // this is an ugly hack indeed
  override def mainPages = hepek.Sections.sections.map { s =>
    new PageSettings with RelativePath {
      override def pageTitle = s.name
      override def relPath = new java.io.File(Index.relPath() + s"#${s.id}")
    }
  }

  override def pageBody = frag(
    div(pageContent)
  )

}
