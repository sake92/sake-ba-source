package hepek.posts.programiranje.java

import java.time.LocalDate

import scalatags.Text.all._

import hepek.templates.Section
import hepek.images.Images
import hepek.utils.html.AllUtils._

object Instalacija extends ProgramiranjeTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Instalacija"
  override def pageDescription = Option(
    "Postupak downloada i instalacije Java platforme: JDK, JRE, javac, java."
  )

  override def dateCreated = LocalDate.of(2017, 7, 2)

  // SEKCIJE
  val uvodSectionContent =
    div(
      p(
        "Kliknite na ", aHref("http://www.oracle.com/technetwork/java/javase/downloads/index.html", true)("ovaj link"), ".",
        image(relTo(Images.java.downloadJDK1), "JDK download step 1"),
        "Kada se otvori stranica sa prethodne slike kliknite na dugme ", b("download JDK"), ".", br,
        blockquote(
          "JDK (Java Development Kit) su alati za razvijanje Java programa: kompajler, debager itd.", br,
          "JDK sadrži JRE (Java Runtime Environment) koji služi za pokretanje Java programa (JVM, Java API klase itd.)."
        )
      ),
      p(
        """Na sljedećoj slici kliknite na "jdk-8u131-windows-x64.exe".
             To je instalacija za 64-bitni Windows. Ako znate da imate 32-bitni Windows onda skinite tu verziju... """,
        image(relTo(Images.java.downloadJDK2), "JDK download step 2")
      ),
      p(
        """Preporučujem da Javu instalirate u folder pod nazivom "C:\Java". """, br,
        "Ovo ne morate raditi ali je korisno kada vam treba više verzija Jave, npr. ako klijent koristi 1.7 verziju pa hoćete testirat i sl.", br,
        """Također, neki programi na Windowsu imaju problema kada putanja sadrži razmak, zato nećemo instalirati u "Program Files"... """,
        blockquote(
          "Napomena: Ne trebate instalirati i JRE!", br,
          "Dakle, kada vam dođe prozor za JRE kliknite Cancel! (iksić).", br,
          "Upravo sam vam uštedio 100-tinjak megabajta, nema na čemu... :D"
        )
      ),
      p(
        "Kada se završi download, otvorite instalaciju i kliknite Next.", br,
        image(relTo(Images.java.installJDKFolder), "JDK folder"),
        """Zatim kliknite dugme "Change..." i prepravite putanju foldera na "C:\Java\jdk1.8.0_131\". """, br,
        "JRE će već biti instaliran zajedno sa JDK! Tako da nam ne treba još jedna instalacija...",
        image(relTo(Images.java.installJRENope), "JRE, nope!")
      )
    )

  val dodavanjePATHSectionContent = div(
    p(
      "Dio koji slijedi specifičan je više za sam rad operativnog sistema (Windows u našem slučaju), nego za Javu.", br,
      "Otvorite Computer Properties na Windowsu (desni klik na My Computer -> Properties). Otvoriće vam se sljedeći prozor:",
      image(relTo(Images.os.winCompProps), "Computer Properties"),
      "Kliknite na Advanced System Settings. Dobićete sljedeći prozor: ",
      image(relTo(Images.os.winSysProps), "System Properties")
    ),
    p(
      "Dodajte 3 sistemske varijable u donji prozor (u System Variables):",
      table(cls := "table table-hover")(
        tr(th("Naziv varijable"), th("Vrijednost")),
        tr(td("JAVA_HOME"), td("""C:\Java\jdk1.8.0_131""")),
        tr(td("JDK_HOME"), td("%JAVA_HOME%")),
        tr(td("JRE_HOME"), td("""%JAVA_HOME%\jre"""))
      ),
      """Na kraju, otvorite "PATH" varijablu i dodajte ";%JAVA_HOME%\bin" na kraj. Bez navodnika, naravno! Kliknite Ok, Ok...""", br,
      "To je to! Uspješno ste instalirali Javu! :)", br,
      "Stanje bi trebalo biti otprilike ovako:",
      image(relTo(Images.os.winSysVars), "System Properties")
    )
  )

  val provjeraSectionContent = div(
    "Da bi provjerili jesmo li uspješno obavili zadatak, otvorićemo Command Prompt (kod Linuxaša se rekne Shell).", br,
    """Otvorite Start, ukucajte "cmd" i kliknite Enter. Ukucajte """,
    shellSnippet("java -version"),
    "Ako dobijete poruku ", br,
    tag("samp")("'java' is not recognized as an internal or external command, operable program or batch file."), br,
    " nešto nije uredu, provjerite sve korake sekcije ",
    aHref(relTo(this) + "#" + dodavanjePATHSection.id, false)(dodavanjePATHSection.name),
    " ponovo!", br,
    "Ako dobijete nešto slično sljedećoj slici, sve je OK:",
    image(relTo(Images.os.winJavaVer), "Java verzija")
  )

  val uvodSection = Section("Instalacija Jave", uvodSectionContent)
  def dodavanjePATHSection = Section("Dodavanje PATH varijabli", dodavanjePATHSectionContent)
  val provjeraSection = Section("Provjera", provjeraSectionContent)

  override def sections = Seq(uvodSection, dodavanjePATHSection, provjeraSection)
}
