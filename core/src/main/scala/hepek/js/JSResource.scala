package hepek.js

import hepek.utils.RawRelativePath

/**
 * A marker trait for all JS files (typesafe <script> tags.. silly but hey.. :D).
 *  JS files can be in /js folder, represented by JSResource,
 *  or in /lib folder, represented by WebJarResource.
 */
trait JSFile extends RawRelativePath

class JSResource(name: String) extends JSFile {
  override def fileName = name + ".js"
}

object JSResource {
  def apply(name: String) = new JSResource(name)
}
