package templates

import ba.sake.hepek.html.statik.StaticPage

trait SakeBaPage extends StaticPage {

  override def staticSiteSettings =
    super.staticSiteSettings
      .withIndexPage(files.Index)

  override def siteSettings =
    super.siteSettings
      .withName("sake.ba")
      .withFaviconNormal(files.images.`favicon.png`.ref)

  override def styleURLs =
    super.styleURLs.appended(files.styles.`pico.classless.min.css`.ref)

}
