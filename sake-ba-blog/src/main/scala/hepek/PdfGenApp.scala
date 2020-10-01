package hepek

import java.io.File
import ba.sake.hepek.core.Renderable
import ba.sake.hepek.html.statik.BlogPostPage
import ba.sake.hepek.pdf._

object PdfGenApp {

  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println(
        "You must pass the targetFolder value (base folder for generated pages)..."
      )
    }
    val targetFolder = args(0)

    System
      .setProperty(
        "webdriver.chrome.driver",
        "C:/hepek/chromedriver_win32/chromedriver_79.exe"
      )

    val fonts = List(
      Font(new File("fonts/Roboto/Roboto-Regular.ttf"), "Roboto"),
      Font(new File("fonts/KaTeX_Main/KaTeX_Main-Regular.ttf"), "KaTeX_Main")
    )

    val pdfs: List[(String, List[Renderable])] = List(
      site.posts.programiranje.java.Index,
      site.posts.programiranje.scala.Index,
      site.posts.matematika.Index
    ).map(p => p.pageCategory.get -> p.categoryPosts)

    println("Rendering PDFs...")
    for ((fileName, pages) <- pdfs) {
      val file = new File(s"$targetFolder/site/pdfs/$fileName.pdf")
      PdfGenerator.generate(file, targetFolder, pages, fonts)
    }

  }
}
