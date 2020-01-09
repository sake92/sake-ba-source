package templates

import scalatags.Text.all._
import ba.sake.hepek.fontawesome5.FADependencies
import ba.sake.hepek.Resources._
import site.Index
import utils.Imports._

trait SakeBaPage extends StaticPage with FADependencies {

  override def staticSiteSettings =
    super.staticSiteSettings
      .withIndexPage(Index)

  override def siteSettings =
    super.siteSettings
      .withName("sake.ba")
      .withFaviconNormal(images.ico("favicon").ref)
      .withFaviconInverted(images.ico("favicon-white").ref)
      .withGoogleAnalyticsTrackingId("UA-93179008-1")

  override def styleURLs  = super.styleURLs :+ styles.css("main").ref
  override def scriptURLs = super.scriptURLs :+ scripts.js("main").ref

  override def bootstrapDependencies =
    super.bootstrapDependencies.withCssDependencies(
      Dependencies().withDeps(
        Dependency(
          "cyborg/bootstrap.min.css",
          bootstrapSettings.version,
          "bootswatch"
        )
      )
    )

}
