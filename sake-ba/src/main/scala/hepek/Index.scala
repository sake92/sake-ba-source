package hepek

import scalatags.Text.all._
import ba.sake.hepek.bootstrap3.component.AllBootstrapComponents._
import ba.sake.hepek.html.structure.blog.Section
import hepek.templates.SakeBaPage

object Index extends SakeBaPage {

  override def pageTitle = "Početna stranica"
  override def pageDescription = Option(
    "sake.ba je web stranica fizičke osobe pod imenom Sakib Hadžiavdić. " +
      "Tutorijali iz programiranja, matematike i slično."
  )

  override def pageContent = frag(
    div(cls := "jumbotron text-center")(
      h1("Dobrodošli!"),
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

  def sections: Seq[Section] = Seq(whatSection, aboutSection)

  def aboutSection = Section(
    "O meni",
    table(cls := "table table-striped table-hover")(
      tr(
        td("ime i prezime"),
        td(strong("Sakib Hadžiavdić")),
      ),
      tr(
        td("email"),
        td(hyperlink("mailto:sakib@sake.ba")(" sakib@sake.ba"))
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
      )
    )
  )

  def whatSection = Section(
    "Sadržaj",
    table(cls := "table table-striped table-hover")(
      tr(
        td(
          span(cls := "glyphicon glyphicon-education"),
          " ",
          hyperlink("https://blog.sake.ba")("Tutorijali")
        )
      ),
      tr(
        td(
          span(cls := "glyphicon glyphicon-blackboard"),
          " ",
          // TODO
          //hyperlink("https://sake.ba/presentations")("Prezentacije")
          hyperlink("#")("Prezentacije")
        )
      ),
      tr(
        td(
          span(cls := "glyphicon glyphicon-registration-mark"),
          " ",
          //hyperlink("https://sake.ba/projects")("Projekti")
          hyperlink("#")("Projekti")
        )
      )
    )
  )

}
