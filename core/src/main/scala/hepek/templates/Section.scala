package hepek.templates

import scalatags.Text.all.Frag

/**
 * Used for sectioning a page (usually blog post). <br>
 * Also useful for generating a TOC (Table Of Contents).
 */
case class Section(
    name: String,
    content: Frag,
    children: Seq[Section] = Seq.empty
) {

  import Section._

  /* @see urlify in anchorjs.js */
  def id: String = {
    val trimmedLower = name.trim.toLowerCase.filterNot(_ == ''')
    // replace all unsafe chars with a dash
    val replacedWithDash = trimmedLower.replaceAll(UnsafeCharsRegex, "-")
    // remove all dashes at left and right
    val removedTrailingDashes = replacedWithDash.dropWhile(_ == '-').reverse.dropWhile(_ == '-').reverse
    // remove 1+ dashes with just one
    removedTrailingDashes.replaceAll("-+", "-")
  }
}

object Section {
  private val UnsafeCharsRegex = """[& +$,:;=?@"#{}|^~\[`%!'\]./()*\\]""" // REGEX !
}
