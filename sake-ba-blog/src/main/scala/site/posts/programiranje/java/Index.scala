package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.images.Images
import hepek.utils.Imports._

object Index extends JavaTemplate {

  override def pageTitle       = "Uvod u programiranje"
  override def pageLabel       = "Početna"
  override def pageDescription = Option("Uvod u programiranje.")

  override def postCreateDate = Option(LocalDate.of(2017, 7, 1))
  override def postSections = List(
    uvodSection,
    komunikacijaSection,
    apstrakcijeSection,
    paradigmeSection,
    programiSection
  )

  def uvodSection = Section(
    "Uvod",
    md(
      """
        Postoje (minimalno) dva pristupa kada se podučava nečemu.  
        Prvi je odozdo-nagore pristup (en. bottom-up approach). Tu se polazi od početka takoreći.  
        Ovdje bi mogli početi recimo od Boole-ove algebre, tranzistora, struje i napona itd.  
        Drugi pristup bi bio suprotan, odozgo-nadolje (top-down). Počinje se od generalnog pregleda onog o čemu se priča.  
        Koristićemo uglavnom drugi pristup. Zašto? Zato što sam ja ovdje glavni! :D  

        Mislim da se premalo radi na **približavanju materije učenicima**.  
        Što će nama sve ovo, koja je svrha? Odakle da počnem? To su vrlo bitne stvari.
      """
    )
  )

  def komunikacijaSection = Section(
    "Komunikacija",
    div(
      md("""
        Mi ljudi za sebe tvrdimo da smo inteligentna bića. 
        Jedan od dokaza za to je i raznovrsnost naših načina komunikacije.  
        Komunikacija podrazumijeva razmjenu informacija između dva ili više učesnika (ne moraju biti ljudi),
        koristeći zajedničke znakove i pravila.  
        U ovo se ubrajaju vizuelne metode (znakovni jezici, grimase, kolutanje očima), audio metode (govor, muzika),
        fizičke (kad vas neko udari jer ste nepristojni npr.).  
        Danas u svijetu postoji više od 5.000 jezika, od kojih većina nažalost lagano izumire.

        Ljudi pričaju i sa robotima, ako ništa gledali ste futurističke filmove.  
        Ako se nas ljude pita, to je *idealan način za komuniciranje*.  
        Međutim, mašine su u suštini vrlo, vrlo glupe, nemaju inteligenciju kao živa bića.  

        Mašine nemaju mozak, tijelo, uši, glasne žice... Sve im to moramo obezbijediti, da bi bile "inteligentne".
        Neki od tih organa su predstavljeni kompjuterom, mehaničkim dijelovima, mikrofonom, zvučnikom itd.

        Kompjuter je mozak mašine, on upravlja svime.
        Na njega su povezani svi ostali uređaji (organi).  
        Nama ljudima misli dolaze "same od sebe", ali kompjuterima ne.  
        I to im moramo "ručno" unijeti...
        Te kompjuterske misli su ustvari naše **naredbe**, koje se skupno nazivaju **program**.

        Ovdje smo da naučimo neke od načina za komuniciranje s kompjuterima.  
        Naime, ljudi su razvili na stotine **programskih jezika** koje se koriste za pisanje kompjuterskih programa.  
        Ovi jezici su slični našim jezicima, imaju svoju *sintaksu*, *gramatiku* i *pravila* koja se moraju poštovati.
      """)
    )
  )

