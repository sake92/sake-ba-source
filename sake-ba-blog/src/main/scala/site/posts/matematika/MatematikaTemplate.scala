package site.posts.matematika
import scalatags.Text.all._
import hepek.templates.SakeBaBlogPage
import ba.sake.hepek.html.structure.blog.BlogPostPage
import ba.sake.hepek.katex.KatexDependencies

trait MatematikaTemplate extends SakeBaBlogPage with KatexDependencies {

  override def pageCategory = Option("Matematika")

  // compiler sometimes doesn't infer the type ??????????????
  override def categoryPosts: List[BlogPostPage] = List(Index, TeorijaSkupova)

}
