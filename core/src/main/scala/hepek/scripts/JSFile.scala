package hepek.scripts

import ba.sake.hepek.core.RelativePath

/**
 * JS file in the `js/` folder.
 * @author Sake
 *
 */
final class JSFile(name: String) extends JSResource {
  override def fileName = name + ".js"
}
