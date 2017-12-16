package hepek.posts.matematika

import java.time.LocalDate

import scalatags.Text.all._

import hepek.templates._
import hepek.utils.html.HTMLUtils._
import hepek.utils.html.ImageUtils._
import hepek.images.Images

object TeorijaSkupova extends MatematikaTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Teorija skupova"
  override def pageLabel = "Teorija skupova"
  override def pageDescription = Option(
    "Kratak uvod u teoriju skupova. Unija, presjek, razlika, De Morgan."
  )

  override def dateCreated = LocalDate.of(2017, 6, 11)

  // section contents....
  val uvodSectionContent =
    div(
      p(
        """
        Teorija skupova (engl. Set theory) je jedna od osnovnih grana matematike. 
        Ona, između ostalog, daje odgovor na to da li neki objekat pripada datom skupu objekata.
        Skup mora biti jasno i nedvosmisleno definisan. 
        """
      ),
      p(
        b("Skup"),
        " kao pojam se obično ne definiše već se uzima kao osnovni pojam. ",
        "To je ustvari samo kolekcija/mnoštvo ",
        u("različitih"),
        " objekata (stvari). ",
        "Objekat koji pripada skupu naziva se ",
        b("element skupa"),
        ". ",
        "Element skupa može biti bilo šta, npr. broj, jabuka, avion, ili čak skup! ",
        br,
        "Vidimo da su skupovi vrlo liberalni, pa se pojavljuju često u raznim oblastima matematike."
      ),
      p(
        "Skupovi se označavaju velikim štampanim slovima: `A,B,...` a elementi malim slovima `x,y,...` ",
        br,
        "Definicija se navodi u vitičastim zagradama, npr. `A={1,2,3}`. ",
        br,
        "Redoslijed elemenata ",
        b("nije bitan:"),
        " `A={1,2,3} = {3,2,1} = {2,1,3}`.",
        br,
        "Zato se kaže i da je skup ",
        b("neuređena kolekcija"),
        ". Ne postoji prvi, drugi element i sl. ",
        p(
          """
          Obično se u matematici koristi neko pravilo koje elementi moraju zadovoljavati (umjesto navođenja elemenata pojedinačno...),
          npr. "skup svih prirodnih brojeva koji su manji od 5".
          """,
          br,
          "To možemo zapisati ovako: `{x | x in NN, x < 5}`. ",
          """Ovdje `x` označava neki element skupa, `|` se čita kao "takav da je", a zarez se čita kao logičko "i" (engl. and). """,
          br,
          "Negdje se koristi i dvotačka umjesto | znaka, npr. `{x : x in NN, x < 5}`."
        )
      ),
      p(
        "Dva skupa su jednaka akko imaju iste elemente. ",
        "To pišemo kao `A=B`, logično... :D",
        blockquote(
          """
         Ovo "akko" je skraćeno od "ako i samo ako" (engl. iff - if and only if).
         Razlika između "ako" i "akko" je sljedeća: 
         Kada kažemo "ako A onda B" ne mora značiti da "ako B onda A"!
         """,
          br,
          """
           Ali, kada kažemo "akko A onda B" tada MORA biti i "akko B onda A"!
         """,
          br,
          br,
          "Primjer: ",
          br,
          """Kod iskaza "Ako grije Sunce onda je dan." ne mora značiti da ako je dan da grije Sunce... Možda je oblačno! """,
          "Vidimo da ovdje ne možemo koristiti akko.",
          br,
          br,
          // http://www.mathwords.com/i/if_and_only_if.htm
          """Dok npr. iskaz "Trougao je jednakostranični akko su mu svi uglovi od `60^o`" je validan. """,
          br,
          "Zašto? Zato što vrijedi i obrnuto, ako su svi uglovi trougla od `60^o` onda je on jednakostranični. Logično."
        )
      ),
      p(
        "Postoji nekoliko skupova koji se često pojavljuju u matematici i imaju posebne simbole: ",
        ul(
          li("`O/` - Prazan skup. Skup koji ne sadrži nijedan element. Označava se i sa `{}`."),
          li(
            "`NN` - Skup prirodnih brojeva (od engl. ",
            b("N"),
            "atural - prirodni). `NN = {0,1,2,...}`.",
            br,
            "Neki autori ne uključuju nulu u ovaj skup, ",
            "pa kada se želi posebno istaći da je i nula uključena koristi se simboli `N_0`, `N^0`.",
            br,
            "Kada se želi istaći da nula nije uključena piše se `N^+ = {1,2,...}`. ",
            br,
            "Analogna notacija vrijedi i za ostale skupove."
          ),
          li("`ZZ` - Skup cijelih brojeva (od njem. ",
             b("Z"),
             "ahl - broj, engl. integer). `ZZ = {0,1,-1,2,-2,...}`."),
          li(
            "`QQ` - Skup racionalnih brojeva (od engl. ",
            b("Q"),
            "uotient - razlomak).",
            br,
            "Svaki broj koji može biti predstavljen razlomkom `p/q` gdje su `p` i `q` dva cijela broja.",
            br,
            "Naravno, `q` ne smije biti nula jer bi dijeljenjem dobili `oo` (beskonačno)..."
          ),
          li("`RR` - Skup realnih brojeva (od engl. ",
             b("R"),
             """eal - pravi). Za nas obične smrtnike ovo su "brojevi sa zarezom"."""),
          li("`CC` - Skup kompleksnih brojeva (od engl. ",
             b("C"),
             "omplex - složeni).",
             br,
             "To su brojevi koji pored realnog sadrže i imaginarni dio.")
        )
      ),
      p(
        "Kada neki element `x` pripada skupu `A` to pišemo sa `x in A`. Npr. `1 in {2,1}`.",
        br,
        "Kada neki element `x` ",
        b("ne"),
        " pripada skupu `A` to pišemo sa `x !in A`.",
        br,
        blockquote(
          ":D",
          br,
          """- Učiteljica: "Možemo reći da `x` pripada `B`".""",
          br,
          """- Učenik: "A učiteljice, što ga pripada?"."""
        )
      ),
      p(
        "Kako smo već rekli, skup može sadržati bilo šta. ",
        br,
        "Da vidimo par zanimljivih primjera:",
        ul(
          li("Ako imamo skup `A = {{1,2},{2,3},4}` tada `1 !in A`.",
             br,
             "Zašto? Pa zato što `1` nije direktno u skupu! Skup `A` sadrži dva skupa i broj `4`!"),
          li("Za bilo koje `x` vrijedi `x !in O/`. Ili napisano hijeroglifima: `AA x, x !in O/`"),
          li("Ako imamo `A = {O/}` vrijedi `O/ != A`. Štaaa? A je skup koji sadrži prazan skup. Što nije isto kao i prazan skup.")
        ),
        blockquote(
          """Simbol `AA` znači "za svako". Npr. `AA x, tvrdnja` se čita kao "za svako x vrijedi tvrdnja". """,
          br,
          """U paru ide i simbol `EE` koji se čita kao "postoji (bar jedno)" ili "ima"."""
        )
      )
    )

  // OPERACIJE: unija, presjek, komplement...
  val operacijeSectionContent =
    rowDiv(
      leftDiv(
        p(
          "Pošto element skupa može biti bilo šta, obično se ograničavamo samo na određeni tip stvari tj. na neki skup. ",
          br,
          "Npr. kada govorimo o cijelim brojevima ne zanimaju nas imaginarni brojevi, jabuke i auta... ",
          br,
          "Skup stvari o kojima se ",
          i("trenutno govori"),
          " naziva se ",
          b("univerzalni skup"),
          " ili kraće ",
          b("univerzum"),
          ".",
          " Označava se sa ",
          b("`U`"),
          "."
        ),
        p(
          "Skupovi i relacija (odnosi) između skupova se mogu grafički predstaviti Venovim dijagramom. ",
          "Na slici desno vidimo primjer s dva skupa: `A = {1,2,4}` i `B = {2,3}`. ",
          "Univerzum (`U`) je pravougaonik koji obuhvata ova dva skupa. Recimo da je to skup `NN`. To je igralište iz kojeg ne smijemo izlaziti. "
        )
      ),
      rightDiv(
        svg(relTo(Images.math.skup), "Vennov dijagram")
      )
    )

  val unijaSectionContent =
    rowDiv(
      leftDiv(
        p(
          "Unija dva skupa `A` i `B` označava se sa `A uu B`. ",
          br,
          "Primijetite da ovo nije obično slovo U već specijalni simbol, mada izgleda kao `uu`nija. ",
          br,
          "Unija predstavlja novi skup koji sadrži sve elemente skupa `A` i sve elemente skupa `B`. ",
          br,
          "U našem primjeru to bi bilo `A uu B = {1,2,3,4}`. ",
          br,
          "Skup ne mora bit predstavljen krugom, niđe veze... xD Dobro zapažanje!"
        ),
        p(
          "Uniju možemo formalno zapisati kao `A uu B = {x | x in A vv x in B}`. ",
          blockquote(
            """Znak `vv` se čita kao "ili". """,
            br,
            """Znak `^^` se čita kao "i". """,
            br,
            "O logičkim operatorima ćemo reći nešto više u idućem poglavlju. "
          )
        )
      ),
      rightDiv(
        svg(relTo(Images.math.unija), "Unija skupova")
      )
    )

  val presjekSectionContent =
    div(
      rowDiv(
        leftDiv(
          p(
            "Često se postavlja pitanje šta dva skupa imaju zajedničko.",
            br,
            "Presjek dva skupa `A` i `B` označava se sa `A nn B`. ",
            br,
            "Presjek predstavlja novi skup koji sadrži one elemente koji se nalaze i u `A` skupu i u `B` skupu. ",
            br,
            "U našem primjeru to bi bilo `A nn B = {2}` (na slici obojeno crvenom bojom!). "
          ),
          p(
            "Presjek možemo formalno zapisati kao `A nn B = {x | x in A ^^ x in B}`. "
          ),
          p(
            "Šta ako skupovi nemaju ništa zajedničko? Rezultat je, naravno, prazan skup, `O/` tj. `{}`. ",
            br,
            "Prazan skup ipak ima neku svrhu... :D",
            br,
            "Za ovakve skupove, koji nemaju zajedničke elemente, kaže se da su",
            b("disjunktni"),
            "."
          )
        ),
        rightDiv(
          svg(relTo(Images.math.presjek), "Presjek skupova")
        )
      ),
      blockquote(
        "Matematika se često bavi pitanjem jednakosti, kako možemo jednu te istu stvar izraziti na više načina. ",
        br,
        "Ti rezultati nam mogu koristiti za skraćivanje algebarskih izraza, optimizacije i sl.",
        br,
        "Za uniju možemo reći da je ",
        b("komutativna"),
        ". Vrijedi da je `A uu B = B uu A`, što nije teško razumjeti.",
        br,
        "Također, ova operacija je i ",
        b("asocijativna"),
        ". Vrijedi da je `A uu (B uu C) = (A uu B) uu C`, tj. redoslijed nije bitan. Pa možemo pisati i `A uu B uu C`...",
        br,
        br,
        "Sve navedeno vrijedi i za operaciju presjek!"
      )
    )

  val razlikaSectionContent =
    div(
      rowDiv(
        leftDiv(
          p(
            "Možemo postaviti i pitanje u čemu se skup `A` razlikuje od skupa `B`. Ova operacija se naziva ",
            i("razlika"),
            ".",
            br,
            "Razlika skupova `A` i `B` označava se sa `A \\\\ B`. ",
            br,
            """Čita se kao "A razlika B". """,
            br,
            "Razliku čine elementi skupa `A` koji se ne nalaze skupu `B`. ",
            br,
            "U našem primjeru to bi bilo `A \\\\ B = {1,4}`. "
          ),
          p(
            "Razliku možemo formalno zapisati kao `A nn B = {x | x in A ^^ x !in B}`. "
          )
        ),
        rightDiv(
          svg(relTo(Images.math.razlika), "Razlika skupova")
        )
      ),
      p(
        "Postoje još dvije zanimljive operacije, prva je ",
        i("simetrična razlika"),
        " (`Delta`).",
        br,
        "Simetrična razlika predstavlja uniju razlika skupova `A` i `B`, tj. `A Delta B = (A \\\\ B) uu (B \\\\ A)`.",
        br,
        "Kroz naš primjer bilo bi `A Delta B = {1,3,4}`"
      ),
      p(
        "Druga operacija je ",
        i("komplement skupa"),
        ".",
        br,
        "Komplement skupa `A` su svi elementi koji nisu u skupu `A`, tj. `bar A = {x in U | x !in A}`, gdje je `U` neki univerzum.",
        br,
        "Negdje se naziva i ",
        i("apsolutni komplement"),
        ".",
        br,
        "Kroz naš primjer bilo bi `bar A = {0,3,5,6,...}`, pri čemu je `U=NN`.",
        br,
        "Druge oznake za su `A'`, `A^C`."
      )
    )

  val deMorganoviZakoniSectionContent =
    div(
      "Dvije vrlo korisne formule vezane za komplemente skupova su ",
      b("De Morganovi zakoni"),
      ":",
      br,
      ul(
        li("`bar (A uu B) = bar A nn bar B`"),
        li("`bar (A nn B) = bar A uu bar B`")
      )
    )

  // RELACIJE: jednakost, podskup itd
  val relacijeSectionContent =
    div(
      "Kao što smo već rekli na početku, skupovi su određeni samo elementima koje sadrže. ",
      br,
      "To nam je dovoljno da odredimo da li su dva skupa jednaka, `A = B` akko `AAx | x in A ^^ x in B`."
    )

  val podskupNadskupSectionContent =
    div(
      p(
        "Za skup `A` kažemo da je ",
        i("podskup"),
        " skupa `B` ako su svi elementi skupa `A` također elementi skupa `B`.",
        br,
        "Ako je `A` podskup od `B` pišemo `A sube B`. (Znak `sube` podsjeća na `<=`, zar ne?)",
        br,
        "Da, može biti i slučaj da je `A=B`!"
      ),
      p(
        "Ako `A != B` (nisu isti skupovi) i `A sube B` tada za `A` kažemo da je ",
        b("pravi podskup"),
        " skupa `B`.",
        br,
        "Piše se `A sub B`.",
        br,
        br,
        "Analogno, imamo i relaciju ",
        i("nadskup"),
        " (`A supe B`) za koju vrijedi obrnuto od relacije podskup."
      ),
      p(
        "Kakav je slučaj sa praznim skupom? Da li je `O/ sube A`?",
        br,
        """Primijenimo definiciju: "Svaki element `O/` (a nema nijedan) je element skupa `A`." """,
        "Hm, zanimljivo fakat...",
        br,
        "Imamo dvije opcije:",
        ul(
          li("Jeste, jer nema nijedan element skupa `O/` koji nije element skupa `A.`"),
          li("Nije, jer nema nijedan element skupa `O/` koji je element skupa `A.`")
        ),
        "Logičari kažu da jeste (prva opcija) i vjerovaćemo im na riječ... xD",
        br,
        """Kažu da je ovo primjer "prazne istine" jer za prazan skup možemo tvrditi šta god želimo... Otprilike."""
      )
    )

  // KARDINALNOST
  val kardinalnostSectionContent =
    div(
      "Kardinalnost skupa je ",
      i("mjera"),
      " broja elemenata nekog skupa. Npr. naš skup `A = {1,2,4}` ima 3 elementa.",
      "Pišemo `|A|=3`.",
      br,
      "Kod konačnih skupova, kardinalnost je obični broj, dok je kod beskonačnih.. kako-kad, komplikovano je! Nećemo u detalje. ",
      br,
      br,
      "Reći ćemo samo da ",
      b("postoji više beskonačnosti"),
      "! Npr. `|NN| != |ZZ|`.",
      br,
      "Ne zaboravimo i `|O/|=0`, naravno."
    )

  // SECTIONS
  val uvodSection = Section("Uvod", uvodSectionContent)

  val operacijeSection = Section(
    "Operacije nad skupovima",
    operacijeSectionContent,
    Seq(
      Section("Unija", unijaSectionContent),
      Section("Presjek", presjekSectionContent),
      Section("Razlika", razlikaSectionContent),
      Section("De Morganovi zakoni", deMorganoviZakoniSectionContent)
    )
  )

  val relacijeSection = Section(
    "Relacije između skupova",
    relacijeSectionContent,
    Seq(
      Section("Podskup i nadskup", podskupNadskupSectionContent)
    )
  )

  val kardinalnostSection = Section(
    "Kardinalnost skupa",
    kardinalnostSectionContent
  )

  override def sections =
    Seq(uvodSection, operacijeSection, relacijeSection, kardinalnostSection)

}
