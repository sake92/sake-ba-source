package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object Statements extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Naredbe")
      .withDescription(
        "Postupak downloada i instalacije Java platforme: JDK, JRE, javac, java."
      )

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 4, 27))
      .withSections(statementsSection)

  def jshell = chl.batch.withPrompt("jshell>")

  def statementsSection = Section(
    "Naredbe",
    div(
      md("""
          Naredbe (en. statements) su kao rečenice u govornom jeziku, 
            i obično su u imperativnom obliku, kao da se obraćamo kompjuteru:
            uradi ovo, izbriši ono, upiši u fajl itd.  
          Deklaracije varijabli su naredbe, npr. `int i = 5;`, može se čitati kao  
            "napravi varijablu s imenom 'i' i dodijeli joj vrijednost 5! ODMAH!".  
          Iako još nismo objasnili procedure, i one su također naredbe, npr:
        """),
      jshell.withOutputLines("2")("""
        System.out.println("Hello!")
        Hello!
      """),
      md("""
          Vrlo duga naredba `System.out.println` je procedura za printanje u konzolu 
            (ono gdje tipkamo naredbe, JShell ekran).  
          Do sada je JShell to automatski radio za nas, ispisivao vrijednost zadnjeg izraza,
            u svom nekom predefinisanom formatu...
          Ovako mi možemo ispisati šta god želimo. Primijetite da ispisani `String` nema navodnika!  
          Navodnici se samo **koriste za pisanje stringova**!!! Nisu uključeni u samu vrijednost stringa.  
          Isto je i sa karakterima.

          Da vidimo još par primjera:
        """),
      jshell.withOutputLines("2,3,5,7")("""
        System.out.println("x je " + 5);
        x je 5

        String rezultat = "x je " + 5;
        rezultat ==> "x je 5"
        System.out.println(rezultat);
        x je 5
      """),
      md("""
          Dakle, možemo proslijediti string direktno, ili varijablu koja je string, svejedno. :)  
          Kraj naredbe se označava s `;` (tačkazarez, en. semicolon).
        """),
    )
  )

}
