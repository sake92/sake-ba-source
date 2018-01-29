package ba.sake.hepek.html

package structure

package blog

import java.time.format.DateTimeFormatter
import java.time.LocalDate
import scalatags.text.Frag

trait BlogPostPage extends Page {

  def postAuthor: String

  def postCreateDate: LocalDate

  def postSections: List[Section] = List.empty

  def categoryPosts: List[BlogPostPage]

  def dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy")

}

/**
  * Handy class for sectioning a page (usually blog post). <br>
  * Also useful for generating a TOC (Table Of Contents).
  */
case class Section(name: String,
                   content: Frag,
                   children: List[Section] = List.empty) {

  import Section._

  // TODO replace šđčćž ...
  /* taken from "urlify" function in anchorjs.js */
  def id: String = {
    val trimmedLower = name.trim.toLowerCase.filterNot(_ == ''')
    // - replace all unsafe chars with a dash
    // - remove all dashes at left and right
    // - remove multiple dashes with just one
    val replacedWithDash = trimmedLower.replaceAll(UnsafeCharsRegex, "-")
    val removedTrailingDashes =
      replacedWithDash.dropWhile(_ == '-').reverse.dropWhile(_ == '-').reverse
    removedTrailingDashes.replaceAll("-+", "-")
  }

}

object Section {

  private val UnsafeCharsRegex = """[& +$,:;=?@"#{}|^~\[`%!'\]./()*\\]"""

}
