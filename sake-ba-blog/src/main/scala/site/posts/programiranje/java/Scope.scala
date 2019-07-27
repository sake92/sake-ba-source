package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._

object Scope extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Scope, opseg")
      .withDescription("Scope u Javi.")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2019, 7, 14))
      .withSections(scopeSection)

  def scopeSection = Section(
    "Scope, opseg",
    div(
      """
      Svaka varijabla u Javi ima svoj scope.  
      Scope je **dio programa** u kom je ta varijabla **vidljiva** tj. može se tu koristiti.  
      Scope-ovi mogu biti ugniježdeni.  
      Unutrašnji scope može vidjeti/koristiti varijable iz vanjskog scope.  
      Unutrašnji scope može definisati **novu varijablu** koja se zove **isto** kao varijabla u vanjskom scope!

      Postoje dva najvažnija scope-a a to su: scope klase i scope metode.  
      Scope metode je ugniježden u scope klase.  
      Npr. polja klase se mogu koristiti u metodama, ali varijable definisane u metodi se ne mogu koristiti u klasi:
      """.md,
      chl.java(
        """
        class Abc {
            int x = 5;
            // int z = y + 2; // ovo nije dozvoljeno
          
            void bla() {
                int y = x + 1;
            }
            
            void meh() {
                int y = x + 3;
            }
        }
        """
      ),
      """
      Na liniji 3. vidimo primjer nedozvoljene operacije. Ako se pitate zašto:  
      > Polja objekta se inicijalizuju čim se pozove konstruktor te klase.  
      > Metode se pozivaju **na zahtjev** tj. ručno, on-demand.  
      > Zato nam Java ne dozvoljava tu operaciju.  
      > Također, kompajler ne zna na koje `y` mislimo, da li ono iz `bla()` ili iz `meh()`... :)  

      Primijetite i to da varijabla `y` iz `bla()` **nema nikakve veze** 
      s varijablom `y` iz `meh()`!!!  
      To su dva skroz nezavisna bloka, svaki ima svoj scope.

      ---
      Neki primjeri nedozvoljenog definisanja varijabli su dati u metodi `ne()`.  
      Otkomentarišite liniju po liniju da vidite šta će vam kompajler reći.  
      U metodi `da()` dati su neki primjeri dozvoljenog korištenja istoimenih varijabli.
      """.md,
      chl.java(
        """
        static void ne() {
            int x = 1;
            {
                // int x = 1; // nope
            }
            
            {
                int y = 1;
            }
            // y++; // ne može se koristiti izvan bloka! (isto je i za if, for, while, switch)
            
            // for(int x = 1; x < 5; x++) { }  // x vec definisano na pocetku metode
            
            // while(true) { int x = 1; }      // x vec definisano na pocetku metode
            
            for(int i = 1; i < 5; i++) {
                // for(int i = 1; i < 5; i++) {  } // i vec definisano u gornjoj petlji
            }  
        }
        
        int duzina;
        static void da() {
            // različiti blokovi
            {
                String str = "abc";
            }
            {
                String str = "abc"; // yep, nije na istom NIVOU
            }
            
            // različite petlje/blokovi
            for(int x = 1; x < 5; x++) { }
            for(int x = 1; x < 5; x++) { } // fercera
            
            // zasjenjivanje polja (shadowing)
            // pošto metoda ima svoj scope, 
            // dozvoljeno joj je uvesti novu varijablu istog imena kao polje klase
            int duzina = 5;
        }
        """
      )
    )
  )

}
