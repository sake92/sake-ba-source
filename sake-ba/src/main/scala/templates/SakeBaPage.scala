package templates

import ba.sake.hepek.html.statik.StaticPage
import ba.sake.hepek.Resources._
import site.Index

trait SakeBaPage extends StaticPage {

  override def staticSiteSettings =
    super.staticSiteSettings
      .withIndexPage(Index)

  override def siteSettings =
    super.siteSettings
      .withName("sake.ba")
      .withFaviconNormal(images.png("favicon").ref)

  override def styleURLs =
    super.styleURLs.appended("styles/main.css")

}
