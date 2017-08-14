package hepek.utils

import scalatags.Text.all._
import hepek.Site
import hepek.utils.HTMLUtils._
import hepek.Index
import hepek.templates.Page

object SitemapUtils {

  /////////////////// Site map, regular HTML for users
  def siteMapHTML(renderingPage: Page) = {
    val lis = Site.mainPages.map { mp =>
      frag(
        li(
          aHref(renderingPage.relTo(mp))(mp.pageTitle)
        ),
        ul { // child pages
          mp.pages.map { p =>
            li(
              aHref(renderingPage.relTo(p))(p.pageLabel)
            )
          }
        }
      )
    }
    ul(lis)
  }

}
