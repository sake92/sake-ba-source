package ba.sake.hepek.path

import java.io.File
import ba.sake.hepek.core.RelativePath

trait RootRelativePath extends RelativePath {

  def fileName: String

  override def relPath = new File("hepek/" + fileName)

}
