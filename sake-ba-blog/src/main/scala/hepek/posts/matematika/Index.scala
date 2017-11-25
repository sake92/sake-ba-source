package hepek.posts.matematika

import java.time.LocalDate

import scalatags.Text.all._

import hepek.utils.html.HTMLUtils._
import hepek.templates.Section

object Index extends MatematikaTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Matematika"
  override def pageLabel = "Početna"

  override def dateCreated = LocalDate.of(2017, 6, 10)

  val matematikaUvodSectionContent =
    rowDiv(
      leftDiv(
        p(
          "Matematika je jedan od najomraženijih predmeta kod većine učenika. ",
          "S pravom, dakako! ", "Zapitajmo se šta je uzrok tome? ", "Da li je matematika zaista toliko teška, komplikovana? ",
          "Odgovor je jednostavan, naravno... da jeste. :D ", "Ako ne razumijemo osnovne koncepte kao što su skupovi i funkcije kako nastaviti dalje?"
        ),
        p(
          "Šta profesori rade po tom pitanju? ",
          "Obično pišu knjige od po 1000+ stranica i nazivaju ih jednostavnim. ",
          "Po mom skromnom mišljenju, većina koncepata nije dovoljno dobro ili nikako objašnjena. ",
          "Npr, meni nikad nisu objašnjavali šta znače razni simboli tipa `AA`, `EE` i `|->`... ",
          "To se smatra elementarnim i krivica se prebacuje ili na prethodnog profesora ili pak na mene jer sam glup pa to ne znam. "
        ),
        p(
          "Zar je sramota pitati takva pitanja? ",
          "Hoćeš li ti biti manje profesor ako zastaneš 5 minuta i objasniš terminologiju? ",
          "Lema, korolar, teorema, šta su te stvari??? :D ",
          "Nauči me! To ti je pos'o! "
        )
      ),
      rightDiv(
        image("http://i.imgur.com/UOhQzH5.gif", "Vako nekako")
      )
    )

  val matematikaUvodSection = Section("Uvod", matematikaUvodSectionContent)

  override def sections = Seq(matematikaUvodSection)

}
