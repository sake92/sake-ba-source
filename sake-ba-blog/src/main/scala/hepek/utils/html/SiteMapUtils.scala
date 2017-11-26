package hepek.utils.html

import scalatags.Text.all._

import hepek.templates.Page
import hepek.Site

object SiteMapUtils extends SiteMapUtils

trait SiteMapUtils extends HTMLUtils {

  /////////////////// Site map, regular HTML for users (sitemap is XML, dont be confused :p)
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
