package site

import scalatags.Text.all._
import ba.sake.hepek.core.RelativePath
import utils.Imports._

object NotFound extends templates.SakeBaPage {

  override def pageSettings = super.pageSettings.withTitle("Not found")

  override def fileName = "404.shtml"

  /* Since we use RELATIVE LINKS when referring to JS files, pages etc.
   * it doesn't work well when you land on a page like sake.ba/blah/sdfd/fdf/dsf/s
   */
  override def relTo(other: RelativePath) =
    "https://sake.ba/" + super.relTo(other)

  override def pageContent = frag(
    div(cls := "text-center")(
      """
          This content is not available in your country.  
          Sorry about that. :/

          ---
          Just kidding, there's nothing here! ^_^
        """.md,
      raw(
        """<a href="https://<!--#echo var="HTTP_HOST" -->">GOTO: homepage</a>"""
      )
    )
  )

}
