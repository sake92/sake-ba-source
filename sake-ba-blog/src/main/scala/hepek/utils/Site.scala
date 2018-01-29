package hepek.utils

import hepek.templates.SakeBaBlogPage

object Site {

  val url  = "https://blog.sake.ba"
  val name = "blog.sake.ba"

  def mainPages: List[SakeBaBlogPage] = List(
    hepek.posts.programiranje.java.Index,
    hepek.posts.programiranje.scala.Index,
    hepek.posts.matematika.Index
  )

}
