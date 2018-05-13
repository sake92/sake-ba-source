package site.posts.matematika

import hepek.templates.SakeBaBlogPage
import ba.sake.hepek.html.structure.blog.BlogPostPage
import ba.sake.hepek.mathjax.MathjaxDependencies

trait MatematikaTemplate extends SakeBaBlogPage with MathjaxDependencies {

  override def pageCategory = Option("Matematika")

  // compiler sometimes doesn't infer the type ??????????????
  override def categoryPosts: List[BlogPostPage] = List(Index, TeorijaSkupova)

  // https://en.wikipedia.org/wiki/Acute_accent
  // couldn't find better escape character,
  // all other are used in Markdown
  override def scriptsInline =
    super.scriptsInline ++
      List(s"""
        MathJax.Hub.Config({
            asciimath2jax: {
                delimiters: [['´','´']]
            }
        });
      """)

}
