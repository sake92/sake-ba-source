package ba.sake.hepek.anchorjs

import ba.sake.hepek.html.structure.Page

trait AnchorjsDependencies extends Page {

  def anchorjsVersion: String = "4.1.0"

  def anchorjsJSDependencies: List[String] =
    List(s"$cdnJSURL/anchor-js/$anchorjsVersion/anchor.min.js")

  abstract override def scriptURLs = super.scriptURLs ++ anchorjsJSDependencies

}
