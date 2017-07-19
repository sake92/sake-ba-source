package hepek.images

import ba.sake.hepek.core.RelativePath

import hepek.utils.RawRelativePath

// TODO add pretty name... and maybe description?
class ImageResource(fullName: String) extends RawRelativePath {
  override def fileName = fullName
}

object ImageResource {
  def apply(fullName: String): RelativePath = new ImageResource(fullName)

  // IDK why I made these... LOL
  def icoImage(baseName: String) = ImageResource(baseName + ".ico")
  def svgImage(baseName: String) = ImageResource(baseName + ".svg")
  def jpgImage(baseName: String) = ImageResource(baseName + ".jpg")
  def gifImage(baseName: String) = ImageResource(baseName + ".gif")
}
