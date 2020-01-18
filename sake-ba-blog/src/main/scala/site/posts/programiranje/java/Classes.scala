package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._

object Classes extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Klase")
      .withDescription("Klase u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2019, 7, 14))
      .withSections(klaseSection)

  def klaseSection = Section(
    "Klase",
    div(
      """
      Recimo da imamo zadatak da napravimo program za praćenje učenika u razredu.  
      Za svakog učenika moramo unijeti ime, prezime i prosječnu ocjenu.  
      Trebamo ispisati sve ove podatke i na kraju naći prosjek razreda.
      
      Kako bismo ovo uradili s do sada naučenim konceptima?  
      Imena možemo staviti npr. u niz `String[] imena`.  
      Prezimena možemo staviti npr. u niz `String[] prezimena`.  
      Ocjene ćemo staviti npr. u niz `double[] prosjeci`. 
      """.md,
      chl.java(
        """
        String[] imena;
        String[] prezimena;
        double[] prosjeci;
        
        double zbirProsjeka = 0;
        for(int i = 0; i < imena.length; i ++) {
            System.out.print("Učenik: " + prezimena[i] + " " + imena[i]);
            System.out.println(", prosjek: " + prosjeci[i]);
            zbirProsjeka += prosjeci[i];
        }
        double prosjekRazreda = zbirProsjeka / imena.length;
        System.out.println("Ukupan prosjek razreda: " + prosjekRazreda);
        """
      ),
      """
      Iako ovaj kod radi kako treba, nekako se ne osjećamo dobro zbog njega... :D  
      Indeksi pršte na sve strane, šta ako je jedan od nizova kraći itd?  
      Također, ovi nizovi nam uopće ne govore da su **dio jedne cjeline**.  
      Neko ko čita ovaj kod mora se dobro zapitati šta oni predstavljaju.  
      To je možda lahko na ovom (namjerno) malom primjeru, ali u projektima s milionima linija koda, niko nema vremena da "razbija glavu"... :)
      
      Ovo je jedan od razloga zašto se uvodi apstrakcija klase.  
      Klasa je recept za pravljenje **objekta**. Kaže se još i da je objekat **instanca klase**.  
      Objekat je obično skup primitivnih varijabli i drugih objekata.  
      Dakle, koristi se za **logičko grupisanje vrijednosti**.  
      U prethodnom primjeru trebali bismo grupisati ime, prezime i prosjek. Ova nova apstrakcija tj. klasa bi se zvala `Ucenik`. To bi izgledalo ovako:
      """.md,
      chl.java(
        """
        class Ucenik {
            String ime;
            String prezime;
            double prosjek;
        }
        """
      )
    ),
    List(kreiranjeObjektaSection, poljaKlaseSection)
  )

  def kreiranjeObjektaSection = Section(
    "Kreiranje objekta",
    div(
      """
      Da bismo kreirali novi objekat klase `Ucenik`, koristimo operator `new`:
      ```java
      Ucenik ucenik = new Ucenik();
      ```
      Ovaj operator poziva "funkciju" koja kreira novi objekat i naziva se **konstruktor**.   
      Kompajler nam **automatski kreira konstruktor** za nas, kasnije ćemo vidjeti kako sami možemo definisati konstruktor(e).
      """.md
    )
  )

  def poljaKlaseSection = Section(
    "Polja klase",
    div(
      """
      Vrijednosti unutar klase nazivaju se **polja klase**/**atributi** (en. fields, properties), u ovom slučaju to su ime, prezime i prosjek.  
      Pošto im nismo dodijelili nikakve početne vrijednosti, Java će ih postaviti na **defaultne vrijednosti**: 
      - referentne na `null`
      - brojevne primitivne na `0`
      - `boolean` primitivne  na `false`

      Dakle, u ovom trenutku, ime ima vrijednost `null`, prezime ima vrijednost `null`, prosjek vrijednost `0`. Idemo im dati neke smislene vrijednosti:
      ```java
      ucenik.ime = "Mujo";
      ucenik.prezime = "Mujanović";
      ucenik.prosjek = 4.3D;
      ```
      Odabir polja se piše navođenjem reference, pa tačka, a zatim naziv polja.

      ---
      Dok nismo zaboravili, prethodni primjer sada izgleda puno bolje i razumljivije:
      """.md,
      chl.java(
        """
        Ucenik[] ucenici;

        double zbirProsjeka = 0;
        for(Ucenik u : ucenici) {
            System.out.print("Učenik: " + u.prezime + " " + u.ime);
            System.out.println(", prosjek: " + u.prosjek);
            zbirProsjeka += u.prosjek;
        }
        double prosjekRazreda = zbirProsjeka / ucenici.length;
        System.out.println("Ukupan prosjek razreda: " + prosjekRazreda);
        """
      )
    )
  )

}