  def apstrakcijeSection = Section(
    "Apstrakcije",
    div(
      md("""
        Kroz život, svjesno ili nesvjesno, naučili smo koristiti apstrakcije.
        Apstrakcija je ustvari *generalizovanje*, uopćavanje nečeg konkretnog.
        U datom kontekstu bitna su nam **samo neka svojstva** datog objekta/stvari/koncepta.  
        Naprimjer kada kažemo automobil, podrazumijevamo nešto sa 4 točka, motorom itd.
        To je apstraktni automobil, njegova takoreći definicija, dok je konkretan automobil npr. komšijin Pežo(v) 307, iz 2001. godine.
        
        U fizici i hemiji imamo apstrakciju atoma. Zatim se uvodi apstrakcija molekule, koja se sastoje od više atoma.
        Kada se govori o molekulama, znamo da su "ispod" atomi, ali nas u datom kontekstu to ne zanima!
        Kontekst predstavlja skup okolnosti i činjenica, još jedna vrlo bitna stvar kada se govori o apstrakcijama.
        
        U matematici imamo apstrakciju broja. Kada kažemo broj obično mislimo na cijeli broj. Ali ne kažemo KOJI broj!? :D  
        Dakle, samo znamo da mislimo na **neki** broj.
      """)
    )
  )

  def paradigmeSection = Section(
    "Paradigme",
    div(
      md("""
        Jedan od značajnijih problema koje p.j. pokušavaju riješiti je **kompleksnost**.  
        Kako programi postaju veći, to su komplikovaniji za razumjeti.  
        Zato danas imamo nekoliko paradigmi (pristupa, načina) za razvijanje programa, od kojih su najpoznatije:
      """),
      p(
        ul(
          li(b("proceduralno")),
          li(b("funkcionalno")),
          li(b("objektno orijentisano"), " i"),
          li(b("logičko programiranje")),
        ),
        md("""
          Dosta jezika danas je miks dvije ili više ovih paradigmi." 
          Ove paradigme *usmjeravaju naš način razmišljanja* o problemima po svom nekom "šablonu".

          Npr. kod proceduralnog/imperativnog načina razmišljanja **mijenjamo varijable** "u mjestu".  
          Ovdje moramo misliti koja je vrijednost neke varijable *u datom trenutku*, što je većini ljudi izazovan zadatak.

          Dok kod funkcionalnog/matematičkog načina razmišljanja pravimo **nove varijable** a stare ne diramo!  
          To nam pomaže kod razumijevanja određenog dijela koda, ne moramo pamtiti u glavi stanje "cijelog svijeta" 
            i na šta utiče promjena date varijable. Ali, otom potom...
        """)
      )
    )
  )

  def programiSection = Section(
    "Programi",
    div(
      md("""
        Rekli smo da je program **niz naredbi** koje računar treba izvršiti,
          u cilju dobijanja nekog rezultata.  
        Kako svi ljudi razmišljaju na sebi svojstven način,
          postoji teoretski beskonačno mnogo rješenja (programa) za jedan te isti problem!

        Pored gore navedenih apstrakcija, programi često komuniciraju i sa "vanjskim svijetom".  
        Npr. ako trebamo učitati neki tekstualni fajl i prebrojati sve riječi, 
          taj fajl **nije dio programa** već je **ulaz** (en. input) u naš program. 
        Isto vrijedi i za klik miša, unos sa tastature, mikrofona i sl.

        Analogno, kada želimo npr. ispisati nešto na ekran to se zove **izlaz** (en. output) iz našeg programa.  

        Naravno, da ne bismo "izmišljali toplu vodu" možemo se okoristiti znanjem stečenim kroz ljudsku historiju.  
        Ljudi su nadošli na koncept algoritma, koji predstavlja nedvosmislenu specifikaciju za rješavanje nekog problema.  
        Tj. **Algoritam** je niz precizno definisanih koraka za dobijanje nekog rezultata.  
        Laički rečeno, to je recept za implementaciju neke funkcije.
        
       """),
      row(
        half1(
          md("""
          U toku pisanja koda nekog programa često će nam se pojavljivati logičke greške.  
          Tj. program se izvršava ali ne radi kako bismo željeli. Te greške se nazivaju bagovi (engl. bug - buba, insekt).  
          Za program koji ima takve greške kaže se da je  *bagovit*.  
          Proces u kojem tražimo greške i ispravljamo ih naziva se debagovanje.
        """)
        ),
        half2(image(relTo(Images.programming.error), "To je to."))
      )
    )
  )

}
