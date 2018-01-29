package ba.sake.hepek.html.component

import scalatags.Text.all.Frag

trait NavbarComponent {
  import NavbarComponent._

  def navbar(mode: Position = Position.FixedTop)(content: Frag*): Frag

}

object NavbarComponent {

  sealed trait Position

  object Position {
    case object FixedTop    extends Position
    case object FixedBottom extends Position
  }

}
