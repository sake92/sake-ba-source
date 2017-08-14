package hepek.utils

import scalatags.Text.all._

import hepek.templates.Section

object HTMLUtils {

  ///////////// custom tags
  private val section = tag("section")

  def rowDiv(cont: Frag*): Frag =
    div(cls := "row")(cont)

  def leftDiv(cont: Frag*): Frag =
    div(cls := "col-md-7")(cont)

  def rightDiv(cont: Frag*): Frag =
    div(cls := "col-md-5")(cont)

  /** Method for defining an anchor link: <a href="hreff"> cont </a>*/
  def aHref(hreff: String, openInNewWindow: Boolean = false)(cont: Frag*) = {
    val optParams = if (openInNewWindow) Seq(target := "_blank") else Seq()
    a(href := hreff, optParams)(cont)
  }

  ///////////////// PAGE SECTIONS, Table Of Contents, sadržaj :D
  /** This method renders the sections properly. */
  private def renderSections(secs: Seq[Section], depth: Int = 1): Seq[Frag] = {
    secs.flatMap { s =>
      val hTag = tag("h" + (depth + 1)) // depth = h2, h3...
      val thisSection = section(
        hTag(s.name), s.content
      )
      thisSection +: renderSections(s.children, depth + 1)
    }
  }

  /** This method renders the TableOfContents properly. */
  private def renderTOC(secs: Seq[Section], depth: Int = 1): Seq[Frag] = {
    val res = secs.flatMap { s =>
      val aLink = a(href := s"#${s.id}")(s.name)
      li(aLink) +: renderTOC(s.children, depth + 1)
    }
    Seq(ul(res))
  }

  def renderTOCAndSections(secs: Seq[Section], depth: Int = 1): Frag =
    frag(
      div(cls := "panel-group")(
        div(cls := "panel panel-default")(
          div(cls := "panel-heading")(
            h4(cls := "panel-title")(
              a(data.toggle := "collapse", href := "#collapseSadrzaj")("Sadržaj")
            )
          ),
          div(id := "collapseSadrzaj", cls := "panel-collapse collapse")(
            div(cls := "panel-body pages-tree")(renderTOC(secs, depth))
          )
        )
      ),
      div(renderSections(secs, depth))
    )

  ///////////////////////// IMAGE RENDERING
  /** Renders a pretty bootstrapy image with optional caption text */
  def image(source: String, captionn: String = "") =
    div(cls := "thumbnail")(
      img(src := source, cls := "img-responsive", alt := captionn),
      {
        if (captionn.trim.isEmpty) frag() // empty if no description...
        else div(cls := "caption text-center")(p(captionn))
      }
    )

  /** Renders a pretty bootstrapy SVG image with optional caption text */
  def svg(source: String, captionn: String = "") =
    div(cls := "thumbnail")(
      tag("object")(tpe := "image/svg+xml", cls := "embed-responsive-item", data := source)("Ne radi ti SVG..."),
      {
        if (captionn.trim.isEmpty) frag() // empty if no description...
        else div(cls := "caption text-center")(p(captionn))
      }
    )

  ///////////////////// CODE RENDERING
  def scalaSnippet(body: String) = codeSnippet("scala")(body)
  def javaSnippet(body: String) = codeSnippet("java")(body)
  def shellSnippet(body: String) = codeSnippet("powershell")(body)

  /** Snippet of coded highlighted with PrismJS: http://prismjs.com/#basic-usage */
  private def codeSnippet(language: String)(body: String) = {
    val bodyTrimmed = trimShortestSpace(body)
    pre(code(cls := s"language-$language")(bodyTrimmed))
  }

  /** Trims leading whitespace while retaining indentation. */
  private def trimShortestSpace(str: String): String = {
    var minWsLength = Int.MaxValue
    str.lines.foreach { line =>
      val currLength = line.takeWhile(c => c == ' ' || c == '\t').length
      if (currLength < minWsLength && !line.matches("^\\s*$")) { // and IF NOT EMPTY! (blank, wspace..)
        minWsLength = currLength
      }
    }
    str.lines.map { line =>
      val res = line.zipWithIndex.dropWhile { case (_, index) => index < minWsLength }.map(_._1)
      res.mkString
    }.mkString("\n")
  }

}
