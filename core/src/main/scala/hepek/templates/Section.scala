package hepek.templates

import scalatags.Text.all.Frag

/**
 * Used for sectioning a page (usually blog post).
 * Also useful for generating a TOC (Table Of Contents).
 */
case class Section(
    name: String,
    content: Frag,
    children: Seq[Section] = Seq.empty
) {

  /* remove apostrophes, replace spaces with dashes, lowercase */
  def id: String = {
    val trimmedLowerCase = name.trim.toLowerCase
    val validId = trimmedLowerCase.filter { c =>
      c.isLetterOrDigit || c == '-' || c == '_'
    }
    validId
  }
}
