package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object Types extends JavaTemplate {

  override def pageTitle       = "Tipovi"
  override def pageDescription = Option("Tipovi, klase, interfejsi u Javi.")

  override def postCreateDate = Option(LocalDate.of(2018, 4, 5))
  override def postSections   = List(tipoviSection)

  def jshell = chl.batch.withPrompt("jshell>")

  def tipoviSection =
    Section(
      "Tipovi",
      div(
        md("""
          Većina ozbiljnih p.j. ima **tipove**. One koji nemaju slobodno izbjegavajte! ;)  
          Tip je apstrakcija koju dati p.j. razumije. Npr. kada napišemo `int broj`, 
            ovo "int" je tip varijable "broj".  
          Tako će kompjuter znati, između ostalog, *koliko memorije da rezerviše* za tu varijablu.  
          Pošto smo mu dali tu informaciju, onda nam može i ukazati na greške u programu koji pišemo. 
          Npr. da ne možemo sabirati broj i slovo, kruške i jabuke...  
          Također nas može i usmjeriti, npr. reći nam koje su operacije dostupne nad datim tipom, 
            da ne moramo nagađati.
          
          Da vidimo JShell u akciji:
       """),
        jshell.withOutputLines("2,4-10")(
          """
            int broj = 6;
            broj ==> 6
            broj = 5.5;
            |  Error:
            |  incompatible types: possible lossy conversion from double to int
            |  broj = 5.5;
            |         ^-^
          """
        ),
        md("""
          Dakle, Java nam **ne da** da dodijelimo broj `5.5` varijabli koja je tipa `int` (cijeli broj).  
          To ima smisla itekako, jer bismo izgubili ovo "zarez pet"... :)  
          Ako želimo da budemo pametniji od Jave, i da na silu "utrpamo" `5.5` u `int` to ide ovako:
        """),
        jshell.withOutputLines("2,4-10")(
          """
            broj = (int) 5.5;
            broj ==> 5
          """
        ),
        md(
          """
          I šta smo dobili? Samo cijeli dio... Ali, nekad nam ovo baš i treba!  
          Uglavnom, pouka je da trebamo slušati šta nam Java poručuje!  
          To radi za naše dobro, nju nije briga ako je rezultat netačan, ako je to što želimo... :D
          
          ---
          Naravno, imamo još puno toga reći o tipovima, tek smo "zagrebali površinu"!  
          Kako da grupišemo podatke? Npr. kompleksni brojevi, podaci o ljudima, proizvodima itd?  
          O tom ćemo pričati u poglavlju o klasama. :)
        """
        )
      )
    )
}
