package hepek

import hepek.templates.Page
import hepek.templates.BlogPost

object Site {

  def mainPages: Seq[BlogPost] = Seq(
    hepek.posts.programiranje.java.Index,
    hepek.posts.programiranje.scala.Index,
    hepek.posts.matematika.Index
  )

}
