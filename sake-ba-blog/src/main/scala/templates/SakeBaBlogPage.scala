package templates

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.theme.bootstrap3.{HepekBootstrap3BlogPage, TocType}
import ba.sake.hepek.anchorjs.AnchorjsDependencies
import images.Images
import utils._
import Imports._

trait SakeBaBlogPage extends SakeBaBlogStaticPage with HepekBootstrap3BlogPage {

  override def blogSettings =
    super.blogSettings
      .withAuthor("Sakib Hadžiavdić")
      .withCreateDate(LocalDate.now)

  override def tocSettings =
    super.tocSettings
      .copy(title = "Sadržaj", tocType = Some(TocType.Scrollspy(55)))

  override def pageHeader = None

  // google analytics
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

  // DISQUS COMMENTS STUFF
  val PAGE_URL        = Site.url + "/" + site.Index.relTo(this)
  val PAGE_IDENTIFIER = PAGE_URL.##.abs // hopefully unique enough... :D

  // disqus comments
  override def scriptsInline =
    super.scriptsInline ++
      List(s"""
              var disqus_config = function () {
                this.page.url = '$PAGE_URL';
                this.page.identifier = $PAGE_IDENTIFIER;
              };

              (function() {
                var d = document, s = d.createElement('script');
                s.src = 'https://sake-ba.disqus.com/embed.js';
                s.setAttribute('data-timestamp', +new Date());
                (d.head || d.body).appendChild(s);
              })();
            """)

}

trait SakeBaBlogStaticPage
    extends StaticPage
    with Grid
    with AnchorjsDependencies {

  override def staticSiteSettings =
    super.staticSiteSettings
      .withIndexPage(site.Index)
      .withMainPages(Site.mainPages)

  override def siteSettings =
    super.siteSettings
      .withName(Site.name)
      .withFaviconNormal(Images.favicon.ref)
      .withFaviconInverted(Images.faviconWhite.ref)

  override def styleURLs =
    super.styleURLs ++ List(
      resources.styles.css("main").ref,
      resources.styles.css("print").ref
    )
  override def scriptURLs = super.scriptURLs :+ resources.scripts.js("main").ref

  override def stylesInline =
    super.stylesInline ++ List("""
        body { padding-top: 73px; }
      """)

  // Bootswatch cyborg theme
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

  override def renderPretty = true
  override def renderXhtml  = true

}
