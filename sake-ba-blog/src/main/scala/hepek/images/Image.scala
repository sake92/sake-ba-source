package hepek.images

object Image {

  import ImageResource._

  val favicon = icoImage("favicon")
  val faviconWhite = icoImage("favicon-white")

  object math {
    val skup = svgImage("math/skupovi")
    val unija = svgImage("math/unija")
    val presjek = svgImage("math/presjek")
    val razlika = svgImage("math/razlika")
  }

  object java {
    val compiler = gifImage("java/compiler")
    val portability = gifImage("java/portability")
    val platform = gifImage("java/platform")
    // instalacija
    val downloadJDK1 = jpgImage("java/download-jdk-1")
    val downloadJDK2 = jpgImage("java/download-jdk-2")
    val installJDKFolder = jpgImage("java/install-jdk-folder")
    val installJRENope = jpgImage("java/install-jre-no")
  }

  object os {
    // windows
    val winCompProps = jpgImage("os/windows/computer-properties")
    val winSysProps = jpgImage("os/windows/system-properties")
    val winSysVars = jpgImage("os/windows/system-variables")
    val winJavaVer = jpgImage("os/windows/cmd-java-version")
  }

  object programming {
    val error = jpgImage("programming/error")
  }

}
