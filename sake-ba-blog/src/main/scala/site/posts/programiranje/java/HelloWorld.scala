package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object HelloWorld extends JavaTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Poyy sviete!"
  override def pageDescription = Option(
    "Hello world program u Javi."
  )

  override def postCreateDate = Option(LocalDate.of(2018, 2, 4))
  override def postSections   = List(uvodSection, pokretanjeSection)

  val uvodSection = Section(
    "Poyy sviete!",
    div(
      p("""Da vidimo kako izgleda obavezni "Hello World" primjer:"""),
      chl.java(
        """
            package primjer;

            class PoyySvijeteApp {
                public static void main(String[] argumenti) {
                    System.out.println("Poyy sviete!");
                }
            }
        """
      ),
      p(
        "Kada se pokrene prethodno prikazani program dobićemo sljedeći rezultat u konzoli: ",
        chl.batch.inline("Poyy sviete!")
      )
    )
  )

  val pokretanjeSection = Section(
    "Pokretanje programa",
    div(
      md("""
        Sadržaj programa sačuvajte u fajl "PoyySvijeteApp.java".
        Primijetite da se **mora zvati isto kao i klasa**, s nastavkom "java"!  
        Ovaj fajl se **mora nalaziti u folderu** "primjer" jer je to "package" od naše klase!  
        Kod mene se ovo sve nalazi na C: particiji, u folderu "programiranje":
      """),
      chl.batch
        .withPrompt("PS C:\\programiranje>")
        .withOutputLines("2-4")("""
            PS C:\programiranje> tree /f
            C:.
            └───primjer
                    PoyySvijeteApp.class
                    PoyySvijeteApp.java
          """),
      md("""  
        Dakle, imamo otvoren CMD i nalazimo se u folderu "programiranje".  
        Kucamo sljedeće:
      """),
      chl.batch
        .withPrompt("PS C:\\programiranje>")
        .withOutputLines("3")(
          """
            javac .\primjer\PoyySvijeteApp.java
            java primjer.PoyySvijeteApp
            Poyy sviete!
          """
        ),
      md("""  
        To je to, sada možemo nastaviti dalje.  
        Svaki primjer koji budemo radili možete isprobati, nemojte mi slijepo vjerovati na riječ da fercera. :)
      """)
    )
  )

}
