package hepek

import hepek.templates.Page
import hepek.templates.BlogPost

/**
  * Site global settings.
  */
object Site {

  val url = "https://blog.sake.ba"
  val name = "blog.sake.ba"

  def mainPages: Seq[BlogPost] = Seq(
    hepek.posts.programiranje.java.Index,
    hepek.posts.programiranje.scala.Index,
    hepek.posts.matematika.Index
  )

}
