package site.posts.programiranje

import ba.sake.hepek.prismjs.{PrismDependencies, PrismSettings, Themes}
import hepek.templates.SakeBaBlogPage

trait CodeTemplate extends SakeBaBlogPage with PrismDependencies {

  override def prismSettings: PrismSettings =
    super.prismSettings.withTheme(Themes.Twilight)

}
