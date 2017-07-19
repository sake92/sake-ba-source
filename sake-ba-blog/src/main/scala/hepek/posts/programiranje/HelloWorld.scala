package hepek.posts.programiranje

import java.time.LocalDate

import scalatags.Text.all._

import hepek.templates.Section
import hepek.utils.HTMLUtils._

object HelloWorld extends ProgramiranjeTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Hello world!"

  override def dateCreated = LocalDate.now()

  val uvodSectionContent =
    div(
      p("""Da vidimo kako izgleda obavezujući "Hello World!" primjer:"""),
      javaSnippet(
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
        shellSnippet("Vozdra svijete!")
      ),
      p(
        "Kako se ustvari pokreće program pokazaćemo kasnije!", br,
        "Prvo moramo objasniti par stvari u vezi Jave:",
        ul(
          li("")
        )
      )
    )

  val pokretanjeSectionContent =
    div(
      """
        
        javac ba\sake\Main.java

Sake@DESKTOP-G5KJR68 C:\Java\TEST

> java ba.sake.Main
        """
    )

  val uvodSection = Section("Hello world!", uvodSectionContent)

  override def sections = Seq(uvodSection)

}
