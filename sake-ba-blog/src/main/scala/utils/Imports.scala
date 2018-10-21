package utils

import ba.sake.hepek.Resources
import ba.sake.hepek.html.component.BasicComponents
import ba.sake.hepek.bootstrap3.component.AllBootstrapComponents
import ba.sake.hepek.prismjs.PrismCodeHighlightComponents

object Imports extends AllBootstrapComponents with BasicComponents {

  object resources extends Resources

  object chl extends PrismCodeHighlightComponents

}
