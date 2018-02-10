package site.posts.programiranje

import ba.sake.hepek.prismjs.PrismDependencies
import hepek.templates.SakeBaBlogPage
import ba.sake.hepek.Resource

trait CodeTemplate extends SakeBaBlogPage with PrismDependencies {
  override def prismTheme = "prism-twilight"
}
