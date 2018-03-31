package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object Functions extends JavaTemplate {

  override def pageTitle       = "Funkcije"
  override def pageDescription = Option("Funkcije, procedure, metode u Javi.")

  // override def postCreateDate = Option(LocalDate.of(2018, 2, 4))
  override def postSections = List(funkcijeSection)

  def funkcijeSection = Section(
    "Funkcije, procedure, metode",
    div(
      md("""
          Potprogrami (en. subroutine) su **dijelovi programa** koje možemo pozvati po **imenu**.  
          Zavisno od jezika, negdje ih zovu *funkcije* (ako imaju rezultat), *procedure* (ako nemaju rezultat), a negdje samo *metode*.  
          Ali u suštini to su sve potprogrami...  

          Moguće je proslijediti **argumente**/parametre koje potprogram može koristiti/izmijeniti.

          Ovo je primjer funkcije u p.j. Javascript:
        """),
      chl.javascript("""
            function suma(broj1, broj2) {
                return broj1 + broj2;
            }
        """)
    )
  )

}
