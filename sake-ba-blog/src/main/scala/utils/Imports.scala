package utils

import ba.sake.hepek.Resources
import ba.sake.hepek.prismjs.PrismCodeHighlightComponents
import ba.sake.hepek.bootstrap3.statik.BootstrapStaticBundle

object Imports extends BootstrapStaticBundle {

  object resources extends Resources

  val grid = Grid.withScreenRatios(
    Grid.screenRatios
      .withSm(None) // stack on small
      .withXs(None) // and extra-small screens
  )

  object chl extends PrismCodeHighlightComponents

  def jshell = chl.batch.withPrompt("jshell>")

}
