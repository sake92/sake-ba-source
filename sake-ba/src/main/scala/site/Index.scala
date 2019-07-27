package site

import scalatags.Text.all._
import ba.sake.hepek.Resources.images
import utils.Imports._
import classes._

object Index extends templates.SakeBaPage {

  override def pageSettings =
    super.pageSettings
      .withTitle("Home")
      .withDescription(
        "sake.ba is personal website belonging to Sakib Hadžiavdić. " +
          "Tutorials from maths, programming etc."
      )

  override def pageContent = div(cls := "row")(
    div(cls := "col-md-6 col-md-offset-3")(
      h1(txtAlignCenter)("Welcome!"),
      ul(cls := "nav nav-tabs nav-justified")(
        sections.zipWithIndex.map {
          case (s, i) =>
            val activeClass = if (i == 0) "active " else ""
            li(cls := activeClass)(
              a(data.toggle := "tab", href := "#" + s.id)(s.name)
            )
        }
      ),
      div(cls := "tab-content", txtAlignCenter)(
        sections.zipWithIndex.map {
          case (s, i) =>
            val activeClass = if (i == 0) "in active " else ""
            div(id := s.id, cls := s"tab-pane fade $activeClass")(
              s.content
            )
        }
      )
    )
  )

  def sections =
    List(aboutSection, resourcesSection, projectsSection, talksSection)

  private def tab = div()

  val resourcesSection = Section(
    "Resources",
    tab(
      row(
        span(cls := "glyphicon glyphicon-education"),
        hyperlink("https://blog.sake.ba")(" Tutorials in Bosnian")
      ),
      hr,
      row(
        span(cls := "glyphicon glyphicon-book"),
        hyperlink("https://github.com/sake92/notes")(
          " Notes, links and stuff"
        )
      )
    )
  )

  val projectsSection = Section(
    "Projects",
    tab(
      row(
        half("Static site generator"),
        half(hyperlink("https://github.com/sake92/hepek")("Hepek"))
      ),
      hr,
      row(
        half("Sbt plugin for rendering files"),
        half(hyperlink("https://github.com/sake92/sbt-hepek")("sbt-hepek"))
      ),
      hr,
      row(
        half(
          "Assembler, VM, and a PL implementations from nand2tetris course"
        ),
        half(hyperlink("https://github.com/sake92/nand2tetris")("nand2tetris"))
      ),
      hr,
      row(
        raw("""
              <iframe src="https://githubbadge.appspot.com/sake92"
                style="border: 0;height: 142px;width: 200px;overflow: hidden;" frameBorder="0">
              </iframe>
            """)
      )
    )
  )

  val talksSection = Section(
    "Talks",
    tab(
      List(
        (
          "23.01.2018",
          "OpenWeb Sarajevo",
          "https://sake.ba/presentations/2018-01-23%20Scala%20intro%20-%20OpenWeb%20Sarajevo",
          "Scala intro"
        ),
        (
          "20.08.2018",
          "OpenWeb Sarajevo",
          "https://sake.ba/presentations/2018-08-28%20Hepek%20-%20OpenWeb%20Sarajevo",
          "Hepek"
        ),
        (
          "08.09.2018",
          "freeCodeCamp Sarajevo",
          "https://sake.ba/presentations/2018-09-08%20FP%20intro%20-%20freeCodeCamp%20Sarajevo",
          "FP intro"
        ),
        (
          "27.10.2018",
          "Hacktoberfest Sarajevo",
          "https://sake.ba/presentations/2018-10-27%20OpenSource%20-%20Hacktoberfest%20Sarajevo",
          "Open Source"
        )
      ).map {
          case (date, place, url, title) =>
            row(
              third(date),
              third(place),
              third(hyperlink(url)(title))
            )
        }
        .flatMap(List(hr, _)) // insert hr between each
        .tail
    )
  )

  val aboutSection = Section(
    "About",
    tab(
      List[(Frag, Frag)](
        ("name", "Sakib Hadžiavdić"),
        (
          "CV",
          hyperlink("https://sake.ba/files/Hadziavdic%20Sakib%20CV_en.pdf")(
            "here"
          )
        ),
        (
          "job",
          frag(
            span("dev @ "),
            hyperlink("https://bpuholdings.com", target := "_blank")("BPU")
          )
        ),
        ("email", hyperlink("mailto:sakib@sake.ba")("sakib@sake.ba")),
        (
          "twitter",
          hyperlink("https://twitter.com/sake_92")(
            img(
              src := images.png("twitter-follow-button").ref,
              height := "58px"
            )
          )
        ),
        (
          "stackoverflow",
          raw("""
                <a href="https://stackoverflow.com/users/4496364/insan-e">
                  <img src="https://stackoverflow.com/users/flair/4496364.png?theme=dark" width="208" height="58"
                    alt="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers"
                    title="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
                </a>
             """)
        ),
        (
          "certificates",
          hyperlink(
            "https://www.youracclaim.com/badges/f1319384-958c-4f40-b26e-4720d3bae7db/public_url"
          )(
            img(src := images.jpg("OCA-Java-SE-1").ref, height := "58px")
          )
        )
      ).map {
          case (col1, col2) =>
            row(half(col1), half(col2))
        }
        .flatMap(List(hr, _)) // insert hr between each
        .tail
    )
  )

}
