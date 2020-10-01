package templates

import scalatags.Text.all._
import ba.sake.hepek.html.statik.StaticPage
import ba.sake.hepek.Resources._
import site.Index
import utils.Imports._

trait SakeBaPage extends StaticPage {

  override def staticSiteSettings =
    super.staticSiteSettings
      .withIndexPage(Index)

  override def siteSettings =
    super.siteSettings
      .withName("sake.ba")
      .withFaviconNormal(images.ico("favicon").ref)
      .withFaviconInverted(images.ico("favicon-white").ref)
      .withGoogleAnalyticsTrackingId("UA-93179008-1")

  override def styleURLs =
    super.styleURLs.appended(
      "https://cdn.rawgit.com/Chalarangelo/mini.css/v3.0.1/dist/mini-default.min.css"
    )

  override def bodyContent =
    div(cls := "container")(
      div(cls := "row")(
        div(cls := "col-md-2"),
        div(cls := "col-md-8")(pageContent),
        div(cls := "col-md-2")
      )
    )
}
