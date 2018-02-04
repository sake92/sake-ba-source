package hepek.utils

import hepek.templates.SakeBaBlogPage
import site.posts

object Site {

  val url = "https://blog.sake.ba"
  val name = "blog.sake.ba"

  def mainPages: List[SakeBaBlogPage] = List(
    posts.programiranje.java.Index,
    posts.programiranje.scala.Index,
    posts.matematika.Index
  )

}
