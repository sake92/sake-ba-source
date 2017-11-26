package hepek

import scalatags.Text.all._

import ba.sake.hepek.core.RelativePath

import hepek.templates.SakeBaPage

object NotFound extends SakeBaPage {

  override def pageTitle = "Ne postoji"

  override def fileName: String = "404.shtml"

  /* Since we use RELATIVE LINKS when referring to JS files, pages etc.
   * it doesn't work well when you land on a page e.g. sake.ba/blah/sdfd/fdf/dsf/s
   */
  override def relTo(other: RelativePath) =
    "https://sake.ba/" + super.relTo(other)

  override def pageContent = div(cls := "text-center")(
    p(raw("""Resurs '<!--#echo var="REQUEST_URI" -->' ne postoji!""")),
    p("(Bar zasad...) ^_^"), br, br, br,
    raw(""" <a href="https://<!--#echo var="HTTP_HOST" -->">Haj nazad</a> """)
  )

}
