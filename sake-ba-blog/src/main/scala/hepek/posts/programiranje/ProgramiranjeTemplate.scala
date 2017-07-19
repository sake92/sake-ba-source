package hepek.posts.programiranje

import hepek.templates._

trait ProgramiranjeTemplate extends BlogPost {

  // all pages in this category
  override def pages = Seq(Index, Java, Instalacija, HelloWorld)

  override def pageCategory = Option("Programiranje")

  override def author: String = "Sakib Hadžiavdić"

}
