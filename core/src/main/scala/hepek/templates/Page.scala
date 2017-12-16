package hepek.templates

import scalatags.Text.all._

import ba.sake.hepek.core.RelativePath
import ba.sake.hepek.core.Renderable

import hepek.utils.path.ClassPackageRelativePath
import hepek.Resources._

trait Page
    extends ClassPackageRelativePath
    with SiteSettings
    with PageSettings
    with Navbar
    with Renderable {

  def pageBody: Frag

  /** Main (root) pages displayed in navbar. */
  def mainPages: Seq[PageSettings with RelativePath] = Seq()

  def additionalCSS: Seq[Modifier] = Seq()

  def additionalJS: Seq[Modifier] = Seq()

  /** Used for <meta description> bcoz google search */
  def pageDescription: Option[String] = None

  /**
    * @param other Resource to which path should be calculated
    * @return Relative path from this page to `other`
    */
  def relTo(other: RelativePath): String = {
    val relP = this.relPath.toPath.getParent.relativize(other.relPath.toPath)
    relP.toString.replaceAll("""\\""", "/") // change '\' to '/'
  }

  // jQuery
  private val jQueryJS = lib.jsMin("jquery/jquery")
  // Bootstrap
  private val BOOTSTRAP_THEME = "bootswatch-cyborg"
  private val bootstrapCSS = lib.cssMin(s"${BOOTSTRAP_THEME}/css/bootstrap")
  private val bootstrapJS = lib.jsMin(s"${BOOTSTRAP_THEME}/js/bootstrap")
  // AnchorJS
  private val anchorJS = lib.jsMin("anchorjs/anchor")
  // custom
  private val mainCSS = styles.css("main")
  private val mainJS = scripts.js("main")

  override def render: String = {
    "<!DOCTYPE html>" +
      html(
        lang := "bs",
        head(
          meta(charset := "utf-8"),
          meta(attr("http-equiv") := "X-UA-Compatible", content := "ie=edge"),
          meta(name := "viewport",
               content := "width=device-width, initial-scale=1"),
          raw("""
              <!-- Global Site Tag (gtag.js) - Google Analytics -->
              <script async src="https://www.googletagmanager.com/gtag/js?id=UA-93179008-1"></script>
              <script>
                window.dataLayer = window.dataLayer || [];
                function gtag(){dataLayer.push(arguments);}
                gtag('js', new Date());
                gtag('config', 'UA-93179008-1');
              </script>
          """),
          pageDescription.map(d => meta(name := "description", content := d)),
          link(rel := "shortcut icon",
               href := relTo(siteFaviconNormal),
               tpe := "image/x-icon"),
          tag("title")(pageTitle + " - " + siteName),
          // CSS
          link(rel := "stylesheet", href := relTo(bootstrapCSS)),
          additionalCSS,
          link(rel := "stylesheet", href := relTo(mainCSS)) // maybe override some of additionalCSS
        ),
        body(
          navbar,
          div(cls := "container-fluid")(
            pageBody
          ),
          // JS
          script(src := relTo(jQueryJS)),
          script(src := relTo(bootstrapJS)),
          script(src := relTo(anchorJS)),
          additionalJS,
          script(src := relTo(mainJS))
        )
      ).render
  }

}
