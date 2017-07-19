package hepek.templates

import scalatags.Text.all._

import hepek.images.Image

trait SakeBaBlogPage extends Page {

  def pageContent: Frag

  /* SITE SETTINGS */
  override def siteName = "blog.sake.ba"
  override def siteIndexPage = hepek.Index
  override def siteFaviconNormal = Image.favicon
  override def siteFaviconInverted = Image.faviconWhite

  override def mainPages = Seq(
    hepek.posts.matematika.Index,
    hepek.posts.programiranje.Index,
    hepek.posts.programiranje.scala.Index
  )

  // maybe we'll override it someday
  override def pageBody = pageContent

}
