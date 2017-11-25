package hepek.lib

import hepek.Resources.lib._

object WebJars {

  private val prismLanguages = Seq("markup", "css", "clike", "javascript", "bash",
    "c", "csharp", "cpp", "java", "markdown", "php",
    "powershell", "scala", "sql", "typescript", "yaml")

  object JS {
    val prismjs = jsMin("prismjs/components/prism-core")
    val prismjsLangs = prismLanguages.map(lang =>
      jsMin(s"prismjs/components/prism-$lang"))
  }

  object CSS {
    val prismjs = css("prismjs/themes/prism-twilight")
  }

}
