package site.posts.matematika
import scalatags.Text.all._
import hepek.templates.SakeBaBlogPage
import ba.sake.hepek.html.structure.blog.BlogPostPage
import ba.sake.hepek.katex.KatexDependencies

trait MatematikaTemplate extends SakeBaBlogPage with KatexDependencies {

  override def pageCategory = Option("Matematika")

  // compiler sometimes doesn't infer the type ??????????????
  override def categoryPosts: List[BlogPostPage] = List(Index, TeorijaSkupova)

  // https://en.wikipedia.org/wiki/Acute_accent
  // couldn't find better escape character, all other are used in Markdown
  override def scriptsInline =
    super.scriptsInline ++
      List("""
        renderMathInElement(
          document.body, {
            delimiters: [
              { left: "´", right: "´", display: false }, // inline
              { left: "$$", right: "$$", display: true } // block, centered
            ]
        });
      """)

}
