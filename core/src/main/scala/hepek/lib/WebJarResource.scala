package hepek.lib

import hepek.js.JSFile

object WebJarResource {

  def js(name: String): JSFile = new WebJarResourceJS(name)
  def jsMin(name: String): JSFile = new WebJarResourceJS(name + ".min")

  def css(name: String): JSFile = new WebJarResourceCSS(name)
  def cssMin(name: String): JSFile = new WebJarResourceCSS(name + ".min")

  private class WebJarResourceJS(name: String) extends JSFile {
    override def fileName = name + ".js"
  }

  private class WebJarResourceCSS(name: String) extends JSFile {
    override def fileName = name + ".css"
  }

}
