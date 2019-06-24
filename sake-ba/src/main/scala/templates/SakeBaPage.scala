package templates

import scalatags.Text.all._
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticBundle
import ba.sake.hepek.html.component.BasicComponents
import ba.sake.hepek.Resources._
import site.Index
import utils.Imports._

trait SakeBaPage extends StaticPage with BasicComponents with Grid {

  override def staticSiteSettings =
    super.staticSiteSettings
      .withIndexPage(Index)

  override def siteSettings =
    super.siteSettings
      .withName("sake.ba")
      .withFaviconNormal(images.ico("favicon").ref)
      .withFaviconInverted(images.ico("favicon-white").ref)

  override def headContent =
    frag(
      super.headContent,
      raw(
        """
          <!-- Global Site Tag (gtag.js) - Google Analytics -->
          <script async src="https://www.googletagmanager.com/gtag/js?id=UA-93179008-1"></script>
          <script>
            window.dataLayer = window.dataLayer || [];
            function gtag(){dataLayer.push(arguments);}
            gtag('js', new Date());
            gtag('config', 'UA-93179008-1');
          </script>
        """
      )
    )

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

  override def screenRatios =
    super.screenRatios
      .withSm(None)
      .withXs(None)

}
