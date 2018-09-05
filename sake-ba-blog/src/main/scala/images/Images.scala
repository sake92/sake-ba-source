package images

import ba.sake.hepek.Resources.images._

object Images {

  val favicon      = ico("favicon")
  val faviconWhite = ico("favicon-white")

  object math {
    val skup    = svg("math/skupovi")
    val unija   = svg("math/unija")
    val presjek = svg("math/presjek")
    val razlika = svg("math/razlika")
  }

  object java {
    val compiler    = gif("java/compiler")
    val portability = gif("java/portability")
    val platform    = gif("java/platform")
    // instalacija
    val downloadJDK1     = jpg("java/download-jdk-1")
    val downloadJDK2     = jpg("java/download-jdk-2")
    val installJDKFolder = jpg("java/install-jdk-folder")
    val installJRENope   = jpg("java/install-jre-no")
  }

  object os {
    // windows
    val winCompProps = jpg("os/windows/computer-properties")
    val winSysProps  = jpg("os/windows/system-properties")
    val winSysVars   = jpg("os/windows/system-variables")
    val winJavaVer   = jpg("os/windows/cmd-java-version")
  }

  object programming {
    val error = jpg("programming/error")
  }

}
