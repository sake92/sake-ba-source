package site.posts.programiranje.scala

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._

object Uvod extends ScalaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Uvod u Scalu")
      .withLabel("Uvod")
      .withDescription("Uvod u Scala programski jezik.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 4, 23))
      .withSections(uvodSection)

  def uvodSection = Section(
    "Uvod",
    div(
      md("""
          Scala je prije svega **potpuno objektno orijentisan** jezik.  
          To znači da su **sve vrijednosti u programu objekti**, čak i brojevi i karakteri!  
          Ovo nije slučaj u Javi, gdje imamo 7 "primitivnih tipova" kao što su `int`, `char`, `boolean`...  
          U Scali su oni predstavljeni **klasama** `Int`, `Char`, `Boolean`...  
          U C# je sličan slučaj kao i u Scali, gdje je `int` samo alijas za `Int32`, ali je i dalje klasa.  
          Ovaj koncept se naziva i "unified types".

          Da pogledamo deklaraciju konstante:
       """),
      chl.scala("val x: Int = 5"),
      md("""
         Tip se piše **nakon naziva varijable**, kao u Pascalu.  
         U većini slučajeva kompajler nam može pomoći s "zaključivanjem tipa" (type inference).  
         Kompajler će "skontat" za nas da je to broj... Gdje ste bili do sada??? :/  
         Tako da je prethodni primjer ekvivalentan sljedećem:
      """),
      chl.scala("val x = 5"),
      md("""
         Primijetite i to da tačkazarez nije potrebna! Napokon!!!  
         Izgleda da su pisci kompajlera vrlo lijeni ljudi... :D  S razlogom, naravno.

         Ključna riječ `val` (skraćeno od value) označava **konstantu**, isto kao `final` u Javi:
      """),
      chl.java("""
        final int x = 5;
      """),
      md("""
          Naravno, sljedeći kod se neće iskompajlirati.  
          Dobićemo grešku "reassignment to val".
      """),
      chl.scala("""
        val x = 5
        x = 6
      """),
      md("""
          ---
          Da vidimo sada dobru staru varijablu, koja se deklariše s `var`, logično:
      """),
      chl.scala("""
        var y = 5
        y = 6
        y += 3
      """),
      md("""
          Varijabla `y` na kraju ima vrijednost `9`.

          ---
          U Scali imamo još jednu vrstu varijable, tzv. "lijena konstanta" (lazy value):
      """),
      chl.scala("""
        lazy val z = 5
      """),
      md("""
          Vrijednost lazy val će se izračunati samo jednom, i to tek kada se pozove u programu!  
          Npr. ako `z` poziva neku funkciju koja sadrži `println`, 
            ispisaće se na ekran tek kada pozovemo `z` (tj. evaluiraće se funkcija).  
          Ovaj koncept je iz FP, i vrlo je koristan za keširanje vrijednosti.
      """)
    )
  )

}
