package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._
import ba.sake.hepek.plantuml.PlantumlHelpers._

object Branching extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Uslovno grananje")
      .withDescription("Uslovno grananje toka programa u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 2, 4))
      .withSections(uslovnoGrananjeTokaSection)

  def uslovnoGrananjeTokaSection = Section(
    "Uslovno grananje toka programa",
    div(
      """
        Kompjuteri obično izvršavaju naredbe jednu nakon druge tj. sekvencijalno.  
        Međutim, potrebne su nam i naredbe za **uslovno grananje**.  
        To jest, kada želimo izvršiti nešto samo pod datim **uslovima**.  
        U Javi za ovu svrhu imamo 2 naredbe: `if` i `switch`.
      """.md
    ),
    List(ifSection, switchSection)
  )

  def ifSection = Section(
    "If naredba",
    div(
      """
        Grananje pomoću `if` naredbe je vrlo jednostavno.
        Ako je **uslov** ispunjen onda će se taj dio koda izvršiti.
        U suprotnom program nastavlja dalje.
      
        Ovo "uslov ispunjen" može biti DA ili NE, tj. ISTINA (en. true) ili NEISTINA (en. false).
        Ovaj **tip podatka** se naziva **Boolean** po matematičaru George Boole-u.
      
          Ako se sjećate logike iz matematike, tablica istine, "I", "ILI", "NE" i ostalih, TO JE TO! :D
          - Logička operacija "I" (en. and) se u Javi piše kao `&&`
          - Logička operacija "ILI" (en. or) se u Javi piše kao `||`
          - Logička operacija "NE" (en. negate, not) se u Javi piše kao `!`, 
            i piše se prije uslova koji negira, npr. `!small`.
      
          Primjer:
      """.md,
      chl.java.withLineHighlight("4,6")(
        """
          double temperatura = 21.33;
          boolean uslovToplo = temperatura > 25;
          if (uslovToplo) // može i "if(temperatura > 25)"
            System.out.println("Toplo je");
          else
            System.out.println("Nije toplo");
        """
      ),
      """
        Prethodni kod će ispisati "Nije toplo", jer uslov `uslovToplo` **nije ispunjen**, 
        tj. izraz `21.33 > 25` je `false`.  
        Ovo `if else` se tretira kao **jedna naredba**!  
        Ako želimo da izvršimo više od jedne naredbe u `if` ili `else` bloku,
        samo ih okružimo zagradama: `if (uslov) { naredbe1... } else { naredbe2... }`.

        Nakon linije 6 program nastavlja normalno sa svojim izvršenjem.  

        Slijedi i vizuelni dijagram izvršenja ove naredbe:
      """.md,
      div(Classes.txtAlignCenter)(
        plantSvg("""
          @startuml 
          skinparam backgroundColor #EEEBDC
          skinparam shadowing false

          start

          if (**uslov?**) then (jeste)
            :uradi nešto;
          else (nije)
            :uradi nešto drugo;
          endif

          stop

          @enduml
        """)
      ),
      """
        Možemo imati i više uslova u jednoj naredbi, tj. niz `if-elseif-elseif-...-else`.  
        Ovi uslovi bi trebali biti **međusobno isključivi** tj. smisleni.
        > Ako napišete `if (broj>5) {/* prvi */} else if (broj>7) {/* drugi */}` to nema puno smisla jer
        >   ako broj nije veći od 5, ne može biti veći od 7, nema šansone. :D  
        > Ako jeste veći od 5, biće izvršen prvi blok, ali drugi blok koda NIKAD NEĆE BITI IZVRŠEN!
    
        Ako postoji grana `else`, ona će biti izvršena **ako nijedan uslov nije ispunjen**.
        Ako ne postoji `else` i nijedan uslov nije ispunjen, ništa neće biti izvršeno od te cijele if naredbe.
      """.md
    )
  )

  def switchSection = Section(
    "Switch naredba",
    div(
      """
        Grananje pomoću `switch-case` naredbe može učiniti kod dosta preglednijim.  
        Ova naredba se koristi umjesto mnoštva if-else grana, 
          od koje svaka grana provjerava **je li varijabla jednaka** nekoj vrijednosti.  
        U Javi možete "switchati" cijele brojeve, karaktere, stringove i enumeracije.
      """.md,
      chl.java.withLineHighlight("2,6-8")(
        """
        int i = 5;
        switch (i) {
            case 3:
                System.out.println("Tri");
                break;
            case 5:
                System.out.println("Pet");
                break;
            default:
                System.out.println("Ne znam...");
                break;
        }
      """
      ),
      """
          Na liniji 2 ispituje se čemu je **jednaka vrijednost varijable `i`**, 
            **redom odozgo** naravno.  
          Prvi slučaj (en. case) koji bude ispunjen će biti izvršen.  
          Ako je vrijednost varijable `i` broj 5, ispisaće se na ekran "Pet".
          
          Često ne znamo koliko ima mogućih slučajeva, 
            pa onda trebamo odlučiti šta da uradimo po tom pitanju.  
          Za to nam služi ključna riječ `default`. To je ustvari ona `else` grana u `if` naredbi! ;)
      """.md
    )
  )

}
