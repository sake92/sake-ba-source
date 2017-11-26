package hepek.utils.html

import scalatags.Text.all._
import scala.collection.Seq

object HTMLUtils extends HTMLUtils

trait HTMLUtils {

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

}
