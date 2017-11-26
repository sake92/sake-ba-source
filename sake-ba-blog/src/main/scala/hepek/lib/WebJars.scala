package hepek.lib

import hepek.Resources.lib._

object WebJars {

  private val prismLanguages = Seq("markup", "css", "clike", "javascript", "bash",
    "c", "csharp", "cpp", "java", "markdown", "php",
    "powershell", "scala", "sql", "typescript", "yaml")

  // not every plugin has CSS, so tuples (pluginName, hasCSS)
  private val prismExtensions: Seq[(String, Boolean)] = Seq(
    "line-numbers" -> true, "normalize-whitespace" -> false,
    "toolbar" -> true, "copy-to-clipboard" -> false
  )
  // TODO maybe use "JSONP Highlight" to fetch snippets from web sometimes

  object JS {
    val prismjs = jsMin("prismjs/components/prism-core")
    val prismjsLangs = prismLanguages.map(lang => jsMin(s"prismjs/components/prism-$lang"))
    val prismjsExts = prismExtensions.map { case (ext, _) => jsMin(s"prismjs/plugins/$ext/prism-$ext") }
  }

  object CSS {
    val prismjs = css("prismjs/themes/prism-twilight")
    val prismjsExts = prismExtensions.filter(_._2).map { case (ext, _) => css(s"prismjs/plugins/$ext/prism-$ext") }
  }

}
