package ba.sake.hepek.bootstrap3.component

import scalatags.Text.all._
import ba.sake.hepek.html.component.GridComponents

object BootstrapGridComponents extends BootstrapGridComponents

trait BootstrapGridComponents extends GridComponents {
  import GridComponents._

  override def row(content: Frag*) =
    div(cls := "row")(content)

  override def row(half1: Half1, half2: Half2) =
    row(half1.content ++ half2.content)

  override def row(third1: Third1, third2: Third2, third3: Third3) =
    row(third1.content ++ third2.content ++ third3.content)

  // HALF
  override def half1(content: Frag*) = {
    val r = ratio2BS(ratios.half.values(0), ratios.half.values)
    val c = div(cls := s"col-xs-$r")(content)
    Half1(List(c))
  }

  override def half2(content: Frag*) = {
    val r = ratio2BS(ratios.half.values(1), ratios.half.values)
    val c = div(cls := s"col-xs-$r")(content)
    Half2(List(c))
  }

  // THIRD
  override def third1(content: Frag*) = {
    val r = ratio2BS(ratios.third.values(0), ratios.third.values)
    val c = div(cls := s"col-xs-$r")(content)
    Third1(List(c))
  }

  override def third2(content: Frag*) = {
    val r = ratio2BS(ratios.third.values(1), ratios.third.values)
    val c = div(cls := s"col-xs-$r")(content)
    Third2(List(c))
  }

  override def third3(content: Frag*) = {
    val r = ratio2BS(ratios.third.values(2), ratios.third.values)
    val c = div(cls := s"col-xs-$r")(content)
    Third3(List(c))
  }

  /* HELPERS */
  private def ratio2BS(ratio: Int, allRatios: List[Int]): Int =
    // for args 1,1:2 => (1/3)*12 == 4
    ((ratio / allRatios.sum.toDouble) * 12).toInt

}
