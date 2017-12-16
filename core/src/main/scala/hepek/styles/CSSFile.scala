package hepek.styles

import ba.sake.hepek.core.RelativePath

/**
  * CSS file in the `css/` folder.
  * @author Sake
  *
  */
final class CSSFile(name: String) extends CSSResource {
  override def fileName = name + ".css"
}
