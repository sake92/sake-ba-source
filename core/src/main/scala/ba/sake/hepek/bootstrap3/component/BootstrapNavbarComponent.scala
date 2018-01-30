package ba.sake.hepek.bootstrap3

package component

import scalatags.Text.all._
import ba.sake.hepek.html.component.NavbarComponent

object BootstrapNavbarComponent extends BootstrapNavbarComponent {

  sealed trait Style { def classes: String }

  object Style {
    case object Default extends Style { def classes = "navbar-default " }
    case object Inverse extends Style { def classes = "navbar-inverse " }
  }

  sealed trait Alignment { def classes: String }

  object Alignment {
    case object Left  extends Alignment { def classes = "navbar-left "  }
    case object Right extends Alignment { def classes = "navbar-right " }
  }

}

trait BootstrapNavbarComponent extends NavbarComponent {
  import BootstrapNavbarComponent._
  import NavbarComponent._

  private val nav   = tag("nav")
  private val bsBtn = tag("button")(tpe := "button", cls := "btn ")

  def bsNavbarStyle: Style = Style.Default

  override def navbar(
      position: Position = Position.FixedTop
  )(content: Frag*) = {
    val positionClass = position match {
      case Position.FixedTop    => "navbar-fixed-top"
      case Position.FixedBottom => "navbar-fixed-bottom"
    }
    // TODO add padding to styles
    val styleClass = bsNavbarStyle.classes
    nav(cls := s"navbar $styleClass $positionClass")(
      div(cls := "container")(content)
    )
  }

  def navbarHeader() =
    div(cls := "navbar-header")

  def navbarContent(align: Alignment = Alignment.Right) =
    ul(cls := s"nav navbar-nav ${align.classes}")

  def navbarBrand(homeURL: String) =
    a(cls := "navbar-brand", href := homeURL)

  def navbarCollapse(navCollapseId: String = "main-navbar") =
    div(cls := "collapse navbar-collapse", id := navCollapseId)

  def navbarCollapseToggleBtn(navCollapseId: String = "main-navbar") =
    bsBtn(cls := "navbar-toggle collapsed ",
          data.toggle := "collapse",
          data.target := s"#$navCollapseId")(
      span(cls := "sr-only")("Toggle navigation"),
      span(cls := "icon-bar"),
      span(cls := "icon-bar"),
      span(cls := "icon-bar")
    )

}
