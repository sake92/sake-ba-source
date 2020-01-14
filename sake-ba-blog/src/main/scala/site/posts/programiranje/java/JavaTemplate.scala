package site.posts.programiranje

package java

trait JavaTemplate extends CodeTemplate {

  override def pageCategory = Some("Programiranje")

  override def categoryPosts = List(
    Index,
    Instalacija,
    Basics,
    Types,
    Statements,
    HelloWorld,
    Branching,
    Loops,
    Functions,
    Arrays,
    Types2,
    Classes,
    Scope
  )

}
