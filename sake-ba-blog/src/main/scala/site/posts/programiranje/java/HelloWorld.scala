package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object HelloWorld extends JavaTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Hello world!"
  override def pageDescription = Option(
    "Hello world program u Javi."
  )

  override def postSections = List(uvodSection)

  def uvodSection = Section("Hello world!", uvodSectionContent)

  def uvodSectionContent =
    div(
      p("""Da vidimo kako izgleda obavezni "Hello World!" primjer:"""),
      chl.java(
        """         
            class VozdraSvijeteAplikacija {
                public static void main(String[] argumenti) {       
                    System.out.println("Vozdra svijete!");      
                }
            }
        """
      ),
      p(
        "Kada se pokrene prethodno prikazani program dobićemo sljedeći rezultat u konzoli: ",
        chl.batch.inline("Vozdra svijete!")
      ),
      p(
        "Kako se ustvari pokreće program pokazaćemo kasnije!",
        br,
        "Prvo moramo objasniti par stvari u vezi Jave:",
        ul(
          li("")
        )
      )
    )

  def pokretanjeSectionContent =
    div(
      """
        
        javac ba\sake\Main.java

Sake@DESKTOP-G5KJR68 C:\Java\TEST

> java ba.sake.Main
        """
    )

}
