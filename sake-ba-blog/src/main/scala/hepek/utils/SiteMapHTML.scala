package hepek.utils

import scalatags.Text.all._
import ba.sake.hepek.html.structure.StaticPage
import ba.sake.hepek.html.structure.blog.BlogPostPage
import hepek.utils.Imports._

object SiteMapHTML extends SiteMapHTML

trait SiteMapHTML {

  // Site map, HTML for users ("sitemap" is XML, dont be confused :p)
  def siteMap(renderingPage: StaticPage) = {
    val lis = Site.mainPages.map {
      case mp: BlogPostPage =>
        val childrenPages = mp.categoryPosts.map { p =>
          li(hyperlink(renderingPage.relTo(p))(p.pageLabel))
        }
        frag(
          li(hyperlink(renderingPage.relTo(mp))(mp.pageTitle)),
          ul(childrenPages)
        )
      case mp =>
        li(hyperlink(renderingPage.relTo(mp))(mp.pageTitle))
    }
    ul(lis)
  }

}
