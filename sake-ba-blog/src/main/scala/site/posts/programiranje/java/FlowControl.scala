package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.implicits._
import utils.Imports._

object FlowControl extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Kontrola toka")
      .withDescription("Kontrola toka programa u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 2, 4))
      .withSections(kontrolaTokaSection)

  def kontrolaTokaSection = Section(
    "Kontrola toka programa",
    div(
      """
        Kompjuteri obično izvršavaju naredbe jednu nakon druge tj. sekvencijalno.  
        Međutim, potrebne su nam i naredbe za: 
        - **grananje** (`if`, `switch`, `match` i sl.) - kada želimo izvršiti nešto samo pod datim **uslovima**
        - **ponavljanje** (`while`, `for`, rekurzija) - kada želimo ponavljati neki dio koda, da ne bi kopirali kod stalno...
      """.md
    ),
    List(grananjeSection, ponavljanjeSection)
  )

  def grananjeSection = Section(
    "Grananje",
    """
      U Javi imamo 2 osnovne naredbe za kontrolisanje toka programa, `if` i `switch`.
    """.md,
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
        Logička operacija "I" (en. and) se u Javi piše kao `&&`.
          Logička operacija "ILI" (en. or) se u Javi piše kao `||`.
          Logička operacija "NE" (en. negate, not) se u Javi piše kao `!`, i piše se prije uslova koji negira, npr. `!small`.
      
          Primjer:
      """.md,
      chl.java.withLineHighlight("4,6,8")(
        """
          double temperatura = 21.33;
          boolean uslovToplo = temperatura > 25;
          boolean uslovTaman = temperatura > 19 && temperatura <= 25;
          if (uslovToplo) // mogli smo napisati i "if(temperatura > 25)"
            System.out.println("Toplo je");
          else if (uslovTaman)
            System.out.println("Taman je");
          else
            System.out.println("Hladno je");
        """
      ),
      """
        Prethodni kod će ispisati "Taman je", jer je uslov `uslovTaman` ispunjen, tj. istina je da je `21.33 > 19 && 21.33 <=25`.
      
        Niz uslova `if else-if ... else` se tretira kao **jedna naredba**!
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
        Grananje pomoću "switch-case" naredbe može učiniti kod dosta preglednijim.  
        Ova naredba se koristi umjesto mnoštva if-else grana, 
          od koje svaka grana provjerava je li varijabla **jednaka** nekoj vrijednosti.  
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

  /* REPEAT */
  def ponavljanjeSection = Section(
    "Ponavljanje",
    div(
      """
        Za ponavljanje određenog dijela koda, na raspolaganju su nam naredbe `while` i `for`.  
        Zovu se još i "petlje", jer se vrlo lahko zapetljati u njima.  
        Kasnije ćemo vidjeti kako možemo koristiti i funkcije u ovu svrhu, pomoću rekurzije. 
       """.md
    ),
    List(whileSection, forSection)
  )

  def whileSection = Section(
    "While naredba",
    div(
      """         
        U sljedećem primjeru želimo izvršavati kod sve dok je neki **uslov** ispunjen (en. while je "dok").  
        Naravno, unutar tog bloka **uslov se mora mijenjati**, inače se program *neće nikad zaustaviti*.  
        To se naziva **beskonačna petlja** i obično nije poželjna... :)
       """.md,
      chl.java.withLineHighlight("2")(
        """
          int i = 0;
          while(i < 10) {
              System.out.println("Cifra i je: " + i);
              i = i + 1;
          }
          
        """
      ),
      """
        Uslov se ispituje u svakoj **iteraciji** petlje. Dakle, svaki put kada se dođe do linije 5 uslov će se ponovo ispitati.
        Ako uslov nije zadovoljen, petlja se zaustavlja i program se nastavlja izvršavati na liniji 6.
      """.md
    )
  )

  def forSection = Section(
    "For naredba",
    div(
      """
        Java ima i tzv. `for` petlje. To su haman-ha `while` petlje s finijom sintaksom.  
        Sljedeći primjer radi isto kao i prethodni sa `while` petljom.
      """.md,
      chl.java.withLineHighlight("1")(
        """
          for (int i = 0; i < 10; i = i + 1) {
              System.out.println("Cifra i je: " + i);
          }
        """
      ),
      """
          Uopćena sintaksa for petlje je sljedeća: `for(inicijalizacije; uslov; koraci)`.  
          Vidimo da su dijelovi `for` petlje razdvojeni tačkazarezom.  

          Umjesto da deklarišemo varijable prije petlje, zgodno je deklarisati ih u sklopu petlje, 
            jer nam poslije petlje one ne trebaju.  
          Za to nam služi dio **inicijalizacije**.  
          
          Dio **uslov** je isti kao i kod while petlje.  
          
          Dio **koraci** dolazi **na kraju petlje**, isto kao linija 4 u našoj `while` petlji.  
          Koraci obično *utiču na uslov za izlaz* iz petlje.
      """.md
    )
  )

}
