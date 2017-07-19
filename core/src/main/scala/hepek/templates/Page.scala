package hepek.templates

import scalatags.Text.all._

import ba.sake.hepek.core.RelativePath
import ba.sake.hepek.core.Renderable

import hepek.css.CSSResource
import hepek.js.JSResource
import hepek.lib.WebJarResource
import hepek.utils.ClassRelativePath

trait Page extends ClassRelativePath
  with SiteSettings
  with PageSettings
  with Navbar
  with Renderable {

  def pageBody: Frag

  /** Main (root) pages displayed in navbar. */
  def mainPages: Seq[PageSettings with RelativePath] = Seq()

  def additionalCSS: Seq[Modifier] = Seq()

  def additionalJS: Seq[Modifier] = Seq()

  // a VERY handy util method for referring from one page to another
  def relTo(other: RelativePath): String = {
    this.relPath.toPath.getParent.relativize(other.relPath.toPath).toString.replaceAll("""\\""", "/")
  }

  // CONSTS
  private val BOOTSTRAP_THEME = "bootswatch-cyborg"
  // CSS core
  private val bootstrapCSS = WebJarResource.cssMin(s"${BOOTSTRAP_THEME}/css/bootstrap")
  private val mainCSS = CSSResource("main")
  // JS core
  private val jQueryJS = WebJarResource.jsMin("jquery/jquery")
  private val bootstrapJS = WebJarResource.jsMin(s"${BOOTSTRAP_THEME}/js/bootstrap")
  private val anchorJS = WebJarResource.jsMin("anchorjs/anchor")
  private val mainJS = JSResource("main")

  override def render: String = {
    "<!DOCTYPE html>" +
      html(
        lang := "bs",
        head(
          meta(charset := "utf-8"),
          meta(name := "viewport", content := "width=device-width, initial-scale=1"),
          link(rel := "shortcut icon", href := relTo(siteFaviconNormal), tpe := "image/x-icon"),
          tag("title")(pageTitle + " - " + siteName),
          // CSS
          link(rel := "stylesheet", href := relTo(bootstrapCSS)),
          link(rel := "stylesheet", href := relTo(mainCSS)),
          additionalCSS
        ),
        body(
          navbar,
          div(cls := "container-fluid")(
            pageBody
          ),
          script(src := relTo(jQueryJS)),
          script(src := relTo(bootstrapJS)),
          script(src := relTo(anchorJS)),
          script(src := relTo(mainJS)),
          additionalJS
        )
      ).render
  }

}
