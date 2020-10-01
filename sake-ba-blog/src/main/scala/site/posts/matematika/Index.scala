package site.posts.matematika

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._, grid._, Image._

object Index extends MatematikaTemplate {

  override def pageSettings =
    super.pageSettings.withTitle("Matematika").withLabel("Početna")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2017, 6, 10))
      .withSections(matematikaUvodSection)

  def matematikaUvodSection = Section(
    "Uvod",
    frag(
      row(
        half(
          """
          Matematika je jedan od najomraženijih predmeta kod većine učenika.
          S pravom, dakako!  
          Zapitajmo se šta je uzrok tome?
          Da li je matematika zaista toliko teška, komplikovana?  
          Odgovor je jednostavan, naravno... da jeste. :D  
          Ako ne razumijemo osnovne koncepte kao što su skupovi i funkcije, kako nastaviti dalje?
          """.md
        ),
        half(
          image("https://i.imgur.com/UOhQzH5.gif", "Vako nekako")
        )
      ),
      row(
        """
        Šta profesori rade po tom pitanju?  
        Obično pišu knjige od po 1000+ stranica i nazivaju ih jednostavnim...  
        Po mom skromnom mišljenju, većina koncepata nije dovoljno dobro ili nikako objašnjena.
        Npr, meni nikad nisu objašnjavali šta znače razni simboli tipa ´\forall´, ´\exists´ i ´	\rightarrow´...  
        To se smatra elementarnim i krivica se prebacuje ili na prethodnog profesora ili
          pak na mene jer sam glup pa to ne znam.

        Zar je sramota pitati takva pitanja?  
        Hoćeš li ti biti manje profesor ako zastaneš 5 minuta i objasniš terminologiju?  
        Lema, korolar, teorema, šta su te stvari??? :D  
        Nauči me! To ti je pos'o!
        """.md
      )
    )
  )

}
