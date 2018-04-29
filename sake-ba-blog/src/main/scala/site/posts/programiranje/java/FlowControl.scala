package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.utils.Imports._

object FlowControl extends JavaTemplate {

  override def pageTitle       = "Kontrola toka"
  override def pageDescription = Option("Kontrola toka programa u Javi.")
  override def postCreateDate  = Option(LocalDate.of(2018, 2, 4))

  override def postSections = List(kontrolaTokaSection)

  def kontrolaTokaSection = Section(
    "Kontrola toka (programa)",
    div(
      md("""
        Kompjuteri obično izvršavaju naredbe jednu za drugom, sekvencijalno.  
        Međutim, potrebne su nam i naredbe za: 
        - **grananje** (if / match / switch / branch) - kada želimo izvršiti nešto samo pod datim **uslovima**"
        - **ponavljanje** (while / for / rekurzija) - kada želimo ponavljati neki dio koda, da ne bi kopirali stalno..."
        """)
    ),
    List(grananjeSection, ponavljanjeSection)
  )

  def grananjeSection = Section(
    "Grananje",
    div(
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
  )

  def ponavljanjeSection = Section(
    "Ponavljanje",
    div(
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
  )

}
