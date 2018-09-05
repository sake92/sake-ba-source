package site.posts.programiranje

import scalatags.Text.all._
import ba.sake.hepek.implicits._
import utils.Imports._

case class Term(name: String, explanation: Frag)

object ProgrammingGlossary extends templates.SakeBaBlogStaticPage {

  override def pageSettings = PageSettings("Glosarij")

  override def pageContent = row(
    div(cls := "well well-lg col-md-6 col-md-push-3 ")(
      terms.sortBy(_.name).map { t =>
        frag(h4(t.name), t.explanation, hr)
      }
    )
  )

  val terms: List[Term] = List(
    Term(
      "deklaracija",
      md("""
          Za liniju `int i;` kažemo da je **deklaracija** varijable `i`.  
          Njome uvodimo novo ime u našem programu, u ovom slučaju *varijablu*.  
          U suštini, samo kažemo da **postoji** ta varijabla.  
          Može se deklarisati i metoda, klasa, interfejs i sl.
        """)
    ),
    Term(
      "definicija",
      md("""
          Linija "i = 5;" je **definicija** varijable `i`.  
          Ovdje navodimo **šta ustvari jeste** ta varijabla (ili metoda, klasa, štagod).
        """)
    ),
    Term(
      "izjava",
      md("""
          Za razliku od izraza, izjave **nemaju vrijednost** (ili imaju beskorisnu vrijednost, npr. `Unit` u Scali).
          Npr. "i = 5;" i "System.out.println(i);" kažemo da su **izjave**.  
          Neke izjave koriste sintaksu *ugrađenu u sami jezik*, npr. dodjela vrijednosti (znak jednako: "=").  
          Ostale naredbe obično imaju naziv u *imperativnom* obliku: "print", "calculate", "uradiOvo"...  
          Zato se za Javu i slične jezike kaže da su **imperativni** jezici (jer preferiraju ovaj stil programiranja).
        """)
    ),
    Term(
      "izraz",
      md("""
          Svaki izraz ima **vrijednost**. Bio to broj, string ili neki objekat.  
          Npr. "2 + 2" je izraz. Naravno, svaki izraz možemo dodijeliti nekoj varijabli i sl.
        """)
    )
  )

}
