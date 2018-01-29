package ba.sake.hepek.html.structure

import scalatags.Text.all._
import ba.sake.hepek.core.Renderable
import ba.sake.hepek.path.ClassPackageRelativePath
import ba.sake.hepek.path.utils.RelativePathUtils

// TODO extract Page, separate to StaticPage
// so later we can use it for Play etc
trait Page
    extends Renderable
    with ClassPackageRelativePath
    with RelativePathUtils {

  def siteSettings: SiteSettings

  def pageTitle: String
  def pageLabel: String               = pageTitle
  def pageLanguage: String            = "en"
  def pageCategory: Option[String]    = None
  def pageDescription: Option[String] = None

  // <head>
  def headContent: List[Frag] =
    List(
      meta(charset := "utf-8"),
      meta(
        attr("http-equiv") := "X-UA-Compatible",
        content := "ie=edge"
      ),
      meta(
        name := "viewport",
        content := "width=device-width, initial-scale=1"
      ),
      pageDescription.map { d =>
        meta(name := "description", content := d)
      },
      tag("title")(
        pageTitle + " - " + siteSettings.name
      ),
      siteSettings.faviconNormal.map { fav =>
        link(rel := "shortcut icon", href := fav, tpe := "image/x-icon")
      }
    )
  def styleURLs: List[String]    = List.empty
  def stylesInline: List[String] = List.empty

  // <body>
  def bodyContent: List[Frag]     = List.empty
  def scriptURLs: List[String]    = List.empty
  def scriptsInline: List[String] = List.empty

  def cdnJSURL: String = "https://cdnjs.cloudflare.com/ajax/libs"

  override def render: String =
    "<!DOCTYPE html>" +
      html(lang := pageLanguage)(
        head(
          headContent ++
            styleURLs.map(u => link(rel := "stylesheet", href := u)) ++
            stylesInline.map(s => tag("style")(s))
        ),
        body(
          bodyContent ++
            scriptURLs.map(u => script(src := u)) ++
            scriptsInline.map(s => script(s))
        )
      )

}

case class SiteSettings(
    name: String,
    indexPage: Page,
    mainPages: List[Page] = List.empty,
    faviconNormal: Option[String] = None,
    faviconInverted: Option[String] = None
)
