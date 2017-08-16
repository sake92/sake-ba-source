package hepek.templates

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import scalatags.Text.all._

import ba.sake.hepek.core.RelativePath

import hepek.lib.WebJars
import hepek.utils.HTMLUtils
import hepek.Site

trait BlogPost extends SakeBaBlogPage {

  def sections: Seq[Section]

  /** Every page will have a sidebar of pages rendered */
  def pages: Seq[BlogPost]

  def author: String

  def dateCreated: LocalDate

  val dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy")

  // I want highlighter only on tutorial pages
  override def additionalCSS = Seq(link(rel := "stylesheet", href := relTo(WebJars.css.prismjs)))

  // DISQUS COMMENTS STUFF
  val PAGE_URL = Site.url + "/" + hepek.Index.relTo(this).toString.replaceAll("""\\""", "/")
  val PAGE_IDENTIFIER = PAGE_URL.##.abs // hopefully unique enough... :D

  override def additionalJS = Seq(
    script(src := relTo(WebJars.js.prismjs)),
    WebJars.js.prismjsLangs.map(lang => script(src := relTo(lang))),

    //DISQUS_SCRIPT
    script(s"""
      var disqus_config = function () {
        this.page.url = '$PAGE_URL';
        this.page.identifier = $PAGE_IDENTIFIER;
      };
      
      (function() {
        var d = document, s = d.createElement('script');
        s.src = 'https://sake-ba.disqus.com/embed.js';
        s.setAttribute('data-timestamp', +new Date());
        (d.head || d.body).appendChild(s);
      })();
      """)
  )

  private def sidebar: Frag = {
    val pageLiTags = for {
      p <- pages
      activeClass = if (p.relPath == this.relPath) "active" else ""
    } yield li(cls := activeClass, a(href := relTo(p))(p.pageLabel))

    ul(cls := "nav nav-pills nav-stacked")( // TODO maybe anchor this on side?
      pageLiTags
    )
  }

  override def pageContent = frag(
    div(cls := "row")(
      div(cls := "page-header text-center")( // center title
        h1(this.pageTitle)
      )
    ),
    div(cls := "row")(
      div(cls := "col-lg-2 col-lg-push-1  col-md-3", paddingBottom := 23.px)(sidebar),
      div(cls := "col-lg-8 col-lg-push-1  col-md-9")(
        h6(
          span(cls := "glyphicon glyphicon-time"), " " + dateCreated.format(dateFormat) // date
        ),
        h6(
          span(cls := "glyphicon glyphicon-user"), " Autor: " + author // author
        ),
        tag("article")(
          HTMLUtils.renderTOCAndSections(sections) // start from h2
        ),
        div(id := "disqus_thread")
      )
    )
  )

}
