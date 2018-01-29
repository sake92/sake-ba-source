package hepek.utils

import scalatags.Text.all._
import ba.sake.hepek.html.structure.Page
import hepek.utils.Imports._

object SiteMapHTML extends SiteMapHTML

trait SiteMapHTML {

  // Site map, HTML for users ("sitemap" is XML, dont be confused :p)
  def siteMap(renderingPage: Page) = {
    val lis = Site.mainPages.map { mp =>
      frag(
        li(
          hyperlink(renderingPage.relTo(mp), true)(mp.pageTitle)
        ),
        ul { // child pages
          mp.categoryPosts.map { p =>
            li(
              hyperlink(renderingPage.relTo(p))(p.pageLabel)
            )
          }
        }
      )
    }
    ul(lis)
  }

}
