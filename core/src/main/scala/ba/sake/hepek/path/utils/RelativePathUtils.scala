package ba.sake.hepek.path.utils

import ba.sake.hepek.core.RelativePath
import java.nio.file.Paths

// TODO move to hepek-core project, it is indeed a common method
trait RelativePathUtils { self: RelativePath =>

  /**
    * @param other Resource to which path should be calculated
    * @return Relative path from this page to `other`
    */
  def relTo(other: RelativePath): String = {
    // put both paths ON THE SAME LEVEL, in the dummyRoot (imaginary) folder
    val dummyRoot    = "dummy-root"
    val p1           = Paths.get(dummyRoot, this.relPath.toPath.toString())
    val p2           = Paths.get(dummyRoot, other.relPath.toPath.toString())
    val relativePath = p1.getParent.relativize(p2)
    relativePath.toString.replaceAll("""\\""", "/") // change '\' to '/'
  }

}
