package hepek.templates

import scalatags.Text.all.Frag

import hepek.Site
import hepek.images.Images

trait SakeBaBlogPage extends Page {

  def pageContent: Frag

  /* SITE SETTINGS */
  override def siteName = "blog.sake.ba"
  override def siteIndexPage = hepek.Index
  override def siteFaviconNormal = Images.favicon
  override def siteFaviconInverted = Images.faviconWhite

  override def mainPages = Site.mainPages

  // maybe we'll override it someday
  override def pageBody = pageContent

}
