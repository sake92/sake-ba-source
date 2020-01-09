package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._, grid._, Image._
import images.Images

object HelloWorld extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Poyy sviete!")
      .withDescription("Hello world program u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 2, 4))
      .withSections(introSection, compileAndRunSection, commentsSection)

  def introSection = Section(
    "Poyy sviete!",
    div(
      """
        Vjerovatno vam je do sada dodijao JShell i kucanje u konzoli... :D  
        Sada ćemo vidjeti kako se ustvari pokreću Java programi.  
        Sastoji se iz 2 dijela: kompajliranje i pokretanje (en. run).  

        ---
        Kompajler (en. compiler) je program koji provjerava sintaksu našeg programa,
          da li se poklapaju tipovi itd. te nam **prijavljuje greške** ako ih pronađe.  
        I to sve prije nego smo i pokrenuli naš program! Predobro! :D  
        Tako smo sigurni da se bar **neke greške neće pojaviti** u programu.  
        Javin kompajler se zove `javac` (skraćeno od Java compiler).  
        
        Ulaz u kompajler je izvorni tekst programa (en. source code) 
          koji smo napisali (obični tekstualni fajlovi s nastavkom `.java` ),
          a izlaz  su fajlovi koji sadrže izvršni kod, koji se može pokrenuti nekako, izvršiti (`.class` fajlovi).
      """.md,
      row(
        half(
          """
            Idući korak je pokretanje programa.  
            Java programi se sastoje od `bytecode` naredbi (kod nezavisan od procesora i operativnog sistema),
              koje su vrlo slične mašinskom kodu (specifičnom za svaki procesor).  
            Izlaz iz kompajlera, `.class` fajlovi sadrže te `bytecode` naredbe,
              i njih izvršava tzv. JVM (Java Virtuelna Mašina).  
            JVM je ustvari `java` program.
            """.md
        ),
        half(
          image(
            Images.java.compiler.ref,
            "Kompajliranje i pokretanje Java programa"
          )
        )
      ),
      """
        ---
        Da vidimo napokon kako izgleda obavezni "Hello World" primjer:
      """.md,
      chl.java(
        """
            // komentar1
            
            /*
             * komentar2
             */
             
            class PoyySvijeteApp {
                public static void main(String[] argumenti) {
                    String poruka = "Poyy sviete!";
                    System.out.println(poruka);
                }
            }
        """
      ),
      p(
        "Kada se pokrene prethodno prikazani program dobićemo sljedeći rezultat u konzoli: ",
        br,
        chl.batch.inline("Poyy sviete!")
      )
    )
  )

  def commentsSection = Section(
    "Komentari",
    """
        Komentari su tekst koji ne utiče na rezultat programa.  
        Koriste se samo radi objašnjavanja koda, nekom drugom ili nama kad budemo čitali kasnije.  
        Prva vrsta komentara se piše sa 2 kose crte `//` (en. slash) i vrijedi **do kraja linije**.  
        Druga vrsta je višelinijska (en. multiline) i počinje s `/*` a završava s `*/`.
      """.md
  )

  def compileAndRunSection = Section(
    "Kompajliranje i pokretanje programa",
    div(
      """
        Sadržaj programa sačuvajte u fajl `PoyySvijeteApp.java`.
        Primijetite da se **mora zvati isto kao i klasa**, s nastavkom `.java`!  
        Kod mene se ovo sve nalazi u folderu `C:\programiranje`.  
        Kucamo sljedeće:
      """.md,
      chl.batch
        .withPrompt("C:\\programiranje>")
        .withOutputLines("3")(
          """
            javac PoyySvijeteApp.java
            java PoyySvijeteApp
            Poyy sviete!
          """
        ),
      """
        To je to, sada možemo nastaviti dalje.  
        Svaki primjer koji budemo radili možete isprobati, nemojte mi slijepo vjerovati na riječ da fercera. :)
      """.md
    )
  )

}
