package hepek.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.images.Images
import hepek.utils.Imports._

object Index extends JavaTemplate {

  override def pageTitle       = "Uvod u programiranje"
  override def pageLabel       = "Početna"
  override def pageDescription = Option("Uvod u programiranje.")

  override def postCreateDate = LocalDate.of(2017, 7, 1)
  override def postSections =
    List(uvodSection, komunikacijaSection, apstrakcijaSection, programiSection)

  def uvodSection         = Section("Uvod", uvodSectionContent)
  def komunikacijaSection = Section("Komunikacija", komunikacijaSectionContent)
  def apstrakcijaSection  = Section("Apstrakcija", apstrakcijaSectionContent)
  def programiSection     = Section("Programi", programiSectionContent)

  def uvodSectionContent = div(
    markdown(
      """
          Postoje (minimalno) dva pristupa kada se podučava nečemu.
          Prvi je odozdo-nagore pristup (en. bottom-up approach). Tu se polazi od početka takoreći.
          Ovdje bi mogli početi recimo od Boole-ove algebre, tranzistora, struje i napona itd.
          Drugi pristup bi bio suprotan, odozgo-nadolje (top-down). Počinje se od generalnog pregleda onog o čemu se priča.
          Koristićemo uglavnom drugi pristup. Zašto? Zato što sam ja ovdje glavni! :D"""
    ),
    "Mislim da se premalo radi na ",
    b("približavanju materije učenicima"),
    ". Što će nama sve ovo, koja je svrha? Odakle da počnem? To su vrlo bitne stvari."
  )

  def komunikacijaSectionContent = div(
    p(
      """
      Mi ljudi za sebe tvrdimo da smo inteligentna bića.
      Jedan od dokaza za to je i raznovrsnost naših načina komunikacije.
      Komunikacija podrazumijeva razmjenu informacija između dva ili više učesnika (ne moraju biti ljudi),
      koristeći zajedničke znakove i pravila.
      U ovo se ubrajaju vizuelne metode (znakovni jezici, grimase, kolutanje očima), audio metode (govor, muzika),
      fizičke (kad vas neko udari jer ste nepristojni npr.).
      Danas u svijetu postoji više od 5.000 jezika, od kojih većina nažalost lagano izumire."""
    ),
    p(
      """
      Ljudi pričaju i sa robotima, ako ništa gledali ste futurističke filmove.
      Ako se nas ljude pita, to je idealan način za komuniciranje.
      Međutim, mašine su u suštini vrlo, vrlo glupe, nemaju inteligenciju kao živa bića.
      Mašine nemaju mozak, tijelo, uši, glasne žice... Sve im to moramo obezbijediti, da bi bile "inteligentne".
      Neki od tih organa su predstavljeni kompjuterom, mehaničkim dijelovima, mikrofonom, zvučnikom itd."""
    ),
    p(
      """
      Kompjuter je mozak mašine, on upravlja svime.
      Na njega su povezani svi ostali uređaji (organi).
      Nama ljudima misli dolaze "same od sebe", ali kompjuterima ne.
      I to im moramo "ručno" unijeti...
      Te kompjuterske misli su ustvari naše naredbe, koje se skupno nazivaju program."""
    ),
    p(
      """
      Ovdje smo da naučimo neke od načina za komuniciranje s kompjuterima.
      Naime, ljudi su razvili na stotine programskih jezika koje se koriste za pisanje kompjuterskih programa.
      Ovi jezici su slični našim jezicima, imaju svoju sintaksu, gramatiku i pravila koja se moraju poštovati."""
    ),
    p(
      """Jedan od značajnijih problema koje p.j. pokušavaju riješiti je kompleksnost.
      Kako programi postaju veći, to su komplikovaniji za razumjeti.
      Zato danas imamo nekoliko paradigmi (pristupa, načina) za razvijanje programa, od kojih su najpoznatije:""",
      ul(
        li(b("proceduralno")),
        li(b("funkcionalno")),
        li(b("objektno orijentisano"), " i"),
        li(b("logičko programiranje")),
      ),
      """Dosta jezika danas je miks dvije ili više ovih paradigmi."""
    )
  )

