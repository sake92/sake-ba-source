package hepek.utils.html

import scalatags.Text.all._

// for easier/selective import
object CodeUtils extends CodeUtils

trait CodeUtils {

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
