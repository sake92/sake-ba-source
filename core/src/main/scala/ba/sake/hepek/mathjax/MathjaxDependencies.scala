package ba.sake.hepek.mathjax

import ba.sake.hepek.html.structure.Page

trait MathjaxDependencies extends Page {

  def mathjaxVersion: String = "2.7.2"

  def mathjaxConfig: String = "default"

  def mathjaxJSDependencies: List[String] =
    List(s"$cdnJSURL/mathjax/$mathjaxVersion/MathJax.js?config=$mathjaxConfig")

  abstract override def scriptURLs = super.scriptURLs ++ mathjaxJSDependencies

}
