package site.posts.programiranje

package java

trait JavaTemplate extends CodeTemplate {

  override def pageCategory = Option("Programiranje")

  override def categoryPosts =
    List(Index, Instalacija, Basics, Types, Functions, FlowControl, HelloWorld)

}
