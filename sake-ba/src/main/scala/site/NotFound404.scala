package site

import scalatags.Text.all._
import ba.sake.hepek.core.RelativePath
import templates.SakeBaPage

object NotFound extends SakeBaPage {

  override def pageTitle = "Ne postoji"

  override def fileName: String = "404.shtml"

  /* Since we use RELATIVE LINKS when referring to JS files, pages etc.
   * it doesn't work well when you land on a page like sake.ba/blah/sdfd/fdf/dsf/s
   */
  override def relTo(other: RelativePath) =
    "https://sake.ba/" + super.relTo(other)

  override def pageContent = frag(
    div(cls := "text-center")(
      p(raw("""Resource '<!--#echo var="REQUEST_URI" -->' does not exist!""")),
      p("(For now...) ^_^"),
      raw(
        """<br><br><br> <a href="https://<!--#echo var="HTTP_HOST" -->">Haj nazad</a> """
      )
    )
  )

}
