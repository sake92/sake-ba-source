package templates

import scalatags.Text.all._
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticPage
import ba.sake.hepek.bootstrap3.component.BootstrapGridComponents
import ba.sake.hepek.html.structure._
import ba.sake.hepek.Resources._
import site.Index

trait SakeBaPage extends BootstrapStaticPage with BootstrapGridComponents {

  override def siteSettings = SiteSettings(
    "sake.ba",
    Index,
    List.empty,
    Option(relTo(images.ico("favicon"))),
    Option(relTo(images.ico("favicon-white")))
  )

  override def pageLanguage: String = "bs"

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

  // Bootswatch cyborg theme
  override def bootstrapCSSDependencies = List(
    DependencyProvider.cdnjs.depPath(
      Dependency("cyborg/bootstrap.min.css", bootstrapVersion, "bootswatch")
    )
  )

  override def smRatios = None
  override def xsRatios = None

}
