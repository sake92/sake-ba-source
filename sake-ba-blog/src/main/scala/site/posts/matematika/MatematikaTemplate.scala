package site.posts.matematika

import ba.sake.hepek.katex.KatexDependencies
import templates.SakeBaBlogPage
import ba.sake.hepek.html.statik.BlogPostPage

trait MatematikaTemplate extends SakeBaBlogPage with KatexDependencies {

  override def pageCategory = Some("Matematika")

  // compiler sometimes doesn't infer the type ??????????????
  override def categoryPosts: List[BlogPostPage] = List(Index, TeorijaSkupova)

}
