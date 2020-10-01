package utils

import scalatags.Text.all._
import ba.sake.hepek.core.RelativePath
import ba.sake.hepek.html.statik.BlogPostPage
import utils.Imports._

object SiteMapHTML {

  // Site map, HTML for users ("sitemap" is XML, dont be confused :p)
  def siteMap(implicit caller: RelativePath) = {
    val lis = Site.mainPages.map {
      case mp: BlogPostPage =>
        val childrenPages = mp.categoryPosts.map { p =>
          li(hyperlink(caller.relTo(p))(p.pageSettings.label))
        }
        frag(
          li(hyperlink(caller.relTo(mp))(mp.pageSettings.title)),
          ul(childrenPages)
        )
      case mp =>
        li(hyperlink(caller.relTo(mp))(mp.pageSettings.title))
    }
    ul(lis)
  }

}
