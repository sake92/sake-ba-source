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
  override def postSections =
    List(
      Section("Uvod", uvodSectionContent),
      Section("Komunikacija", komunikacijaSectionContent),
      Section(
        "Apstrakcije",
        apstrakcijeSectionContent,
        List(
          Section(
            "Varijable",
            varijableSectionContent,
            List(
              Section(
                "Malo terminologije za radoznale",
                varijableTerminologijaSectionContent
              )
            )
          ),
          Section("Tipovi", tipoviSectionContent),
          Section("Funkcije, procedure, metode", potprogramiSectionContent),
          Section(
            "Kontrola toka (programa)",
            kontrolaTokaSectionContent,
            List(
              Section("Skakanje", skakanjeSectionContent),
              Section("Grananje", grananjeSectionContent),
              Section("Ponavljanje", ponavljanjeSectionContent)
            )
          )
        )
      ),
      Section("Paradigme", paradigmeSectionContent),
      Section("Programi", programiSectionContent)
    )

  // UVOD
  def uvodSectionContent =
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

  def komunikacijaSectionContent = div(
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

  def apstrakcijeSectionContent = div(
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
        Dakle, samo znamo da mislimo na NEKI, bilo koji broj.
      """)
  )

  /* VARIJABLE */
  def varijableSectionContent = div(
    md("""
        U svim programskim jezicima postoji koncept varijable.  
        Najprostije rečeno, to je komad memorije kojem mi dajemo ime, da bi znali da tu čuvamo npr. sumu brojeva.  
        Većina programskih jezika **zahtijeva da se varijabla deklariše** prije nego se počne koristiti.  
        Tj. moramo reći programu da nam rezerviše tu memoriju i sl., da se pripremi takoreći.  
        U Javascriptu npr. možemo deklarisati varijablu s imenom "x":
      """),
    chl.javascript("var x;"),
    md("""Postaviti joj vrijednost na nulu: """),
    chl.javascript("x = 0;"),
    md("""
        Kaže se još i "dodjela vrijednosti".  
        Primijetite da ovaj znak jednakosti **nije matematička jednakost** već operacija dodjele!  
        Tj. kao da kažemo "postavi varijablu x na nulu!".  
        U nekim jezicima postoji manje zbunjujuća sintaksa za ovo, znak := (dvotačka-jednako), kao npr. Pascal.

        Možemo iskoristiti prethodnu vrijednost da bi dobili novu, ovdje uvećavamo x za 2: 
        """),
    chl.javascript("x = x + 2;"),
    md("""Nakon prethodne linije vrijednost x je 2.""")
  )

  def varijableTerminologijaSectionContent = div(
    md("""Uzmimo za primjer sljedeći dio koda: """),
    chl.java.withLineHighlight("1,5,8")(
      """
        int i;                  // deklaracija varijable s nazivom "i"
        i = 5;                  // dodjela vrijednosti varijabli "i", sada sadrži broj 5
        System.out.println(i);  // ispisaće "5" na konzoli, bez navodnika

        i = 3;                  // nakon ove linije varijabla "i" sadrži broj 3
        System.out.println(i);  // 3

        i = 2 + 2;              // nakon ove linije varijabla "i" sadrži broj 4
        System.out.println(i);  // 4
      """
    ),
    md("""
        **Izjava** (en. statement)  
        Za linije "i = 5;" i "System.out.println(i);" kažemo da su **izjave**.  
        One označavaju **naredbe** koje zadajemo kompjuteru.  
        Neke izjave koriste sintaksu *ugrađenu u sami jezik*, npr. dodjela vrijednosti (znak jednako: "=").  
        Ostale naredbe obično imaju naziv u *imperativnom* obliku: "print", "calculate", "uradiOvo"...  
        Zato se za Javu i slične jezike kaže da su **imperativni** jezici (jer preferiraju ovaj stil programiranja).

        **Deklaracija** (en. declaration)  
        Za liniju "int i;" kažemo da je **deklaracija** varijable `i`.  
        Njome deklarišemo/uvodimo novo ime u našem programu, u ovom slučaju *varijablu*.  
        U suštini, samo kažemo da **postoji** ta varijabla.

        **Definicija** (en. definition)  
        Linija "i = 5;" je **definicija** varijable `i`.  
        Ovdje navodimo **šta ustvari jeste** ta varijabla.

        **Izraz** (en. expression)  
        Dio linije 8, "2 + 2" nazivamo izrazom. Svaki izraz ima **vrijednost**.  
        Naravno, svaki izraz možemo dodijeliti nekoj varijabli i sl.

        S druge strane, ako malo razmislimo o izjavama, šta je vrijednost izjave "int i;"?  
        Ništa, je li tako? U Javi se to označava s ključnom riječju "void" (nije tip!).  
        U nekim drugim jezicima se koristi poseban tip za ovo "ništa", najčešće je to "Void" ili "Unit".


        Ovo su samo neki termini koje nije loše znati, čisto da bi mogli shvatiti o čemu se priča...  
        Dosta ljudi ne koristi konzistentno ovu terminologiju, pa npr. za "definiciju" podrazumijevaju i "deklaraciju" i sl.  
    """)
  )

  /* TIPOVI */
  def tipoviSectionContent = div(
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

  def potprogramiSectionContent = div(
    md("""
        Potprogrami (en. subroutine) su **dijelovi programa** koje možemo pozvati po **imenu**.  
        Zavisno od jezika, negdje ih zovu *funkcije* (ako imaju rezultat), *procedure* (ako nemaju rezultat), a negdje samo *metode*.  
        Ali u suštini to su sve potprogrami...  

        Moguće je proslijediti **argumente**/parametre koje potprogram može koristiti/izmijeniti.

        Ovo je primjer funkcije u p.j. Javascript:
      """),
    chl.javascript("""
        function suma(broj1, broj2) {
            return broj1 + broj2;
        }
    """)
  )

  def kontrolaTokaSectionContent = div(
    md("""
      Kompjuteri obično izvršavaju naredbe jednu za drugom.  
      Međutim, potrebne su nam i naredbe za: 
      """),
    ul(
      li(
        md(
          "**skakanje** (jump / goto / call) - kada želimo pozvati neki potprogram/subrutinu"
        )
      ),
      li(
        md(
          "**grananje** (if / match / switch / branch) - kada želimo izvršiti nešto samo pod datim **uslovima**"
        )
      ),
      li(
        md(
          "**ponavljanje** (while / for / rekurzija) - kada želimo ponavljati neki dio koda, da ne bi kopirali stalno..."
        )
      )
    )
  )

  val skakanjeSectionContent = div(
    md("""
        Pošto je goto naredba zla, i ne preporučuje se da se koristi,
          vidjećemo **poziv funkcije** "moja_funkcija" u Ruby-ju:
      """),
    chl.ruby.withLineHighlight("3")("""
      p1 = 1
      p2 = 2
      rezultat = moja_funkcija(p1, p2)
      puts rezultat
    """),
    md("""
        *Objašnjenje*:  
          Nakon deklarisanja varijabli "p1" i "p2", **pozivamo** funkciju "moja_funkcija" (linija 3).  
          Tada izvršavanje programa nastavlja **unutar funkcije** "moja_funkcija".  
          Nakon izračunavanja, rezultat se sprema u varijablu "rezultat" i naš program nastavlja dalje.

          Ovdje nije bitno gdje je "moja_funkcija" deklarisana i kako već je bitno da razumijete semantiku "skakanja".

      """),
    blockquote(
      """
        Većina jezika koristi zagrade za proslijeđivanje parametara potprogramu.  
        Neki jezici, kao što je Ruby dozvoljavaju da se izostave zagrade.  
        Navodimo primjere iz različitih jezika samo da bi vidjeli da je to "sve na isti kalup"... :D
      """
    )
  )

  val grananjeSectionContent = div(
    md("""
        Grananje pomoću "if" naredbe je vrlo jednostavno i lahko razumljivo.  
        Ako je **uslov** ispunjen tj. istinit (en. true) onda će se taj dio koda izvršiti.  
        U suprotnom program nastavlja dalje. Ili, ako ima još uslova onda nastavlja njih da ispituje itd.
      """),
    chl.python.withLineHighlight("2,4")(
      """
        temperatura = float(input('Unesite trenutnu temperaturu (°C): '))
        if temperatura > 15:
            print('Toplo je.')
        else:
            print('Hladno je.')
      """
    ),
    md("""
        *Objašnjenje*:  
          Ovdje je uslov vrijednost izraza (temperatura > 15) na liniji 2, koji je ili true ili false.  
          Ako korisnik unese broj 16 ili više ispisaće se na ekran "Toplo je."
            a u suprotnom (en. else, linija 4) ispisaće se na ekran "Hladno je.".
      """),
    hr,
    md("""
        Grananjem pomoću "switch-case" naredbe možemo preglednije napisati više uslova.  
        Sljedeći primjer napisan je u PHP-u.
      """),
    chl.php.withLineHighlight("1,5-7")(
      """
        switch ($i) {
            case 0:
                echo "i je 0";
                break;
            case 1:
                echo "i je 1";
                break;
            default:
                echo "i je nešto što nismo očekivali...";
                break;
        }
      """
    ),
    md("""
        *Objašnjenje*:  
          Na liniji 1 ispituje se čemu je jednaka **vrijednost varijable "i"**, 
            redom i odozgo naravno.  
          Prvi slučaj (en. case) koji bude ispunjen će biti pozvan.
          Ako je vrijednost varijable "i" broj 1 ispisaće se na ekran "i je 1".
          
          Često ne znamo koliko ima mogućih slučajeva, 
            pa onda trebamo odlučiti šta da uradimo po tom pitanju.  
          Za to nam služi ključna riječ "default" (u većini jezika).
      """)
  )

  val ponavljanjeSectionContent = div(
    md("""
        U sljedećem primjeru (C jezik) želimo izvršavati kod sve dok je neki **uslov** ispunjen (en. while znači "dok").  
        Naravno, unutar tog bloka uslov se **mora mijenjati**, inače se program *neće nikad zaustaviti*.  
        To se naziva **beskonačna petlja** i obično nije poželjna... :)
       """),
    chl.c.withLineHighlight("2")(
      """
        int a = 0;
        while(a < 10) {
            printf("Cifra a je: %d\n", a);
            a = a + 1;
        }
      """
    ),
    md("""
        *Objašnjenje*:  
          Uslov se ispituje u svakoj **iteraciji** petlje. Dakle, svaki put kada se dođe do linije 4 uslov će se ponovo ispitati.
          Ako uslov nije zadovoljen, petlja se zaustavlja i program se nastavlja izvršavati na liniji 6 
            (nije prikazana u primjeru, možda je i kraj programa).
      """),
    hr,
    md("""
        Dosta jezika ima i tzv. "for petlje". To su otprilike while petlje s finijom sintaksom.  
        Sljedeći primjer (C# jezik) radi isto kao i prethodni sa while petljom.  
        Samo što se ovdje varijabla zove "i" i koristimo for petlju.
       """),
    chl.csharp.withLineHighlight("1")(
      """
        for (int i = 0; i < 10; i = i + 1) {
            Console.WriteLine("Cifra a je: {0}", i);
        }
      """
    ),
    md("""
        *Objašnjenje*:  
          Uopćena sintaksa for petlje je sljedeća: for(inicijalizacije; uslov; koraci).  
          Vidimo da su dijelovi razdvojeni tačkazarezom.  

          Umjesto da deklarišemo varijable prije petlje, nekad je zgodno deklarisati ih u sklopu petlje, 
            jer nam poslije ne trebaju.  
          Za to nam služi dio **inicijalizacije**.  
          Dio **uslov** je isti kao i kod while petlje.  
          Koraci dolaze **na kraju petlje**, isto kao linija 4 u našoj while petlji.  
          Oni obično *utiču na uslov za izlaz* iz petlje.
      """)
  )

  // PARADIGME
  val paradigmeSectionContent = div(
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

  // PROGRAMI
  val programiSectionContent = div(
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

}
