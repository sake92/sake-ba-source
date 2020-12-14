package site

import scalatags.Text.all._
import scala.collection.decorators._
import ba.sake.hepek.html.statik.Section
import utils.Imports._

object Index extends templates.SakeBaPage {

  override def pageSettings =
    super.pageSettings
      .withTitle("Home")
      .withDescription(
        "sake.ba is a personal website belonging to Sakib Hadžiavdić. " +
          "Tutorials for programming, maths etc."
      )

  override def pageContent = div(
    """
       # Hi! My name is Sakib.
       ## I write software in Scala and Java.
       ---
    """.md,
    sections.map { s =>
      div(h3(s.name), s.content)
    }
  )

  def sections =
    List(resourcesSection, projectsSection, talksSection, aboutSection)

  val resourcesSection = Section(
    "Stuff I do",
    div(
      """
        - pišem [tutorijale](https://blog.sake.ba) na Bosanskome jeziku :)
        - writing [useful notes](https://github.com/sake92/notes)
        - hanging out with [JUGBA](https://jugba.org/) members
      """.md
    )
  )

  val projectsSection = Section(
    "Projects",
    ul(
      List(
        (
          "Hepek",
          "https://github.com/sake92/hepek",
          "very powerful static site generator"
        ),
        (
          "RxTags",
          "https://github.com/sake92/RxTags",
          "simple, reactive ScalaJS UI library"
        ),
        (
          "Stone",
          "https://github.com/sake92/stone#route",
          "simple and type safe URL (de)construction"
        ),
        (
          "nand2tetris",
          "https://github.com/sake92/nand2tetris",
          "assembler, VM, and a PL from nand2tetris course"
        )
      ).map {
        case (title, url, desc) =>
          li(hyperlink(url)(title), s" - $desc")
      }
    )
  )

  val talksSection = Section(
    "Talks",
    div(
      List(
        (
          "https://sake.ba/presentations/2018-01-23%20Scala%20intro%20-%20OpenWeb%20Sarajevo",
          "Scala intro"
        ),
        (
          "https://sake.ba/presentations/2018-08-28%20Hepek%20-%20OpenWeb%20Sarajevo",
          "Hepek"
        ),
        (
          "https://sake.ba/presentations/2018-09-08%20FP%20intro%20-%20freeCodeCamp%20Sarajevo",
          "FP intro"
        ),
        (
          "https://sake.ba/presentations/2018-10-27%20OpenSource%20-%20Hacktoberfest%20Sarajevo",
          "Open Source"
        ),
        (
          "https://sake.ba/presentations/2020-01-07%20Writing%20an%20interpreter%20-%20OpenWeb%20Sarajevo/#/",
          "Writing an interpreter"
        ),
        (
          "https://sake.ba/presentations/2020-09-09%20Amber%20-%20JUGBA/#/",
          "Project Amber"
        )
      ).map { case (url, title) => hyperlink(url)(title) }
        .intersperse(", ": Frag)
    )
  )

  val aboutSection = Section(
    "About",
    div(
      s"""
      - follow me on [twitter](https://twitter.com/sake_92)
      - stalk me on [linkedin](https://www.linkedin.com/in/sakib-hadziavdic)
      - send me an [email](mailto:sakib@sake.ba)
      """.md
    )
  )

}
