package utils

import ba.sake.hepek.bootstrap3.statik.BootstrapStaticBundle

object Imports extends BootstrapStaticBundle {

  val grid = Grid.withScreenRatios(
    Grid.screenRatios
      .withAll(Ratios().withSingle(1, 2, 1))
      .withSm(None) // stack on small
      .withXs(None) // and extra-small screens
  )
}
