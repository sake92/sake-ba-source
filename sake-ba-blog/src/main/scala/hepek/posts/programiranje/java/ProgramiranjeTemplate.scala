package hepek.posts.programiranje.java

import hepek.templates._

trait ProgramiranjeTemplate extends BlogPost {

  override def pages = Seq(Index, Java, Instalacija, HelloWorld)

  override def pageCategory = Option("Programiranje")

}
