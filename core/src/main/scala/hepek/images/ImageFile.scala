package hepek.images

import ba.sake.hepek.core.RelativePath

/**
 * Image file in the `images/` folder.
 * @author Sake
 *
 */
final class ImageFile(name: String) extends ImageResource {
  override def fileName = name
}
