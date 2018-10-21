package site

import scalatags.Text.all._
import ba.sake.hepek.implicits._
import ba.sake.hepek.html.component.BasicComponents

object Index extends templates.SakeBaPage with BasicComponents {

  override def pageSettings =
    PageSettings("Home")
      .withDescription(
        "sake.ba is personal website belonging to Sakib Hadžiavdić. " +
          "Tutorials from maths, programming etc."
      )

  override def pageContent = div(cls := "row")(
    div(cls := "col-md-6 col-md-offset-3")(
      h1(cls := "text-center")("Welcome!"),
      ul(cls := "nav nav-tabs nav-justified")(
        sections.zipWithIndex.map {
          case (s, i) =>
            val activeClass = if (i == 0) "active " else ""
            li(cls := activeClass)(
              a(data.toggle := "tab", href := "#" + s.id)(s.name)
            )
        }
      ),
      div(cls := "tab-content text-center")(
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
    List(resourcesSection, projectsSection, talksSection, aboutSection)

  private def tab = div()

  val resourcesSection = Section(
    "Resources",
    tab(
      row(
        span(cls := "glyphicon glyphicon-education"),
        hyperlink("https://blog.sake.ba")(" Tutorials")
      ),
      hr,
      row(
        span(cls := "glyphicon glyphicon-book"),
        hyperlink("https://github.com/sake92/notes")(
          " My notes and useful stuff"
        )
      )
    )
  )

  val projectsSection = Section(
    "Projects",
    tab(
      row(
        half1("Static site generator"),
        half2(hyperlink("https://github.com/sake92/hepek")("Hepek"))
      ),
      hr,
      row(
        half1("Sbt plugin for rendering files"),
        half2(hyperlink("https://github.com/sake92/sbt-hepek")("sbt-hepek"))
      ),
      hr,
      row(
        half1(
          "Assembler, VM, and a PL implementations from nand2tetris course"
        ),
        half2(hyperlink("https://github.com/sake92/nand2tetris")("nand2tetris"))
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
        )
      ).map {
          case (date, place, url, title) =>
            row(
              third1(date),
              third2(place),
              third3(hyperlink(url)(title))
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
        ("CV",
         hyperlink("https://sake.ba/files/Hadziavdic%20Sakib%20CV_en.pdf")(
           "view"
         )),
        ("job",
         frag(
           span("software engineer @ "),
           hyperlink("http://olivebh.com/", target := "_blank")("OliveBH")
         )),
        ("email", hyperlink("mailto:sakib@sake.ba")("sakib@sake.ba")),
        ("twitter",
         raw("""
                <a href="https://twitter.com/sake_92" class="twitter-follow-button" data-show-count="false">@sake_92</a>
                <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
              """)),
        ("stackoverflow",
         raw("""
                <a href="https://stackoverflow.com/users/4496364/insan-e">
                  <img src="https://stackoverflow.com/users/flair/4496364.png?theme=dark" width="208" height="58"
                    alt="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers"
                    title="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
                </a>
             """)),
      ).map {
          case (col1, col2) =>
            row(half1(col1), half2(col2))
        }
        .flatMap(List(hr, _)) // insert hr between each
        .tail
    )
  )

}
