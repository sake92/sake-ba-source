package site.posts.programiranje

import ba.sake.hepek.prismjs
import ba.sake.hepek.prismjs.{PrismDependencies, Themes}
import ba.sake.hepek.mermaid.MermaidDependencies
import templates.SakeBaBlogPage
import ba.sake.hepek.mermaid.MermaidHelpers
import ba.sake.hepek.mermaid.MermaidConfig

trait CodeTemplate
    extends SakeBaBlogPage
    with PrismDependencies
    with MermaidDependencies
    with MermaidHelpers {

  private val hlLangs = List(
    "core",
    "c",
    "clike",
    "batch",
    "scala",
    "java",
    "markup",
    "markup-templating"
  )

  override def prismSettings =
    super.prismSettings
      .withTheme(Themes.Twilight)
      .withLanguages(prismjs.PrismConsts.languages filter hlLangs.contains)

  override def mermaidConfig =
    super.mermaidConfig
      .withTheme("forest")
      .withFlowchart(super.mermaidConfig.flowchart.withCurve("basis"))

  override def scriptsInline =
    super.scriptsInline :+
      """
      $(function(){
        setTimeout(function(){
          document.querySelectorAll("svg[id^='mermaid']").forEach(s => 
            s.setAttribute('width', '100%')
          )
        }, 3000);
      });
      """
}
