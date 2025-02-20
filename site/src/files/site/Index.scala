package files

import scalatags.Text.all._
import scalatags.Text.tags2.{main, section}
import ba.sake.hepek.html.statik.Section
import utils.Imports._

object Index extends templates.SakeBaPage {

  override def pageSettings =
    super.pageSettings
      .withTitle("Home")
      .withDescription(
        "sake.ba is a personal website belonging to Sakib Hadžiavdić."
      )

  override def pageContent = main(
    """
       # Hello World! 🌍
       
       Hi! I am Sakib. 🙋‍♂️  
       Welcome to my personal website.
       
       
    """.md,
    div(cls := "sections")(
      sections.map { s =>
        section(h3(s.name), s.content)
      }
    ),
    """
      |I also have my sole proprietorship company called [SaCode](https://sacode.dev/).
      |""".stripMargin
  )

  def sections =
    List(resourcesSection, projectsSection, talksSection, aboutSection)

  val resourcesSection = Section(
    "Content",
    div(
      """
        - book [Learn Programming with FlowRun](https://a.co/d/bVxMBe4) for beginner programmers
        - [blog in English](https://blog.sake.ba/en/posts/programming/monads.html)
        - [blog na bosanskom](https://blog.sake.ba)
        - [notes](https://github.com/sake92/notes)
      """.md
    )
  )

  val projectsSection = Section(
    "Open Source Software",
    ul(
      List(
        (
          "FlowRun",
          "https://flowrun.io/",
          "runnable flowcharts for web"
        ),
        (
          "Sharaf",
          "https://sake92.github.io/sharaf/",
          "Minimalistic Scala 3 web framework"
        ),
        (
          "Hepek",
          "https://github.com/sake92/hepek",
          "static site generator"
        ),
        (
          "OpenApi generators for Scala",
          "https://github.com/sake92/openapi4s",
          "type safe URL (de)construction"
        ),
        (
          "nand2tetris",
          "https://github.com/sake92/nand2tetris",
          "assembler, VM, and a PL"
        )
      ).map { case (title, url, desc) =>
        li(a(href := url)(title), s" - $desc")
      }
    )
  )

  val talksSection = Section(
    "Talks",
    div(
      """
      [Scala intro](https://sake.ba/presentations/2018-01-23%20Scala%20intro%20-%20OpenWeb%20Sarajevo),
      [Hepek](https://sake.ba/presentations/2018-08-28%20Hepek%20-%20OpenWeb%20Sarajevo),
      [FP intro](https://sake.ba/presentations/2018-09-08%20FP%20intro%20-%20freeCodeCamp%20Sarajevo),
      [Open Source](https://sake.ba/presentations/2018-10-27%20OpenSource%20-%20Hacktoberfest%20Sarajevo),
      [Writing an interpreter](https://sake.ba/presentations/2020-01-07%20Writing%20an%20interpreter%20-%20OpenWeb%20Sarajevo),
      [Project Amber](https://sake.ba/presentations/2020-09-09%20Amber%20-%20JUGBA)
      """.md
    )
  )

  val aboutSection = Section(
    "About",
    div(
      """
      [github](https://github.com/sake92),
      [stackoverflow](https://stackoverflow.com/users/4496364/insan-e),
      [twitter](https://twitter.com/sake_92),
      [linkedin](https://www.linkedin.com/in/sakib-hadziavdic),
      [email](https://www.youtube.com/watch?v=dQw4w9WgXcQ)
      """.md
    )
  )

}
