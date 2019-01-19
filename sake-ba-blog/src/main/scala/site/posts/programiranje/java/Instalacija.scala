package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.implicits._
import utils.Imports._
import images.Images

object Instalacija extends JavaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Instalacija")
      .withDescription(
        "Postupak downloada i instalacije Java platforme: JDK, JRE, javac, java."
      )

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2017, 7, 2))
      .withSections(uvodSection, dodavanjePATHSection, provjeraSection)

  val linkToAddPath =
    hyperlink(dodavanjePATHSection.ref)(dodavanjePATHSection.name)

  val installJava8 =
    "http://www.oracle.com/technetwork/java/javase/downloads/index.html"
  val installJava11 = "https://jdk.java.net/11"

  def uvodSection = Section(
    "Instalacija Jave",
    div(
      s"""
        Ako vam je baš mrsko instalirati Javu, za početak možete koristiti i [online verziju](https://www.jdoodle.com/online-java-compiler).  
        Zgodno je za probavanje i igranje sa Javom.
        
        ---
        Preporučujem da instalirate [Javu 11]($installJava11) jer ona sadrži JShell koji je zgodan za eksperimentisanje.  
        Java 11 je dostupna samo za 64-bitne računare.  
        Samo downloadujte i raspakujte zip npr. u `C:\\Java`.  
        Idući korak je [dodavanje PATH varijable](${dodavanjePATHSection.ref}).
        
        ---
        Instalacija [Jave 8]($installJava8) je malo komplikovanija, ali je dostupna i za 32-bitne i 64-bitne računare.        
        Naravno, možete instalirati više verzija Jave, ali samo jednu možete dodati u `PATH`!
      """.md,
      image(relTo(Images.java.downloadJDK1), "JDK download step 1"),
      """
        Kada se otvori stranica sa prethodne slike kliknite na dugme **download JDK**.

        > JDK (Java Development Kit) su alati za razvijanje Java programa: kompajler, debager itd.
        > JDK sadrži JRE (Java Runtime Environment) koji služi za pokretanje Java programa (JVM, Java API klase itd).

        Na sljedećoj slici kliknite na "jdk-8u131-windows-x64.exe".  
        To je instalacija za 64-bitni Windows.  
        Ako znate da imate 32-bitni Windows onda skinite tu verziju... 
       """.md,
      image(relTo(Images.java.downloadJDK2), "JDK download step 2"),
      """
          Preporučujem da Javu instalirate u folder pod nazivom `C:\Java`.  
          Ovo ne morate raditi ali je korisno kada vam treba više verzija Jave.  
          Također, neki programi na Windowsu imaju problema kada putanja sadrži razmak, 
            zato nećemo instalirati u `Program Files`... 

          > **Napomena**: Ne trebate instalirati i JRE!  
          > Kada vam dođe prozor za JRE kliknite Cancel! (iksić).  
          > Upravo sam vam uštedio 100-tinjak megabajta, nema na čemu... :D
       """.md,
      p(
        "Dakle, kada se završi download, otvorite instalaciju i kliknite Next.",
        br,
        image(relTo(Images.java.installJDKFolder), "JDK folder"),
        """
            Zatim kliknite dugme "Change..." i prepravite putanju foldera na `C:\Java\jdk1.8.0_131`.  
            JRE će već biti instaliran zajedno sa JDK! Tako da nam ne treba još jedna instalacija...
        """.md,
        image(relTo(Images.java.installJRENope), "JRE, nope!")
      )
    )
  )

  def dodavanjePATHSection =
    Section(
      "Dodavanje PATH varijabli",
      div(
        p(
          """
             Dio koji slijedi vezan je više za sam rad operativnog sistema (Windows u našem slučaju) nego za Javu.  
             Otvorite `Computer Properties` na Windowsu (desni klik na My Computer -> Properties). Otvoriće vam se sljedeći prozor:
          """.md,
          image(relTo(Images.os.winCompProps), "Computer Properties"),
          "Kliknite na Advanced System Settings. Dobićete sljedeći prozor: ",
          image(relTo(Images.os.winSysProps), "System Properties")
        ),
        p(
          """
            Otvorite `Advanced` tab i kliknite `Environment Variables...`.  
            Dodajte 3 sistemske varijable u donji prozor (u System Variables):
          """.md,
          table(cls := "table table-hover")(
            tr(th("Naziv varijable"), th("Vrijednost")),
            tr(td("JAVA_HOME"), td("""C:\Java\jdk1.8.0_131""")),
            tr(td("JDK_HOME"), td("%JAVA_HOME%")),
            tr(td("JRE_HOME"), td("""%JAVA_HOME%\jre"""))
          ),
          """
            **Glavno**, otvorite `PATH` varijablu i dodajte `;%JAVA_HOME%\bin` na kraj.  
            Nemojte zaboravit tačkazarez kopirati! :D  
            Bez navodnika, naravno! Kliknite Ok, Ok...

            To je to! Uspješno ste instalirali Javu! :)  
            Stanje bi trebalo biti otprilike ovako:
          """.md,
          image(relTo(Images.os.winSysVars), "System Properties")
        )
      )
    )

  def provjeraSection = Section(
    "Provjera",
    div(
      s"""
        Da bi provjerili jesmo li uspješno obavili zadatak, 
          otvorićemo Command Prompt (kod Linuxaša se rekne Shell).  
        Otvorite Start, ukucajte `cmd` i kliknite <kbd>Enter</kbd>. Ukucajte `java -version`.  
        Ako dobijete poruku 
          `'java' is not recognized as an internal or external command, operable program or batch file.`
          nešto nije uredu, provjerite sve korake sekcije $linkToAddPath ponovo!
      """.md,
      "Ako dobijete nešto slično sljedećoj slici, sve je OK:",
      image(relTo(Images.os.winJavaVer), "Java verzija")
    )
  )

}
