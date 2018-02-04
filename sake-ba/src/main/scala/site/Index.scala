package site

import scalatags.Text.all._
import ba.sake.hepek.bootstrap3.component.BootstrapBasicComponents._
import ba.sake.hepek.bootstrap3.component.BootstrapGridComponents
import ba.sake.hepek.html.structure.blog.Section
import templates.SakeBaPage

object Index extends SakeBaPage with BootstrapGridComponents {

  override def pageTitle = "Početna stranica"
  override def pageDescription = Option(
    "sake.ba je web stranica fizičke osobe pod imenom Sakib Hadžiavdić. " +
      "Tutorijali iz programiranja, matematike i slično."
  )

  override def smRatios = None
  override def xsRatios = None

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
        " ",
        hyperlink("https://blog.sake.ba")("Tutorials")
      ),
      hr,
      row(
        span(cls := "glyphicon glyphicon-book"),
        " ",
        hyperlink("https://github.com/sake92/Reads")("Recommended readings")
      )
    )
  )

  val projectsSection = Section(
    "Projects",
    tab(
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
      row(
        third1("23.01.2018"),
        third2("OpenWeb Sarajevo"),
        third3(
          hyperlink(
            "https://sake.ba/presentations/2018-01-23%20Scala%20intro%20-%20OpenWeb%20Sarajevo"
          )("Scala intro")
        )
      )
    )
  )

  val aboutSection = Section(
    "About",
    tab(
      row(
        half1("name"),
        half2("Sakib Hadžiavdić")
      ),
      hr,
      row(
        half1("CV"),
        half2(
          hyperlink("https://sake.ba/files/Hadziavdic%20Sakib%20CV_en.pdf")(
            "view"
          )
        )
      ),
      hr,
      row(
        half1("job"),
        half2(
          span("software dev @ "),
          hyperlink("http://olivebh.com/", true)("OliveBH")
        )
      ),
      hr,
      row(
        half1("email"),
        half2(hyperlink("mailto:sakib@sake.ba")("sakib@sake.ba"))
      ),
      hr,
      row(
        half1("twitter"),
        half2(
          raw("""
                <a href="https://twitter.com/sake_92" class="twitter-follow-button" data-show-count="false">@sake_92</a>
                <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
              """)
        )
      ),
      hr,
      row(
        half1("stackoverflow"),
        half2(
          raw("""
                <a href="https://stackoverflow.com/users/4496364/insan-e">
                  <img src="https://stackoverflow.com/users/flair/4496364.png?theme=dark" width="208" height="58" 
                    alt="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers" 
                    title="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
                </a>
             """)
        )
      )
    )
  )

}
