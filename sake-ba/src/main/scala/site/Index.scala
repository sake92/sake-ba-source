package site

import scalatags.Text.all._
import scala.collection.decorators._
import ba.sake.hepek.Resources.images
import utils.Imports._, Classes._, grid._
import ba.sake.hepek.fontawesome5.FA

object Index extends templates.SakeBaPage {

  override def pageSettings =
    super.pageSettings
      .withTitle("Home")
      .withDescription(
        "sake.ba is personal website belonging to Sakib Hadžiavdić. " +
          "Tutorials from maths, programming etc."
      )

  override def pageContent = row(
    div(txtAlignCenter)(
      s"""
        # Hi! My name is Sakib.  
        ### I write software.
        #### Scala and Java are my favorite languages. ${FA.heart()}
      """.md
    ),
    div(
      sections.map { s =>
        div(cls := "well well-sm")(
          s.content
        )
      }
    )
  )

  def sections =
    List(resourcesSection, projectsSection, talksSection, aboutSection)

  val resourcesSection = Section(
    "Resources",
    div(
      """
        I write:
        - [tutorijale na Bosanskome jeziku](https://blog.sake.ba) :)
        - [semi-useful notes](https://github.com/sake92/notes) in English mainly
      """.md
    )
  )

  val projectsSection = Section(
    "Projects",
    div(
      "My awesomest projects : ",
      ul(
        List(
          (
            "Hepek",
            "https://github.com/sake92/hepek",
            "Very powerful static site generator"
          ),
          (
            "nand2tetris",
            "https://github.com/sake92/nand2tetris",
            "Assembler, VM, and a PL from nand2tetris course"
          )
        ).map {
          case (title, url, desc) =>
            li(hyperlink(url)(title), s" ($desc)")
        }
      )
    )
  )

  val talksSection = Section(
    "Talks",
    div(
      "Some talks i gave: ",
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
        )
      ).map { case (url, title) => hyperlink(url)(title) }
        .intersperse(", ": Frag)
    )
  )

  val aboutSection = Section(
    "About",
    div(
      """
      You can:
      - follow me on [Twitter](https://twitter.com/sake_92)
      - stalk me on [Linkedin](https://www.linkedin.com/in/sakib-hadziavdic)
      - [email](mailto:sakib@sake.ba) me?
      """.md
    )
  )

}
