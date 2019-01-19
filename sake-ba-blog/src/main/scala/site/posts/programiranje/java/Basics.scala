package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.implicits._
import utils.Imports._

object Basics extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Osnove")
      .withDescription("Osnove Jave.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 3, 25))
      .withSections(jshellSection,
                    expressionsAndOperatorsSection,
                    variablesSection)

  def jshellSection = Section(
    "JShell",
    s"""
      Da bi se igrali sa jshellom morate imati instaliranu Javu verzije 9 ili više.  
      Ispratite [sekciju za instalaciju](${Instalacija.ref}).  
      Ako ne želite, možete se strpiti do sekcije [Poyy sviete](${HelloWorld.ref}),
        gdje ćemo pokrenuti *pravi* program.
      
      Koristićemo JShell program za upoznavanje i igranje s Java jezikom.  
      Otvorite konzolu (bez ikakvog straha! :D), ukucajte `jshell` i udarite Enter.  
      Dobićete tzv. interaktivni shell u kojem možete kucati Javu.  
      Zovu ga još i REPL (Read Evaluate Print Loop), jer dobija unos od nas,
        evaluira ga, isprinta neki odgovor, i ponavlja ukrug.
    """.md
  )

  def expressionsAndOperatorsSection = Section(
    "Izrazi i operatori",
    div(
      """
          Za početak, JShell možemo koristiti kao primitivni kalkulator.  
          Tako ćemo steći osjećaj kako se ponašaju brojevi u Javi, 
            i usput objasniti neke osnovne koncepte i pojmove.   
          Ako ukucamo u REPL broj 5 i pritisnemo Enter, vidjećemo sljedeće:
       """.md,
      jshell.withOutputLines("2")("""
        5
        $1 ==> 5
      """),
      """
          REPL je razumio i odgovorio nam da je to vrijednost `5`.  
          U programiranju se kaže da je broj **izraz**.
          *Izraz* u programiranju ima isto značenje kao i u matematici.  
          Dakle, misli se na nešto što ima **vrijednost**. 
          Nešto što možemo prikazati, s čim možemo baratati.  

          ---
          Ako se opet prisjetimo (dosadne) matematike, sjetićemo se da se simboli
            `+`, `-`, `*`, itd. nazivaju **operatori**.   
          Pošto smo rekli da je REPL kao kalkulator, da vidimo šta sve možemo uraditi:
        """.md,
      jshell.withOutputLines("2,4,6,8,10,12,14")("""
        2 + 2
        $2 ==> 4
        2 - 5
        $3 ==> -3
        7 * 3
        $4 ==> 21
        9 / 4
        $5 ==> 2
      """),
      """
          Izgleda da dijeljenje ne radi kako treba... Našli smo grešku! :D  
          Ali, nije tako. Java *podrazumijeva* da želimo podijeliti dva **cijela** broja!  
          Ako se sjetimo osnovne škole, `5 / 2` je ustvari `2` **cijelih** i **ostatak** `1`. :)  
          Dakle, kada dijelimo dva cijela broja, ustvari radimo "cjelobrojno dijeljenje".

          Također, možemo dobiti i ostatak od dijeljenja, pomoću operatora `%`.  
          Npr. `5 % 2` je `1`.

          ---
          Kada želimo koristiti **realne** brojeve (sa zarezom), onda moramo poslije broja napisati tačku.  
          Tačka se koristi jer se znak zarez koristi za neke druge stvari... Otom potom.  
          Uglavnom, da vidimo kako rade realni brojevi (en. **float**ing point):
        """.md,
      jshell.withOutputLines("2,4,6,8,10,12,14")("""
        3.0 + 5.1
        $6 ==> 8.1
        7.3 - 2.9
        $7 ==> 4.4
        5.5 * -2.0
        $8 ==> -11.0
        9.0 / 4.0
        $9 ==> 2.25
      """),
      """
          Sada se sve čini onako kako treba. :)

          ---
          Redoslijed operatora (en. precedence) radi očekivano.  
          Npr. množenje se radi prije sabiranja.  
          Ako želimo baš, baš, biti sigurni da će program raditi kako treba, možemo koristiti zagrade.
        """.md,
      jshell.withOutputLines("2,4,6,8,10,12,14")("""
        2 + 2 * 2
        $10 ==> 6
        (2 + 2) * 2
        $11 ==> 8
      """),
    )
  )

  def variablesSection = Section(
    "Varijable",
    div(
      """   
          Primijetite šta REPL ispisuje kao odgovor, poslije svake unesene linije: `$1 ==> 5`.  
          Ako ukucamo `$1` u REPL vidjećemo sljedeće:
        """.md,
      jshell.withOutputLines("2-3")("""
        $1
        $1 ==> 5
      """),
      """
          Dakle, REPL nam kaže da je **vrijednost** varijable `$1` jednaka `5`.  
          Izraz `5` je spremljen u **varijablu** `$1`, koju možemo koristiti umjesto broja `5`.  
          > Šta je to varijabla?  
          > Zamislite da imate kutije raznih oblika i dimenzija.  
          > Varijabla je baš kao **kutija sa natpisom** koji vi želite.
          > Npr. kutija u kojoj čuvamo neki broj.

          Kreiraćemo novu varijablu pod nazivom `brojJabuka`, 
            za čuvanje `int`egera (en. "integer" je cijeli broj).  
          Ovo `int` je tip varijable (veličina i oblik kutije)! 
          Kasnije ćemo govoriti malo detaljnije o tipovima.
        """.md,
      jshell.withOutputLines("2-3")("""
        int brojJabuka;
        brojJabuka ==> 0
        |  created variable brojJabuka : int
      """),
      """
          Pošto nismo dali vrijednost našoj varijabli, 
            Java nam pomaže tako što postavlja `brojJabuka` na vrijednost `0`.  
          Obično je to ono što želimo, ali je najbolje postaviti početnu vrijednost **eksplicitno**,
            čim uvodimo novu varijablu.
          Tako odmah znamo koja joj je početna vrijednost i ne moramo razmišljati o tome... :)  
          To radimo ovako:
        """.md,
      jshell.withOutputLines("2-3")("""
        int brojJabuka = 0;
        brojJabuka ==> 0
        |  created variable brojJabuka : int
      """),
      """
          Vrlo jednostavno, nakon naziva varijable slijedi znak jednako i vrijednost, ovdje je to `0`.  
          Primijetite da ovaj znak jednakosti **nije matematička jednakost** već operacija dodjele!  
          Tj. kao da kažemo "postavi varijablu `brojJabuka` na nulu!".

          Varijablu možemo izmijeniti, tj. postaviti na novu vrijednost:
        """.md,
      jshell.withOutputLines("2-3")("""
        brojJabuka = 5;
        brojJabuka ==> 5
        |  assigned to brojJabuka : int
      """),
      """
          Sada je vrijednost promijenjena na `5`. 
          Nakon ove linije, gdje god koristimo `brojJabuka` to je kao da napišemo `5`.

          ---
          Također, možemo iskoristiti **prethodnu vrijednost varijable** da bismo dobili novu:
        """.md,
      jshell.withOutputLines("2,4")("""
        brojJabuka = brojJabuka + 1;
        brojJabuka ==> 6
        brojJabuka += 1;
        $23 ==> 7
      """),
      """
          U izrazu `brojJabuka + 1`, vrijednost `brojJabuka` odnosi se na **zadnju vrijednost varijable**,
            dakle vrijednost prije ove linije, tj. `5`.

          Postoji i skraćena verzija za ovo, prikazana na liniji 3, s operatorom `+=`.  
          Također imaju skraćene verzije i za oduzimanje, množenje, dijeljenje i modulo: 
            `-=`, `*=`, `/=`, `%=` respektivno.  
          Ovo "respektivno" je fancy izraz za "u navedenom redoslijedu". :D
        """.md
    ),
    List(variableNamesSection)
  )

  def variableNamesSection = Section(
    "Nazivi varijabli",
    """   
          Nazivi varijabli i tipova (en. identifiers) ne mogu imati razmake u sebi, 
            ne mogu biti nijedna od rezervisanih riječi kao što je `class`, `int`.  
          Ne mogu biti neki rezervisani znakovi, kao npr. `,`, `&` itd.  
          Ne mogu počinjati brojem.
          Primjeri nevalidnih naziva varijabli (isprobajte u JShellu):
          - int my variable = 5
          - int int = 5
          - int , = 5
          - int 5something = 5

          Primjeri validnih naziva varijabli:
          - int _abc = 5
          - int $xyz = 5
          - int Z = 5
          - int t$df_x = 5

          Mogu se koristiti simboli `_` i `$` ali ih treba izbjegavati, 
            pogotovo kao prvi karakter u nazivu varijable!

          Preporučeno je (konvencija, dogovor, dobra praksa) da varijable počinju malim slovom,
            da su camelCase (svaka iduća riječ počinje velikim slovom), npr. `myVariable`.  
          Konstante (varijable koje se neće mijenjati) se pišu velikim slovima 
            i riječi su razdvojene donjom crticom, npr. `MY_CONST`.
        """.md
  )

}
