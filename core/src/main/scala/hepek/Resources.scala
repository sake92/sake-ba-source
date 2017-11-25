package hepek

object Resources {

  // css folder
  object styles {
    def css(baseName: String) = new hepek.styles.CSSFile(baseName)
  }

  // js folder
  object scripts {
    def js(baseName: String) = new hepek.scripts.JSFile(baseName)
  }

  // images folder
  object images {
    def image(fullName: String) = new hepek.images.ImageFile(fullName)
    def ico(baseName: String) = image(baseName + ".ico")
    def svg(baseName: String) = image(baseName + ".svg")
    def jpg(baseName: String) = image(baseName + ".jpg")
    def gif(baseName: String) = image(baseName + ".gif")
  }

  // lib folder
  object lib {
    def js(baseName: String) = new hepek.lib.JSFile(baseName)
    def jsMin(baseName: String) = js(baseName + ".min")

    def css(baseName: String) = new hepek.lib.CSSFile(baseName)
    def cssMin(baseName: String) = css(baseName + ".min")
  }

}
