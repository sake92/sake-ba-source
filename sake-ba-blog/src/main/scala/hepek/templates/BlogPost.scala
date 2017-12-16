package hepek.templates

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import scalatags.Text.all._

import ba.sake.hepek.core.RelativePath

import hepek.lib.WebJars
import hepek.utils.html.SectionUtils
import hepek.utils.html.HTMLUtils.rowDiv
import hepek.Site

trait BlogPost extends SakeBaBlogPage {

  /** Sections of post. Sub-chapters   */
  def sections: Seq[Section]

  /** Every post has a sidebar of related pages */
  def pages: Seq[BlogPost]

  def author: String = "Sakib Hadžiavdić"

  def dateCreated: LocalDate = LocalDate.now()

  override def additionalCSS = Seq(
    link(rel := "stylesheet", href := relTo(WebJars.CSS.prismjs)),
    WebJars.CSS.prismjsExts.map(ext =>
      link(rel := "stylesheet", href := relTo(ext)))
  )

  // DISQUS COMMENTS STUFF
  val PAGE_URL = Site.url + "/" + hepek.Index
    .relTo(this)
    .toString
    .replaceAll("""\\""", "/")
  val PAGE_IDENTIFIER = PAGE_URL.##.abs // hopefully unique enough... :D

  override def additionalJS = Seq(
    // clipboard.js for copying code
    script(
      src := "https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/1.7.1/clipboard.min.js"),
    // prismjs
    script(src := relTo(WebJars.JS.prismjs)),
    WebJars.JS.prismjsLangs.map(lang => script(src := relTo(lang))),
    WebJars.JS.prismjsExts.map(ext => script(src := relTo(ext))),
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
      activeClass = if (p.relPath == relPath) "active" else ""
    } yield li(cls := activeClass, a(href := relTo(p))(p.pageLabel))

    ul(cls := "nav nav-pills nav-stacked")(
      pageLiTags
    )
  }

  private val dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy")

  override def pageContent = frag(
    rowDiv(
      div(cls := "page-header text-center")(
        h1(pageTitle)
      )
    ),
    rowDiv(
      div(cls := "col-lg-2 col-lg-push-1  col-md-3")(sidebar),
      div(cls := "col-lg-8 col-lg-push-1  col-md-9")(
        h6(
          span(cls := "glyphicon glyphicon-time"),
          " " + dateCreated.format(dateFormat)
        ),
        h6(
          span(cls := "glyphicon glyphicon-user"),
          " Autor: " + author
        ),
        tag("article")(
          SectionUtils.renderTOCAndSections(sections) // start from h2
        ),
        div(id := "disqus_thread")
      )
    )
  )

}
