package hepek.lib

object WebJars {

  private val prismLanguages = Seq("markup", "css", "clike", "javascript", "bash",
    "c", "csharp", "cpp", "java", "markdown", "php",
    "powershell", "scala", "sql", "typescript", "yaml")

  object js {
    val prismjs = WebJarResource.jsMin("prismjs/components/prism-core")
    val prismjsLangs = prismLanguages.map(lang =>
      WebJarResource.jsMin(s"prismjs/components/prism-$lang"))
  }

  object css {
    val prismjs = WebJarResource.css("prismjs/themes/prism-twilight")
  }

}
