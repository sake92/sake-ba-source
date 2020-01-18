package site.posts.programiranje

import ba.sake.hepek.prismjs
import ba.sake.hepek.prismjs.{PrismDependencies, Themes}
import templates.SakeBaBlogPage

trait CodeTemplate extends SakeBaBlogPage with PrismDependencies {

  private val hlLangs = List(
    "core",
    "c",
    "clike",
    "batch",
    "scala",
    "java",
    "markup",
    "markup-templating"
  )

  override def prismSettings =
    super.prismSettings
      .withTheme(Themes.Twilight)
      .withLanguages(prismjs.PrismConsts.languages filter hlLangs.contains)
}
