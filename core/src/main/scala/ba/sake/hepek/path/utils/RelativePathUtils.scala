package ba.sake.hepek.path.utils

import ba.sake.hepek.core.RelativePath

trait RelativePathUtils { self: RelativePath =>

  /**
    * @param other Resource to which path should be calculated
    * @return Relative path from this page to `other`
    */
  def relTo(other: RelativePath): String = {
    // TODO if(nemaParent) poravnaj_na_root OBA !!! i onda relativize... :)
    val relP = this.relPath.toPath.getParent.relativize(other.relPath.toPath)
    relP.toString.replaceAll("""\\""", "/") // change '\' to '/'
  }

}
