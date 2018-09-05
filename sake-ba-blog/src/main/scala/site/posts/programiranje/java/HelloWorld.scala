package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.images.Images
import hepek.utils.Imports._

object HelloWorld extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Poyy sviete!")
      .withDescription("Hello world program u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 2, 4))
      .withSections(introSection, commentsSection, compileAndRunSection)

  def introSection = Section(
    "Poyy sviete!",
    div(
      md("""
        Vjerovatno vam je do sada dodijao JShell i kucanje u konzoli... :D  
        Sada ćemo vidjeti kako se ustvari pokreću Java programi.  
        Sastoji se iz 2 dijela: kompajliranje i pokretanje (en. run).  
        Neki jezici su interpretirani, ne kompajliraju se nikako (Javascript, Ruby, Python).  

        ---
        Kompajler (en. compiler) je program koji provjerava sintaksu našeg programa,
          da li se poklapaju tipovi itd. te nam **prijavljuje greške** ako ih pronađe.  
        I to sve prije nego smo i pokrenuli naš program! Predobro! :D  
        Tako smo sigurni da se bar **neke greške neće pojaviti** u programu.  
        Javin kompajler se zove `javac` (skraćeno od Java compiler).  
        Ulaz su mu izvorni tekst programa koji smo napisali (`.java` fajlovi, obični tekstualni fajlovi),
          a izlaz su fajlovi koji sadrže kod koji se može pokrenuti (`.class` fajlovi).
      """),
      row(
        half1(
          md(
            """
            Idući korak je pokretanje programa.  
            Java programi se sastoje od `bytecode` naredbi (nezavisan od procesora i operativnog sistema),
              koje su vrlo slične mašinskom kodu (specifičnom za svaki procesor).  
            Izlaz iz kompajlera, `.class` fajlovi sadrže te `bytecode` naredbe,
              i njih izvršava tzv. JVM (Java Virtuelna Mašina).  
            Ona se pokreće kroz `java` program.
            """
          )
        ),
        half2(
          image(relTo(Images.java.compiler),
                "Kompajliranje i pokretanje Java programa")
        )
      ),
      md("""
        ---
        Da vidimo (napokon) kako izgleda obavezni "Hello World" primjer:
      """),
      chl.java(
        """
            package primjer;

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
        chl.batch.inline("Poyy sviete!")
      )
    )
  )

  def commentsSection = Section(
    "Komentari",
    div(
      md("""
        Komentari su tekst koji ne utiče na rezultat programa.  
        Koriste se samo radi objašnjavanja koda, nekom drugom ili nama kad budemo čitali kasnije.  
        Prva vrsta komentara se piše sa 2 kose crte `//` (en. slash) i pišemo **do kraja linije**.  
        Druga vrsta je višelinijska (en. multiline) i počinje s `/*` a završava s `*/`.
      """)
    )
  )

  def compileAndRunSection = Section(
    "Kompajliranje i pokretanje programa",
    div(
      md("""
        Sadržaj programa sačuvajte u fajl "PoyySvijeteApp.java".
        Primijetite da se **mora zvati isto kao i klasa**, s nastavkom "java"!  
        Ovaj fajl se **mora nalaziti u folderu** "primjer" jer je to "package" od naše klase!  
        Kod mene se ovo sve nalazi na C: particiji, u folderu "programiranje":
      """),
      chl.batch
        .withPrompt("PS C:\\programiranje>")
        .withOutputLines("2-10")("""
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
