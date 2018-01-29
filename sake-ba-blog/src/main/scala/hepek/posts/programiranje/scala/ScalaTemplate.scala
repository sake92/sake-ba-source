package hepek.posts.programiranje

package scala

import hepek.templates.SakeBaBlogPage

trait ScalaTemplate extends CodeTemplate {

  override def pageCategory = Option("Scala")

  override def categoryPosts = List(Index, Uvod)

}
