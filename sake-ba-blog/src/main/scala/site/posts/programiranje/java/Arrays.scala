package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._

object Arrays extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Nizovi")
      .withDescription("Nizovi u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2019, 1, 19))
      .withSections(nizoviSection)

  def nizoviSection = Section(
    "Nizovi",
    div(
      """
        Kada trebamo zapamtiti više vrijednosti *istog tipa*,
          to radimo pomoću **niza** (en. array).  
        Tip niza se piše kao `tip[]`.
        Ovo "tip" može biti `int`, `String` ili bilo šta drugo.
        Uglate zagrade kažu da se radi o nizu, a ne "običnom" tipu.

        Kada kreiramo niz, kažemo `new tip[velicina]`, 
          gdje je `velicina` neki broj, mora biti `int`.
        Dužina niza je fiksna, ne može se promijeniti!

        Kada pristupamo elementu niza, to radimo preko indeksa, tj. rednog broja u nizu.  
        Prvi element ima indeks `0`, drugi ima indeks `1` itd.  
        Npr. da bi izmijenili prvi element pišemo `niz[0] = 9;`.  
        Ovdje nam odmah naumpadaju petlje koje smo naučili, 
          `while` i `for` koje su vrlo korisne pri radu s nizovima.

        Ako želimo npr. spremiti ocjene studenta, za to možemo koristiti niz.  
        Recimo da student ima 12 predmeta.
      """.md,
      chl.java(
        """
          int[] ocjene; // nije još inicijaliziran, ne bi ga trebali koristiti!
          ocjene = new int[12]; // niz od 12 nula (po defaultu se popuni nulama)

          ocjene[0] = 9;

          for(int i = 0; i < 12; i++) {
            System.out.println(ocjene[i]);
          }
        """
      ),
      """
        Vidimo da se `12` ponavlja na 2 mjesta, i označava istu stvar, dužinu niza.  
        Naravno, to nije dobra praksa, jer ako trebamo promijeniti dužinu niza, 
          to moramo odraditi na više mjesta.  
        Možemo napraviti novu varijablu u koju ćemo spremiti dužinu niza.  
        Npr. `int BR_OCJENA = 12;` i onda koristiti nju umjesto literala `12`.  
        Ovako je kod puno fleksibilniji.
        
        Međutim, ne znamo uvijek dužinu niza unaprijed. 
        Šta ako pravimo funkciju koja prima niz?  
        Da proslijedimo uvijek i dužinu niza? To bi bilo vrlo nečitljivo i dosadno.   
        Srećom, nizovi u Javi imaju polje (en. property) koje sadrži dužinu niza i zove se `length`.  
        Kada kažemo `ocjene.length` dobićemo dužinu niza. :)  
        Tako da smo u primjeru mogli/trebali napisati `for(int i = 0; i < ocjene.length; i++)`.

        ---
        Postoji još jedan zgodan način za inicijalizaciju niza.  
        Ako znamo unaprijed šta niz sadrži, možemo odmah dodijeliti te vrijednosti nizu.  
        Pritome ne moramo ni navoditi dužinu niza, jer će nam kompajler pomoći.

        Kad smo već kod "zgoda", imamo i tzv. "poboljšanu for petlju" (en. enhanced for loop).
        Zove se još i "for-each" petlja.  
        Ona se koristi kada želimo da prođemo kroz sve elemente niza.  
        Ako nam treba i indeks onda moramo koristiti običnu for petlju...
      """.md,
      chl.java(
        """
          // array literal
          String[] gradovi = { "Sarajevo", "Tuzla", "Mostar" };

          // enhanced for loop
          for(String grad: gradovi) {
            System.out.println(grad);
          }
        """
      )
    ),
    List(visedimenzionalniNizoviSection)
  )

  def visedimenzionalniNizoviSection = Section(
    "Višedimenzionalni nizovi",
    div(
      """
        Možemo imati i *niz nizova*, *niz nizova nizova* itd. 
        Ne postoji ograničenje na dubinu u koju idemo. 
        Nizovi sa 2 ili više dimenzija nazivaju se "višedimenzionalni" (en. multidimensional).  
        
        Dvodimenzionalni nizovi se zovu još i "matrice" (en. matrix).  
        Matrice se često koriste u igricama i matematičkim programima.  
        Npr. kad trebamo predstaviti stanje šahovske ploče i sl. to možemo uraditi sa matricom.  
        Ugniježdeni nizovi ne moraju imati istu dužinu.  
        
        Recimo da imamo zgradu sa različitim brojem stanova po spratu. 
        Svaki red predstavlja jedan sprat, i u svakom spratu imamo br. stanara za svaki stan.
        Trebamo ispisati koliko koji sprat ima ukupno stanara:
      """.md,
      chl.java(
        """
        int[][] brStanaraPoStanovima = { 
          {1, 2, 3, 4}, // prvi red (sprat)
          {5, 6, 2}     // drugi red (sprat)
        };
        
        for (int i = 0; i < brStanaraPoStanovima.length; ++i) {
          int brStanaraSprata = 0;
          for(int j = 0; j < brStanaraPoStanovima[i].length; ++j) {
            brStanaraSprata += brStanaraPoStanovima[i][j];
          }
          System.out.println("Br. stanara sprata " + i + " je: " + brStanaraSprata);
        }
        """
      ),
      "Rezultat:",
      chl.batch
        .withPrompt(" ")
        .withOutputLines("3")("""
          Br. stanara sprata 0 je: 10
          Br. stanara sprata 1 je: 13
        """)
    )
  )

}
