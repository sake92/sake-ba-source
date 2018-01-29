package hepek.posts.programiranje

package java

import hepek.templates._

trait JavaTemplate extends CodeTemplate {

  override def pageCategory = Option("Programiranje")

  override def categoryPosts = List(Index, Java, Instalacija, HelloWorld)

}
