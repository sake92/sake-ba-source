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
        "sake.ba is a personal website belonging to Sakib Hadžiavdić."
      )

  override def pageContent = div(cls := "main")(
    """
       # Hi, I am Sakib!
    """.md,
    div(cls := "sections")(
      sections.map { s =>
        div(cls := "section")(h3(s.name), s.content)
      }
    )
  )

  def sections =
    List(resourcesSection, projectsSection, talksSection, aboutSection)

  val resourcesSection = Section(
    "Stuff I do",
    div(
      """
        - writing [tutorials](https://blog.sake.ba)
        - taking [notes](https://github.com/sake92/notes)
        - helping organize [JUGBA](https://jugba.org)
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
          "reactive Scala.js UI library"
        ),
        (
          "Stone",
          "https://github.com/sake92/stone#route",
          "type safe URL (de)construction"
        ),
        (
          "nand2tetris",
          "https://github.com/sake92/nand2tetris",
          "assembler, VM, and a PL"
        )
      ).map {
        case (title, url, desc) =>
          li(hyperlink(url)(title), s" - $desc")
      }
    )
  )

  val talksSection = Section(
    "Talks",
    ul(
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
      ).map {
        case (url, title) =>
          li(hyperlink(url)(title))
      }
    )
  )

  val aboutSection = Section(
    "About",
    div(
      """
      [twitter](https://twitter.com/sake_92),
      [linkedin](https://www.linkedin.com/in/sakib-hadziavdic),
      [github](https://github.com/sake92),
      [email](mailto:sakib@sake.ba)
      """.md
    )
  )

}
