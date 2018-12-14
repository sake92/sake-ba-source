package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.implicits._
import utils.Imports._

object Functions extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Funkcije")
      .withDescription("Funkcije u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 4, 5))
      .withSections(funkcijeSection)

  def funkcijeSection = Section(
    "Funkcije",
    div(
      """
        Prvo malo terminologije:
        
        Potprogram (en. subprogram, subroutine) je **dio programa** koji možemo pozvati po **imenu**.  
        U nekim jezicima pravi se razlika između *funkcije* (potprogram koji ima rezultat), 
          i *procedure* (nema rezultat).  
        Java ih zove... khm... **metode**... :D  
        Ja ću najčešće koristiti termin "funkcija" ili "metoda", kako kad.

        Funkcijama se mogu proslijediti **argumenti**, tj. ulazni podaci koje funkcija može koristiti.

        Slijedi primjer funkcije za sabiranje dva cijela broja:
      """.md,
      chl.java("""
        int suma(int a, int b) {
            return a + b;
        }
      """),
      md("""
          Definicija funkcije ima sljedeće dijelove:
          - tip vrijednosti koju **vraća funkcija**. 
          Kod nas je to `int`, jer je rezultat sabiranja dva `int`a također `int`.  
          - naziv funkcije, kod nas je to "suma"
          - lista parametara u zagradama, ovdje su to brojevi `a` i `b`: `int a, int b`.  
          Ako nema parametara onda idu samo zagrade, npr. `mojaFunkcija()`
          - tijelo funkcije u vitičastim zagradama
          - ključna riječ `return` i **rezultat** funkcije

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
        Funkcija se poziva navođenjem njenog imena, i parametara unutar zagrada.  
        Npr. `suma(1, 4)`.  
        Pošto poziv funkcije vraća vrijednost `int`, možemo je spasiti u varijablu,  
          npr. `int rezultat = suma(1, 4)`.  
        Dakle, i poziv funkcije je izraz! Čim ga možemo dodijeliti varijabli. :)
      """)
    )
  )

}
