package hepek.utils.html

import scalatags.Text.all._

// for easier/selective import
object ImageUtils extends ImageUtils

trait ImageUtils {

  // "captionn" bcoz there's a <caption> tag in HTML...

  /** Renders a pretty bootstrapy image with optional caption text */
  def image(source: String, captionn: String = "") =
    div(cls := "thumbnail")(
      img(src := source, cls := "img-responsive", alt := captionn), {
        if (captionn.trim.isEmpty) frag() // empty if no description...
        else div(cls := "caption text-center")(p(captionn))
      }
    )

  /** Renders a pretty bootstrapy SVG image with optional caption text */
  def svg(source: String, captionn: String = "") =
    div(cls := "thumbnail")(
      tag("object")(tpe := "image/svg+xml",
                    cls := "embed-responsive-item",
                    data := source)("Ne radi ti SVG..."), {
        if (captionn.trim.isEmpty) frag() // empty if no description...
        else div(cls := "caption text-center")(p(captionn))
      }
    )

}
