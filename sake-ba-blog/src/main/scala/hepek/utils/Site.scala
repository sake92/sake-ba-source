package hepek.utils

import ba.sake.hepek.html.structure.StaticPage
import hepek.templates.SakeBaBlogPage
import site.posts

object Site {

  val url  = "https://blog.sake.ba"
  val name = "blog.sake.ba"

  def mainPages: List[StaticPage] = List(
    posts.programiranje.java.Index,
    posts.programiranje.scala.Index,
    posts.programiranje.ProgrammingGlossary,
    posts.matematika.Index
  )

}
