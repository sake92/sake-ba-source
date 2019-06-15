package utils

import ba.sake.hepek.Resources
import ba.sake.hepek.html.component.BasicComponents
import ba.sake.hepek.prismjs.PrismCodeHighlightComponents
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticBundle
import ba.sake.hepek.bootstrap3.component.BootstrapImageComponents

object Imports
    extends BootstrapStaticBundle
    with BasicComponents
    with BootstrapImageComponents {

  object resources extends Resources

  object chl extends PrismCodeHighlightComponents

  def jshell = chl.batch.withPrompt("jshell>")

}
