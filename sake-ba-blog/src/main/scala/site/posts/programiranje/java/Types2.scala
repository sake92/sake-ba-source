package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._

object Types2 extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Tipovi, opet")
      .withDescription("Primitivni i referentni tipovi u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2019, 7, 14))
      .withSections(tipoviSection)

  def tipoviSection =
    Section(
      "Tipovi, opet",
      div(
        """      
        Rekli smo da ćemo nastaviti malo detaljnije o tipovima. :)  
        Java ima 2 vrste tipova: primitivne i referentne.  
        """.md
      ),
      List(primitivniTipoviSection, referentniTipoviSection)
    )

  def primitivniTipoviSection =
    Section(
      "Primitivni tipovi",
      div(
        """
        Primitivnih tipova ima 8 i to su  `boolean`, `char`, `int`, `long`, `short`, `byte`, `double` i `float`.  
        Pišu se **malim slovima**. Ne možemo definisati nove primitivne tipove u Javi!

        Primitivni tipovi predstavljaju "sirove podatke", većina referentnih tipova ih koristi u pozadini.
        """.md
      )
    )

  def referentniTipoviSection =
    Section(
      "Referentni tipovi",
      div(
        """
        U referentne tipove ubrajaju se svi tipovi koji **nisu primitivni**.  
        Zato se negdje nazivaju i "neprimitivnim tipovima"...  
        Ove tipove **možemo definisati i mi sami**.  
        Konvencija je da se pišu velikim početnim slovom.

        Već smo vidjeli par primjera ovog tipa: `String` i nizovi.  
        U nastavku ćemo vidjeti kako da definišemo klase, koje spadaju u referentne tipove.

        ##### Reference
        **Varijable** koje imaju referentni tip nazivaju se **reference**.  
        VAŽNO: Svaka referenca može imati vrijednost `null`!!!  
        Primitivne varijable nikada ne mogu biti `null`.
        """.md
      )
    )
}
