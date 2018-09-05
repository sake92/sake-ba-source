package site.posts.matematika

import java.time.LocalDate

import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.images.Images
import hepek.utils.Imports._

object TeorijaSkupova extends MatematikaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Teorija skupova")
      .withDescription(
        "Kratak uvod u teoriju skupova. Unija, presjek, razlika, De Morgan."
      )

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2017, 6, 11))
      .withSections(uvodSection,
                    operacijeSection,
                    relacijeSection,
                    kardinalnostSection)

  def uvodSection = Section(
    "Uvod",
    div(
      md("""
          Teorija skupova (engl. Set theory) je jedna od osnovnih grana matematike.  
          Ona, između ostalog, daje odgovor na to da li neki objekat pripada datom skupu objekata.  
          Skup mora biti jasno i nedvosmisleno definisan. 

          **Skup** kao pojam se obično ne definiše već se uzima kao osnovni pojam.  
          To je ustvari samo kolekcija/mnoštvo __različitih__ objekata (stvari).  
          Objekat koji pripada skupu naziva se **element skupa**.  
          Element skupa može biti bilo šta, npr. broj, jabuka, avion, ili čak skup!  
          Vidimo da su skupovi vrlo liberalni, pa se pojavljuju često u raznim oblastima matematike.

          Skupovi se označavaju velikim štampanim slovima: ´A´,´B´,... a elementi malim slovima ´x´,´y´,...´  
          Definicija se navodi u vitičastim zagradama, npr. ´A=\\{1,2,3\\}´.  
          Redoslijed elemenata **nije bitan**: ´A=\\{1,2,3\\} = \\{3,2,1\\} = \\{2,1,3\\}´.  
          Zato se kaže i da je skup **neuređena kolekcija**.  
          Ne postoji prvi, drugi element i sl.  

          Obično se u matematici koristi neko pravilo koje elementi moraju zadovoljavati (umjesto navođenja elemenata pojedinačno...),
            npr. "skup svih prirodnih brojeva koji su manji od 5".            
          To možemo zapisati ovako: ´\\{x | x \\in \mathbb{N}, x < 5\\}´.  
          Ovdje ´x´ označava neki element skupa, ´|´ se čita kao "takav da je", a zarez se čita kao logičko "i" (engl. and).  
          Negdje se koristi i dvotačka umjesto | znaka, npr. ´\\{x : x \\in \mathbb{N}, x < 5\\}´.

          Dva skupa su jednaka akko imaju iste elemente.  
          To pišemo kao ´A=B´, logično... :D
         """),
      blockquote(
        md("""
            Ovo "akko" je skraćeno od "ako i samo ako" (engl. iff - if and only if).  
            Razlika između "ako" i "akko" je sljedeća:  
            Kada kažemo "ako A onda B" ne mora značiti da "ako B onda A"!  
             
            Ali, kada kažemo "akko A onda B" tada MORA biti i "akko B onda A"!

            Primjer:  
            Kod iskaza "Ako grije Sunce onda je dan." ne mora značiti da ako je dan da grije Sunce... Možda je oblačno!  
            Vidimo da ovdje ne možemo koristiti akko.  
            Dok npr. iskaz "Trougao je jednakostranični akko su mu svi uglovi od ´60^o´" je validan.
            
            Zašto? Zato što vrijedi i obrnuto, ako su svi uglovi trougla od ´60^o´ onda je on jednakostranični. Logično.
           """),
      ),
      md("""
        Postoji nekoliko skupova koji se često pojavljuju u matematici i imaju posebne simbole:
        - ´\emptyset´ - Prazan skup. Skup koji ne sadrži nijedan element. Označava se i sa ´\\{\\}´.
        - ´\mathbb{N}´ - Skup prirodnih brojeva (od engl. **N**atural - prirodni). ´\mathbb{N} = \\{0,1,2,...\\}´.  
                Neki autori ne uključuju nulu u ovaj skup.  
                Zato kada se želi posebno istaći da je i nula uključena koriste se simboli ´N_0´, ´N^0´.  
                Kada se želi istaći da nula nije uključena piše se ´N^+ = \\{1,2,...\\}´.  
                Analogna notacija vrijedi i za ostale skupove.
        - ´\mathbb{Z}´ - Skup cijelih brojeva (od njem. **Z**ahl - broj, engl. integer). ´\mathbb{Z} = \\{0,1,-1,2,-2,...\\}´.
        - ´\mathbb{Q}´ - Skup racionalnih brojeva (od engl. **Q**uotient - razlomak).  
                Svaki broj koji može biti predstavljen razlomkom ´\frac{p}{q}´ gdje su ´p´ i ´q´ dva cijela broja.  
                Naravno, ´q´ ne smije biti nula jer bi dijeljenjem dobili ´\infty´ (beskonačno)...
        - ´\mathbb{R}´ - Skup realnih brojeva (od engl. **R**eal - pravi).  
                Za nas obične smrtnike ovo su "brojevi sa zarezom".
        - ´\mathbb{C}´ - Skup kompleksnih brojeva (od engl. **C**omplex - složeni).  
                To su brojevi koji pored realnog sadrže i imaginarni dio.
      """),
      md("""
          Kada neki element ´x´ pripada skupu ´A´ to pišemo sa ´x \\in A´. Npr. ´1 \\in \\{2,1\\}´.  
          Kada neki element ´x´ **ne** pripada skupu ´A´ to pišemo sa ´x \\notin A´.
         """),
      blockquote(
        md("""
            :D  
            - Učiteljica: "Možemo reći da ´x´ pripada ´B´".  
            - Učenik: "A učiteljice, što ga pripada?".
           """)
      ),
      md("""
        Kako smo već rekli, skup može sadržati bilo šta.  
        Da vidimo par zanimljivih primjera:
           
        - Ako imamo skup ´A = \\{\\{1,2\\},\\{2,3\\},4\\}´ tada ´1 \\notin A´.  
          Zašto? Pa zato što ´1´ nije direktno u skupu! Skup ´A´ sadrži dva skupa i broj ´4´!
        - Za bilo koje ´x´ vrijedi ´x \\notin \emptyset´. Ili napisano hijeroglifima: ´\\forall x, x \\notin \emptyset´.  
        - Ako imamo ´A = \\{\emptyset\\}´ vrijedi ´\emptyset \\not = A´. 
          Štaaa? A je skup koji sadrži prazan skup. Što nije isto kao i prazan skup.
       
        
        > Simbol ´\\forall´ znači "za svako". Npr. ´\\forall x, tvrdnja´ se čita kao "za svako x vrijedi tvrdnja".  
        > U paru ide i simbol ´EE´ koji se čita kao "postoji (bar jedno)" ili "ima".
      """)
    )
  )

  def operacijeSection = Section(
    "Operacije nad skupovima",
    row(
      half1(
        md("""
            Pošto element skupa može biti bilo šta, obično se ograničavamo samo na određeni tip stvari tj. na neki skup.  
            Npr. kada govorimo o cijelim brojevima ne zanimaju nas imaginarni brojevi, jabuke i auta...  
            Skup stvari o kojima se *trenutno govori* naziva se **univerzalni skup**, ili kraće **univerzum**.  
            Označava se sa **´U´**.

            Skupovi i relacija (odnosi) između skupova se mogu grafički predstaviti Venovim dijagramom.  
            Na slici desno vidimo primjer s dva skupa: ´A = \\{1,2,4\\}´ i ´B = \\{2,3\\}´.  
            Univerzum (´U´) je pravougaonik koji obuhvata ova dva skupa. Recimo da je to skup ´\mathbb{N}´.
            To je igralište iz kojeg ne smijemo izlaziti. 
           """)
      ),
      half2(
        svg(relTo(Images.math.skup), "Vennov dijagram")
      )
    ),
    List(
      unijaSection,
      presjekSection,
      razlikaSection,
      deMorganoviZakoniSection
    )
  )

  def unijaSection = Section(
    "Unija",
    row(
      half1(
        md("""
          Unija dva skupa ´A´ i ´B´ označava se sa ´A \cup B´.  
          Primijetite da ovo nije obično slovo U već specijalni simbol, mada izgleda kao ´\cup´nija.  
          Unija predstavlja novi skup koji sadrži sve elemente skupa ´A´ i sve elemente skupa ´B´.  
          U našem primjeru to bi bilo ´A \cup B = \\{1,2,3,4\\}´.  
          Skup ne mora bit predstavljen krugom, niđe veze... xD Dobro zapažanje!

          Uniju možemo formalno zapisati kao ´A \cup B = \\{x | x \\in A \lor x \\in B\\}´.
         
          > Znak ´\lor´ se čita kao "ili".  
          > Znak ´\land´ se čita kao "i".  
          > O logičkim operatorima ćemo reći nešto više u idućem poglavlju.
        """)
      ),
      half2(
        svg(relTo(Images.math.unija), "Unija skupova")
      )
    )
  )

  def presjekSection = Section(
    "Presjek",
    div(
      row(
        half1(
          md("""
              Često se postavlja pitanje šta dva skupa imaju zajedničko.  
              Presjek dva skupa ´A´ i ´B´ označava se sa ´A \cap B´.  
              Presjek predstavlja novi skup koji sadrži one elemente koji se nalaze i u ´A´ skupu i u ´B´ skupu.  
              U našem primjeru to bi bilo ´A \cap B = \\{2\\}´ (na slici obojeno crvenom bojom!).  
              Presjek možemo formalno zapisati kao ´A \cap B = \\{x | x \\in A \land x \\in B\\}´.

              Šta ako skupovi nemaju ništa zajedničko?  
              Rezultat je, naravno, prazan skup, ´\emptyset´ tj. ´\\{\\}´.  
              Prazan skup ipak ima neku svrhu... :D  
              Za ovakve skupove, koji nemaju zajedničke elemente, kaže se da su
              **disjunktni**.
             """)
        ),
        half2(
          svg(relTo(Images.math.presjek), "Presjek skupova")
        )
      ),
      blockquote(
        md("""
            Matematika se često bavi pitanjem jednakosti, kako možemo jednu te istu stvar izraziti na više načina.  
            Ti rezultati nam mogu koristiti za skraćivanje algebarskih izraza, optimizacije i sl.  
            
            Za uniju možemo reći da je **komutativna**.  
            Vrijedi da je ´A \cup B = B \cup A´, što nije teško razumjeti.  
            
            Također, ova operacija je i **asocijativna**.
            Vrijedi da je ´A \cup (B \cup C) = (A \cup B) \cup C´, tj. redoslijed nije bitan.  
            Sada možemo pisati i ´A \cup B \cup C´...
            
            Sve navedeno vrijedi i za operaciju presjek!
           """)
      )
    )
  )

  def razlikaSection = Section(
    "Razlika",
    div(
      row(
        half1(
          md("""
              Možemo postaviti i pitanje u čemu se skup ´A´ razlikuje od skupa ´B´.  
              Ova operacija se naziva *razlika*.
              
              Razlika skupova ´A´ i ´B´ označava se sa ´A \\ B´.  
              Čita se kao "A razlika B".  
              Razliku čine elementi skupa ´A´ koji se ne nalaze skupu ´B´.  
              U našem primjeru to bi bilo ´A \\ B = \\{1,4\\}´.
              
              Razliku možemo formalno zapisati kao ´A \setminus B = \\{x | x \\in A \land x \\notin B\\}´. 
             """)
        ),
        half2(
          svg(relTo(Images.math.razlika), "Razlika skupova")
        )
      ),
      md("""
          Postoje još dvije zanimljive operacije, prva je *simetrična razlika*  (´\Delta´).  
          Simetrična razlika predstavlja uniju razlika skupova ´A´ i ´B´, tj. ´A \Delta B = (A \\ B) \cup (B \\ A)´.  
          Kroz naš primjer bilo bi ´A \Delta B = \\{1,3,4\\}´

          Druga operacija je *komplement skupa*.
          Komplement skupa ´A´ su svi elementi koji nisu u skupu ´A´, tj. ´\overline{A} = \\{x \\in U | x \\notin A\\}´, 
            gdje je ´U´ neki univerzum.  
          Negdje se naziva i *apsolutni komplement*.  
          Kroz naš primjer bilo bi ´\overline{A} = \\{0,3,5,6,...\\}´, pri čemu je ´U=\mathbb{N}´.  
          Druge oznake su ´A'´ i ´A^C´.
         """)
    )
  )

  def deMorganoviZakoniSection = Section(
    "De Morganovi zakoni",
    md("""
      Dvije vrlo korisne formule vezane za komplemente skupova su **De Morganovi zakoni**:
      - ´\overline{A \cup B} = \overline{A} \cap \overline{B}´
      - ´\overline{A \cap B} = \overline{A} \cup \overline{B}´
    """)
  )

  def relacijeSection = Section(
    "Relacije između skupova",
    md(
      """
        Kao što smo već rekli na početku, skupovi su određeni samo elementima koje sadrže.  
        To nam je dovoljno da odredimo da li su dva skupa jednaka,
          ´A = B´ akko ´\\forall x | x \\in A \land x \\in B´.
      """
    ),
    List(podskupNadskupSection)
  )

  def podskupNadskupSection = Section(
    "Podskup i nadskup",
    md("""
      Za skup ´A´ kažemo da je *podskup* skupa ´B´ ako su svi elementi skupa ´A´ također elementi skupa ´B´.  
      Ako je ´A´ podskup od ´B´ pišemo ´A \subseteq B´. (Znak ´\subseteq´ podsjeća na ´\le´, zar ne?)  
      Da, može biti i slučaj da je ´A=B´!

      Ako ´A \\not = B´ (nisu isti skupovi) i ´A \subseteq B´ tada za ´A´ kažemo da je **pravi podskup** skupa ´B´. 
      Piše se ´A \subset B´.  
      
      Analogno, imamo i relaciju *nadskup* (´A \supseteq B´) za koju vrijedi obrnuto od relacije podskup.

      Kakav je slučaj sa praznim skupom? Da li je ´\emptyset \subseteq A´?  
      Primijenimo definiciju: "Svaki element ´\emptyset´ (a nema nijedan) je element skupa ´A´.
      Hm, zanimljivo fakat...  
      Imamo dvije opcije:
        
      - Jeste, jer nema nijedan element skupa ´\emptyset´ koji nije element skupa ´A.´
      - Nije, jer nema nijedan element skupa ´\emptyset´ koji je element skupa ´A.´

      Logičari kažu da jeste (prva opcija) i vjerovaćemo im na riječ... xD  
      Kažu da je ovo primjer "prazne istine" jer za prazan skup možemo tvrditi šta god želimo... Otprilike.
    """)
  )

  def kardinalnostSection = Section(
    "Kardinalnost skupa",
    md(
      """
        Kardinalnost skupa je *mjera* broja elemenata nekog skupa.  
        Npr. naš skup ´A = \\{1,2,4\\}´ ima 3 elementa. Pišemo ´|A|=3´.  
        
        Kod konačnih skupova, kardinalnost je obični broj, dok je kod beskonačnih.. kako-kad, komplikovano je!  
        Nećemo u detalje.
        Reći ćemo samo da **postoji više beskonačnosti**! Npr. ´|\mathbb{N}| \\not = |\mathbb{Z}|´.  
        Ne zaboravimo i ´|\emptyset|=0´, naravno.
      """
    )
  )

}
