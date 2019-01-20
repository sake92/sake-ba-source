package site.posts.programiranje

package java

import ba.sake.hepek.html.structure.PageSettings

trait JavaTemplate extends CodeTemplate {

  override def pageSettings = PageSettings().withCategory("Programiranje")

  override def categoryPosts = List(
    Index,
    Instalacija,
    Basics,
    Types,
    Statements,
    HelloWorld,
    FlowControl,
    Functions,
    Arrays
  )

}
