package hepek

import java.io.File
import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.core.RelativePath
import ba.sake.hepek.core.Renderable
import ba.sake.hepek.html.structure.blog.BlogPostPage
import hepek.utils.Site

object SitemapXML extends Renderable with RelativePath {

  override def relPath = new File("hepek/sitemap.xml")

  override def render = {
    val pages = Site.mainPages.flatMap(_.categoryPosts)
    val urls = for {
      p <- pages
    } yield postUrlTag(p)
    val allURLs = urlTag(Site.url + "/", LocalDate.now.toString, "monthly", 0.8) +: urls

    """<?xml version="1.0" encoding="utf-8"?>""" +
      tag("urlset")(
        attr("xmlns") := "http://www.sitemaps.org/schemas/sitemap/0.9",
        attr("xmlns:xsi") := "http://www.w3.org/2001/XMLSchema-instance",
        attr("xsi:schemaLocation") := "http://www.sitemaps.org/schemas/sitemap/0.9 http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd"
      )(
        allURLs
      )
  }

  private def postUrlTag(p: BlogPostPage) = {
    val loc = Site.url + "/" + Index.relTo(p)
    urlTag(loc, p.postCreateDate.toString, "yearly", 0.5)
  }

  private def urlTag(loc: String,
                     lastmod: String,
                     changefreq: String,
                     priority: Double) =
    tag("url")(
      tag("loc")(loc),
      tag("lastmod")(lastmod),
      tag("changefreq")(changefreq),
      tag("priority")(priority)
    )

}
