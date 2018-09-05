package templates

import scalatags.Text.all._
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticPage
import ba.sake.hepek.bootstrap3.component.BootstrapGridComponents
import ba.sake.hepek.html.structure._
import ba.sake.hepek.Resources._
import site.Index

trait SakeBaPage extends BootstrapStaticPage with BootstrapGridComponents {

  override def siteSettings =
    SiteSettings()
      .withName("sake.ba")
      .withIndexPage(Index)
      .withFaviconNormal(images.ico("favicon").ref)
      .withFaviconInverted(images.ico("favicon-white").ref)

  override def headContent = super.headContent ++ List(
    raw("""
          <!-- Global Site Tag (gtag.js) - Google Analytics -->
          <script async src="https://www.googletagmanager.com/gtag/js?id=UA-93179008-1"></script>
          <script>
            window.dataLayer = window.dataLayer || [];
            function gtag(){dataLayer.push(arguments);}
            gtag('js', new Date());
            gtag('config', 'UA-93179008-1');
          </script>
        """)
  )

  override def styleURLs  = super.styleURLs :+ relTo(styles.css("main"))
  override def scriptURLs = super.scriptURLs :+ relTo(scripts.js("main"))

  override def bootstrapDependencies =
    super.bootstrapDependencies.withCssDependencies(
      Dependencies().withDeps(
        Dependency("cyborg/bootstrap.min.css",
                   bootstrapSettings.version,
                   "bootswatch")
      )
    )

  override def screenRatios =
    super.screenRatios
      .withSm(None)
      .withXs(None)

}
