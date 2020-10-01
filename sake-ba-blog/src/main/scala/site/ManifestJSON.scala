package site

import java.nio.file.Paths
import ba.sake.hepek.core.Renderable
import ba.sake.hepek.html.utils.HepekPickler
import ba.sake.hepek.html.pwa.WebAppManifestIcon

object ManifestJSON extends Renderable {

  val IconSizes = List(72, 96, 128, 144, 152, 192, 384, 512)

  override def relPath = Paths.get("site/manifest.json")

  override def render = {
    val icons = IconSizes.map { s =>
      val sizeStr = s"${s}x${s}"
      WebAppManifestIcon(
        s"images/icons/icon-$sizeStr.png",
        sizeStr,
        "image/png"
      )
    }
    val mf = Index.manifest
      .withBackgroundColor("#000")
      .withName("Saketovi tutorijali")
      .withShortName("Sake tuts")
      .withDescription("Tutorijali iz programiranja")
      .withIcons(icons)
    HepekPickler.write(mf)
  }
}
