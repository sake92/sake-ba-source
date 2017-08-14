package hepek.templates

import scalatags.Text.all._

import hepek.images.Image
import hepek.Site

trait SakeBaBlogPage extends Page {

  def pageContent: Frag

  /* SITE SETTINGS */
  override def siteName = "blog.sake.ba"
  override def siteIndexPage = hepek.Index
  override def siteFaviconNormal = Image.favicon
  override def siteFaviconInverted = Image.faviconWhite

  override def mainPages = Site.mainPages

  // maybe we'll override it someday
  override def pageBody = pageContent

}