  def apstrakcijaSectionContent = div(
    markdown(
      """
        Kroz život, svjesno ili nesvjesno, naučili smo koristiti apstrakcije.
        Apstrakcija je ustvari generalizovanje, uopćavanje nečeg konkretnog.
        Naprimjer kada kažemo automobil, podrazumijevamo nešto sa 4 točka, motorom itd.
        To je apstraktni automobil, njegova takoreći definicija, dok je konkretan automobil npr. komšijin Pežo(v) 307, iz 2001. godine.
        
        U fizici i hemiji imamo apstrakciju atoma. Zatim se uvodi apstrakcija molekule, koja se sastoje od više atoma.
        Kada se govori o molekulama, znamo da su "ispod" atomi, ali nas u datom kontekstu to ne zanima!
        Kontekst predstavlja skup okolnosti i činjenica, još jedna vrlo bitna stvar kada se govori o apstrakcijama.
        
        U matematici također imamo apstrakciju broja. Kada kažemo broj obično mislimo na cijeli broj. Ali ne kažemo KOJI broj!? :D Dakle, samo znamo da mislimo na NEKI, bilo koji broj.
        """
    ),
    p(
      "Većina ozbiljnih p.j. ima ",
      b("tipove"),
      ". One koji nemaju slobodno izbjegavajte! ;)",
      "Tip je apstrakcija koju dati p.j. razumije. Npr. kada napišemo ",
      chl.java.inline("int broj"),
      """, ovo "int" je tip varijable "broj". Tako će kompjuter znati, između ostalog, """,
      i("koliko memorije da rezerviše"),
      """ za tu varijablu.
          Pošto smo mu dali tu informaciju, onda nam kompjuter može pomoći, ukazati nam na greške u programu koji pišemo. Npr. da ne možemo sabirati broj i slovo...
          Također nas može i usmjeriti, npr. reći nam koje su operacije dostupne nad datim tipom, da ne moramo nagađati.
          """
    ),
    p(
      """Programski jezici sadrže apstrakcije za opisivanje komplikovanijih podataka, za tok programa itd.
Npr. kada želimo opisati neki (apstraktni) automobil, većina jezika Vam nudi apstrakciju zvanu klasa (en. class):""",
      chl.java("""
    class Automobil {
      int godinaProizvodnje;
      string nazivModela;
    }
    """)
    ),
    p("""Što se tiče apstrakcija za tok programa, tu stvari postaju komplikovanije, ali krenimo redom.

Jedna od najvažnijih naredbi kontrole toka je naredba za grananje.

TU BI KONTINJUD...
""")
  )

  def programiSectionContent = div(
    p(
      "Rekli smo da je program ",
      b("niz naredbi"),
      " koje računar treba izvršiti, u cilju dobijanja nekog rezultata.",
      br,
      "Kako svi ljudi razmišljaju na sebi svojstven način, postoji teoretski beskonačno mnogo rješenja (programa) za jedan te isti problem!"
    ),
    p(
      "Detalji su bitni, međutim, postoji nekoliko zajedničkih stvari koje sadrži većina programa:",
      ul(
        li(
          b("ulaz"),
          " - bio to naziv fajla, broj koji unese korisnik pomoću tastature, pokret miša, svejedno..."
        ),
        li(
          b("izlaz"),
          " - ispis na ekran ili printer, zvuk zvučnika, vibracija džojstika..."
        ),
        li(b("algoritmi i matematičke funkcije")),
        li(b("odluke"),
           " - ako je nešto istina uradi jedno - ako nije uradi drugo itd..."),
        li(b("ponavljanja instrukcija"), " - for petlje, while petlje itd.")
      )
    ),
    p(
      b("Algoritam"),
      " je niz precizno definisanih koraka za dobijanje nekog rezultata.",
      br,
      "Laički rečeno, to je recept za implementaciju neke funkcije."
    ),
    row(
      half1(
        p(
          "U toku pisanja koda nekog programa često će nam se pojavljivati logičke greške.",
          br,
          "Tj. program se izvršava ali ne radi kako bismo željeli. Te greške se nazivaju bagovi. (engl. bug - buba, insekt)",
          br,
          "Za program koji ima takve greške kaže se da je ",
          i("bagovit"),
          ".",
          br,
          "Proces u kojem tražimo greške i ispravljamo ih naziva se debagovanje."
        )
      ),
      half2(image(relTo(Images.programming.error), "To je to."))
    )
  )

}
