package hepek.css

import ba.sake.hepek.core.RelativePath

import hepek.utils.RawRelativePath

/**
 * A marker trait for all CSS files (typesafe <link> tags.. silly but hey.. :D).
 *  CSS files can be in /css folder, represented by CSSResource,
 *  or in /lib folder, represented by WebJarResource.
 */
trait CSSFile extends RawRelativePath

class CSSResource(name: String) extends CSSFile {
  override def fileName = name + ".css"
}

object CSSResource {
  def apply(name: String): RelativePath = new CSSResource(name)
}
