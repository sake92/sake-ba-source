package site

import scalatags.Text.all._
import ba.sake.hepek.implicits._
import ba.sake.hepek.core.RelativePath
import ba.sake.hepek.html.component.BasicComponents

object NotFound extends templates.SakeBaPage with BasicComponents {

  override def pageSettings = PageSettings("Ne postoji")

  override def fileName: String = "404.shtml"

  /* Since we use RELATIVE LINKS when referring to JS files, pages etc.
   * it doesn't work well when you land on a page like sake.ba/blah/sdfd/fdf/dsf/s
   */
  override def relTo(other: RelativePath) =
    "https://sake.ba/" + super.relTo(other)

  override def pageContent = frag(
    div(cls := "text-center")(
      md(
        """
          <br /><br /><br />
          This content is not available in your country.  
          Sorry about that. :/

          <br /><br />
          ---
          <br /><br />
          Just kidding, there's nothing here, this is the best I can do...  
        """
      ),
      raw(
        """<a href="https://<!--#echo var="HTTP_HOST" -->">GOTO: homepage</a>"""
      )
    )
  )

}
