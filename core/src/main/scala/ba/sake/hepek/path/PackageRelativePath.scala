package ba.sake.hepek.path

import java.io.File
import ba.sake.hepek.core.RelativePath

/**
  * Path relative to the class' package. <br>
  * E.g. `object MyPage extends PackageRelativePath { def fileName = "mypage.html" }` in `my.company` package renders to `my/company/mypage.html`
  */
trait PackageRelativePath extends RelativePath {

  /** Simple name of the rendered file. */
  def fileName: String

  /** Path of resource relative to `sbt-hepek:hepekTarget` folder. */
  final override def relPath: File = {
    // needed for Path#relativize later :)
    val path = if (this.getClass.getPackage == null) {
      fileName
    } else {
      this.getClass.getPackage.getName.replaceAll("\\.", "/") + "/" + fileName
    }
    new File(path.toLowerCase)
  }

}
