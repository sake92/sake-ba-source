package hepek.posts.programiranje.scala

import hepek.templates.BlogPost

/** Template for Scala tutorial pages. */
trait ScalaTemplate extends BlogPost {

  // all pages in this category
  override def pages = Seq(Index, Uvod)

  override def pageCategory = Option("Scala")

  override def author = "Sakib Hadžiavdić"

}
