package ba.sake.hepek.html.component

import scalatags.Text.all._

object BasicComponents extends BasicComponents

trait BasicComponents {

  /** Anchor link : <a href="hreff"> */
  def hyperlink(hreff: String, newWindow: Boolean = false): Frag = {
    val optParams = if (newWindow) List(target := "_blank") else List()
    a(href := hreff, optParams)
  }

  def markdown(s: String): Frag = {
    val parts = s.split("\n+").toList
    parts.map(part => frag(part, br))
  }

}
