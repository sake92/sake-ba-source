package site.posts.programiranje

package scala
import ba.sake.hepek.html.structure.PageSettings

trait ScalaTemplate extends CodeTemplate {

  override def pageSettings = PageSettings().withCategory("Scala")

  override def categoryPosts = List(Index, Uvod)

}
