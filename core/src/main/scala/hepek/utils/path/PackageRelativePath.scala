package hepek.utils.path

import java.io.File
import ba.sake.hepek.core.RelativePath

/**
  * Path relative to the class' package. <br>
  * E.g. `object MyPage extends PackageRelativePath { def fileName = "mypage.html" }` in `my.company` package renders to `my/company/mypage.html`
  */
trait PackageRelativePath extends RelativePath {

  /** Simple name of the rendered file. */
  def fileName: String

  /** Path of resource relative to `sbt-hepek:hepekTarget` folder.   */
  final override def relPath: File = {
    // needed for Path#relativize later :)
    val packagePath = if (this.getClass.getPackage == null) {
      "dummy-root"
    } else {
      this.getClass.getPackage.getName.replaceAll("\\.", "/")
    }
    val p = packagePath + "/" + fileName
    new File(p.toLowerCase)
  }

}
