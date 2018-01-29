package ba.sake.hepek.mathjax

import scalatags.Text.all.frag
import scalatags.Text.all.Frag
import scalatags.Text.all.stringFrag

object MathjaxComponents extends MathjaxComponents

trait MathjaxComponents {

  def asciiMath(content: String): Frag =
    frag(content)

}
