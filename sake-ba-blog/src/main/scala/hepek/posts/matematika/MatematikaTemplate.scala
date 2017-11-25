package hepek.posts.matematika

import scalatags.Text.all._

import hepek.templates.BlogPost

trait MatematikaTemplate extends BlogPost {

  // here we specify all the pages in this category
  override def pages = Seq(Index, TeorijaSkupova)

  override def pageCategory = Option("Matematika")

  override def additionalJS = super.additionalJS ++
    Seq(
      // MathJax library for highlighting
      script(src := "https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.0/MathJax.js?config=AM_CHTML")
    )

}
