package hepek.utils

import scalatags.Text.all._
import ba.sake.hepek.html.structure.StaticPage
import ba.sake.hepek.html.structure.blog.BlogPostPage
import ba.sake.hepek.html.component.BasicRenderableComponents

trait SiteMapHTML extends BasicRenderableComponents { self: StaticPage =>

  // Site map, HTML for users ("sitemap" is XML, dont be confused :p)
  def siteMap() = {
    val lis = Site.mainPages.map {
      case mp: BlogPostPage =>
        val childrenPages = mp.categoryPosts.map { p =>
          li(hyperlink((p))(p.pageLabel))
        }
        frag(
          li(hyperlink((mp))(mp.pageTitle)),
          ul(childrenPages)
        )
      case mp =>
        li(hyperlink((mp))(mp.pageTitle))
    }
    ul(lis)
  }

}
