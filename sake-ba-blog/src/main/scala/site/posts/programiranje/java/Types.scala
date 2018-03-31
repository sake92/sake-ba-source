package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object Types extends JavaTemplate {

  override def pageTitle       = "Tipovi"
  override def pageDescription = Option("Tipovi, klase, interfejsi u Javi.")

  // override def postCreateDate = Option(LocalDate.of(2018, 2, 4))
  override def postSections = List(tipoviSection)

  def tipoviSection =
    Section(
      "Tipovi",
      div(
        md("""
        Većina ozbiljnih p.j. ima **tipove**. One koji nemaju slobodno izbjegavajte! ;)  
        Tip je apstrakcija koju dati p.j. razumije. Npr. kada napišemo
      """),
        chl.java.inline("int broj"),
        md("""
        , ovo "int" je tip varijable "broj". 
        Tako će kompjuter znati, između ostalog, *koliko memorije da rezerviše* za tu varijablu.  
        Pošto smo mu dali tu informaciju, onda nam kompjuter može pomoći, ukazati nam na greške u programu koji pišemo. 
        Npr. da ne možemo sabirati broj i slovo...
        Također nas može i usmjeriti, npr. reći nam koje su operacije dostupne nad datim tipom, da ne moramo nagađati.

        Programski jezici sadrže apstrakcije za opisivanje komplikovanijih podataka, za tok programa itd.
        Npr. kada želimo opisati neki (apstraktni) automobil, većina jezika Vam nudi apstrakciju zvanu klasa (en. class):
       """),
        chl.java("""
              class Automobil {
                int godinaProizvodnje;
                string nazivModela;
              }
             """)
      )
    )
}
