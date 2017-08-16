package hepek

import scalatags.Text.all._
import java.io.File
import ba.sake.hepek.core.RelativePath
import ba.sake.hepek.core.Renderable
import hepek.templates.BlogPost
import java.time.LocalDate

object SitemapXML extends Renderable with RelativePath {

  override def relPath = new File("hepek/sitemap.xml")

  override def render = {
    val pages = Site.mainPages.flatMap(_.pages)
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

  private def postUrlTag(p: BlogPost) = {
    val loc = Site.url + "/" + Index.relTo(p)
    urlTag(loc, p.dateCreated.toString, "yearly", 0.5)
  }

  private def urlTag(loc: String, lastmod: String, changefreq: String, priority: Double) = {
    tag("url")(
      tag("loc")(loc),
      tag("lastmod")(lastmod),
      tag("changefreq")(changefreq),
      tag("priority")(priority)
    )
  }

}
