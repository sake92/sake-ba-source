package hepek.utils.path

/**
 * A PackageRelativePath with `fileName` as the class simple name, plus the `extension`. <br>
 * Default extension is "html". <br>
 * E.g. `class MyClass` will have `fileName` as "MyClass.html". <br>
 * Also, all '$' are removed, because `object`s have them... <br>
 * So the final path will be "my/package/myclass.html" (lowercased in PackageRelativePath)
 */
trait ClassPackageRelativePath extends PackageRelativePath {

  def extension: String = "html"

  override def fileName: String = {
    this.getClass.getSimpleName.replaceAll("\\$", "") + "." + extension
  }

}
