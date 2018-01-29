package hepek.posts.matematika

import hepek.templates.SakeBaBlogPage
import ba.sake.hepek.mathjax.MathjaxDependencies

trait MatematikaTemplate extends SakeBaBlogPage with MathjaxDependencies {

  override def pageCategory = Option("Matematika")

  override def categoryPosts = List(Index, TeorijaSkupova)

}
