package hepek

import java.io.File
import ba.sake.hepek.core.Renderable
import ba.sake.hepek.html.structure.blog.BlogPostPage
import ba.sake.hepek.pdf._

object PdfGenApp {

  def main(args: Array[String]): Unit = {
    if (args.length < 1) {
      println(
        "You must pass the targetFolder value (base folder for generated pages)..."
      )
    }
    val targetFolder = args(0)

    System
      .setProperty("webdriver.chrome.driver", "C:/selenium/chromedriver.exe")

    val fonts = List(
      Font(new File("fonts/Roboto/Roboto-Regular.ttf"), "Roboto")
    )

    val pdfs: List[(String, List[Renderable])] = List(
      site.posts.programiranje.java.Index,
      site.posts.programiranje.scala.Index,
      site.posts.matematika.Index
    ).map(p => p.pageSettings.category.get -> p.categoryPosts)

    println("Rendering PDFs...")
    for ((fileName, pages) <- pdfs) {
      val file = new File(s"$targetFolder/site/pdfs/$fileName.pdf")
      PdfGenerator.generate(file, targetFolder, pages, fonts)
    }

  }
}
