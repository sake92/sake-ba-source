package hepek.utils.html

import scalatags.Text.all._

// for easier/selective import
object CodeUtils extends CodeUtils

trait CodeUtils {

  def scalaSnippet(body: String, inline: Boolean = false) =
    codeSnippet("scala")(body, inline)
  def javaSnippet(body: String, inline: Boolean = false) =
    codeSnippet("java")(body, inline)
  def shellSnippet(body: String, inline: Boolean = false) =
    codeSnippet("powershell")(body, inline)
  def cSnippet(body: String, inline: Boolean = false) =
    codeSnippet("c")(body, inline)

  /** Snippet of code, highlighted with PrismJS: http://prismjs.com/#basic-usage */
  private def codeSnippet(language: String)(body: String, inline: Boolean) = {
    if (inline)
      code(cls := s"language-$language")(body)
    else
      pre(cls := "line-numbers")(
        code(cls := s"language-$language")(body)
      )
  }

}
