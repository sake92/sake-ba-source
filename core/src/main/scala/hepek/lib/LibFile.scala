package hepek.lib

import hepek.scripts.JSResource
import hepek.styles.CSSResource

/**
 * JS file in the `lib/` folder. Usually placed by WebJars.
 */
final class JSFile(name: String) extends JSResource {
  override def fileName = name + ".js"
}

/**
 * CSS file in the `lib/` folder. Usually placed by WebJars.
 */
final class CSSFile(name: String) extends CSSResource {
  override def fileName = name + ".css"
}
