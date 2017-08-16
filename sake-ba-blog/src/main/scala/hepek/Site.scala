package hepek

import hepek.templates.Page
import hepek.templates.BlogPost

object Site {

  val url = "https://blog.sake.ba"

  def mainPages: Seq[BlogPost] = Seq(
    hepek.posts.programiranje.java.Index,
    hepek.posts.programiranje.scala.Index,
    hepek.posts.matematika.Index
  )

}
