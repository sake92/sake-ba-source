package hepek.utils.html

import scalatags.Text.all._

import hepek.templates.Section

// for easier import
object SectionUtils extends SectionUtils

trait SectionUtils {

  private val section = tag("section")

  /**
    * @param secs Sections to render.
    * @param depth How deep should the TOC go.
    * @return HTML of TOC and then sections.
    */
  def renderTOCAndSections(secs: Seq[Section], depth: Int = 1): Frag =
    frag(
      div(cls := "panel-group")(
        div(cls := "panel panel-default")(
          div(cls := "panel-heading")(
            h4(cls := "panel-title")(
              a(data.toggle := "collapse", href := "#collapseSadrzaj")(
                "Sadržaj")
            )
          ),
          div(id := "collapseSadrzaj", cls := "panel-collapse collapse")(
            div(cls := "panel-body pages-tree")(renderTOC(secs, depth))
          )
        )
      ),
      div(renderSections(secs, depth))
    )

  /** Renders the sections. */
  private def renderSections(secs: Seq[Section], depth: Int): Seq[Frag] = {
    secs.flatMap { s =>
      val hTag = tag("h" + (depth + 1)) // depth = h2, h3...
      val thisSection = section(
        hTag(s.name),
        s.content
      )
      thisSection +: renderSections(s.children, depth + 1)
    }
  }

  /** Renders the TOC (Table of Contents). */
  private def renderTOC(secs: Seq[Section], depth: Int): Seq[Frag] = {
    val lis = secs.flatMap { s =>
      val aLink = a(href := s"#${s.id}")(s.name)
      li(aLink) +: renderTOC(s.children, depth + 1)
    }
    Seq(ul(lis))
  }

}
