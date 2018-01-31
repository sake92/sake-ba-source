package site

import scalatags.Text.all._
import ba.sake.hepek.bootstrap3.component.AllBootstrapComponents._
import ba.sake.hepek.html.structure.blog.Section
import templates.SakeBaPage

object Index extends SakeBaPage {

  override def pageTitle = "Početna stranica"
  override def pageDescription = Option(
    "sake.ba je web stranica fizičke osobe pod imenom Sakib Hadžiavdić. " +
      "Tutorijali iz programiranja, matematike i slično."
  )

  override def pageContent = frag(
    div(cls := "jumbotron text-center")(
      h1("Welcome!"),
      row(
        third1(),
        third2(
          ul(cls := "nav nav-tabs")(
            sections.zipWithIndex.map {
              case (s, i) =>
                val activeClass = if (i == 0) "active " else ""
                li(cls := activeClass)(
                  a(data.toggle := "tab", href := "#" + s.id)(s.name)
                )
            }
          ),
          div(cls := "tab-content")(
            sections.zipWithIndex.map {
              case (s, i) =>
                val activeClass = if (i == 0) "in active " else ""
                div(id := s.id, cls := s"tab-pane fade $activeClass")(
                  s.content
                )
            }
          )
        ),
        third3()
      ),
    )
  )

  def sections =
    List(resourcesSection, projectsSection, talksSection, aboutSection)

  val resourcesSection = Section(
    "Resources",
    table(cls := "table table-striped table-hover")(
      tr(
        td(
          span(cls := "glyphicon glyphicon-education"),
          " ",
          hyperlink("https://blog.sake.ba")("Tutorials")
        )
      ),
      tr(
        td(
          span(cls := "glyphicon glyphicon-book"),
          " ",
          hyperlink("https://github.com/sake92/Reads")(
            "Recommended readings"
          )
        )
      )
    )
  )

  val projectsSection = Section(
    "Projects",
    table(cls := "table table-striped table-hover")(
      tr(
        td("Sbt plugin for rendering files"),
        td(
          hyperlink("https://github.com/sake92/sbt-hepek")("sbt-hepek")
        )
      ),
      tr(
        td("Assembler, VM, and a PL implementations from nand2tetris course"),
        td(
          hyperlink("https://github.com/sake92/nand2tetris")("nand2tetris")
        )
      ),
      tr(
        td(colspan := "2")(
          raw("""
                <iframe src="http://githubbadge.appspot.com/sake92" 
                  style="border: 0;height: 142px;width: 200px;overflow: hidden;" frameBorder="0">
                </iframe>
              """)
        )
      )
    )
  )

  val talksSection = Section(
    "Talks",
    table(cls := "table table-striped table-hover")(
      tr(
        td("23.01.2018"),
        td("Scala intro"),
        td(
          hyperlink(
            "https://sake.ba/presentations/2018-01-23%20Scala%20intro%20-%20OpenWeb%20Sarajevo"
          )("OpenWeb Sarajevo")
        )
      )
    )
  )

  val aboutSection = Section(
    "About",
    table(cls := "table table-striped table-hover")(
      tr(
        td("name"),
        td(strong("Sakib Hadžiavdić")),
      ),
      tr(
        td("email"),
        td(hyperlink("mailto:sakib@sake.ba")("sakib@sake.ba"))
      ),
      tr(
        td("twitter"),
        td(
          raw("""
                <a href="https://twitter.com/sake_92" class="twitter-follow-button" data-show-count="false">@sake_92</a>
                <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
              """)
        )
      ),
      tr(
        td("stackoverflow"),
        td(
          raw("""
                <a href="https://stackoverflow.com/users/4496364/insan-e">
                  <img src="https://stackoverflow.com/users/flair/4496364.png?theme=dark" width="208" height="58" 
                    alt="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers" 
                    title="profile for insan-e at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
                </a>
             """)
        )
      ),
      tr(
        td("job"),
        td(
          span("software dev @ "),
          hyperlink("http://olivebh.com/", true)("OliveBH")
        )
      )
    )
  )

}
