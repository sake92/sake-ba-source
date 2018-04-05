package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object Functions extends JavaTemplate {

  override def pageTitle       = "Funkcije"
  override def pageDescription = Option("Funkcije u Javi.")

  override def postCreateDate = Option(LocalDate.of(2018, 4, 5))
  override def postSections   = List(funkcijeSection)

  def jshell = chl.batch.withPrompt("jshell>")

  def funkcijeSection = Section(
    "Funkcije",
    div(
      md("""
          Potprogrami (en. subroutine) su **dijelovi programa** koje možemo pozvati po **imenu**.  
          Zavisno od jezika, negdje ih zovu *funkcije* (ako imaju rezultat), *procedure* (ako nemaju rezultat), a negdje samo *metode*.  
          Ali u suštini to su sve potprogrami...  

          Moguće je proslijediti **argumente** koje funkcija može koristiti.

          Ovo je primjer funkcije za sabiranje dva cijela broja:
        """),
      chl.java("""
        int suma(int a, int b) {
            return a + b;
        }
      """),
      md("""
          Definicija funkcije ima sljedeće dijelove:
          - tip onog što **vraća funkcija**. 
          Kod nas je to `int`, jer je rezultat sabiranja dva `int`a također `int`.  
          - naziv funkcije, kod nas je to "suma".
          - lista parametara u zagradama, ovdje su to brojevi `a` i `b`: `int a, int b`.  
          Ako nema parametara onda idu samo zagrade, npr, `mojaFunkcija()`
          - tijelo funkcije u vitičastim zagradama
          - ključna riječ `return` i **rezultat** funkcije.

          Da vidimo u JShellu kako da deklarišemo i pozovemo prethodnu funkciju:
        """),
      jshell.withOutputLines("4,6")("""
        int suma(int a, int b) {
          ...>     return a + b;
          ...> }
        |  created method suma(int,int)
        suma(1, 4)
        $6 ==> 5
      """),
      md("""
        Funkcija se poziva navođenjem njenog imena, i parametara unutar zagrada. Npr. `suma(1, 4)`.  
        Pošto poziv funkcije vraća vrijednost `int`, možemo je spasiti u varijablu,
          npr. `int rezultat = suma(1, 4)`.  
        Dakle, i poziv funkcije je izraz! Čim ga možemo dodijeliti varijabli. :)
      """)
    )
  )

}
