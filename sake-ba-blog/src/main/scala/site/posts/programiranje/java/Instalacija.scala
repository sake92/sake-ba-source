package site.posts.programiranje.java

import java.time.LocalDate
import scalatags.Text.all._
import ba.sake.hepek.html.structure.blog.Section
import hepek.images.Images
import hepek.utils.Imports._

object Instalacija extends JavaTemplate {

  override def pageTitle = "Instalacija"
  override def pageDescription = Option(
    "Postupak downloada i instalacije Java platforme: JDK, JRE, javac, java."
  )

  override def postCreateDate = Option(LocalDate.of(2017, 7, 2))
  override def postSections =
    List(uvodSection, dodavanjePATHSection, provjeraSection)

// TODO refactor to markdown md...

  def uvodSection = Section(
    "Instalacija Jave",
    div(
      md("""
          U nastavku slijedi primjer za instalaciju Jave 8. 
          Potpuno isti postupak je i za ostale verzije.  
      """),
      "Kliknite na ",
      hyperlink(
        "http://www.oracle.com/technetwork/java/javase/downloads/index.html",
        true
      )("ovaj link"),
      ".",
      image(relTo(Images.java.downloadJDK1), "JDK download step 1"),
      md(
        "Kada se otvori stranica sa prethodne slike kliknite na dugme **download JDK**."
      ),
      blockquote(
        md("""
            JDK (Java Development Kit) su alati za razvijanje Java programa: kompajler, debager itd.
            JDK sadrži JRE (Java Runtime Environment) koji služi za pokretanje Java programa (JVM, Java API klase itd).
           """)
      ),
      md("""
          Na sljedećoj slici kliknite na "jdk-8u131-windows-x64.exe".
          To je instalacija za 64-bitni Windows.  
          Ako znate da imate 32-bitni Windows onda skinite tu verziju... 
         """),
      image(relTo(Images.java.downloadJDK2), "JDK download step 2"),
      md("""
          Preporučujem da Javu instalirate u folder pod nazivom "C:\Java".  
          Ovo ne morate raditi ali je korisno kada vam treba više verzija Jave.  
          Također, neki programi na Windowsu imaju problema kada putanja sadrži razmak, 
            zato nećemo instalirati u "Program Files"... 
        """),
      blockquote(
        md("""
            **Napomena**: Ne trebate instalirati i JRE!  
            Kada vam dođe prozor za JRE kliknite Cancel! (iksić).  
            Upravo sam vam uštedio 100-tinjak megabajta, nema na čemu... :D
           """)
      ),
      p(
        "Dakle, Kada se završi download, otvorite instalaciju i kliknite Next.",
        br,
        image(relTo(Images.java.installJDKFolder), "JDK folder"),
        """Zatim kliknite dugme "Change..." i prepravite putanju foldera na "C:\Java\jdk1.8.0_131\". """,
        br,
        "JRE će već biti instaliran zajedno sa JDK! Tako da nam ne treba još jedna instalacija...",
        image(relTo(Images.java.installJRENope), "JRE, nope!")
      )
    )
  )

  def dodavanjePATHSection =
    Section(
      "Dodavanje PATH varijabli",
      div(
        p(
          "Dio koji slijedi vezan je više za sam rad operativnog sistema (Windows u našem slučaju) nego za Javu.",
          br,
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
          b("Glavno"),
          """, otvorite "PATH" varijablu i dodajte ";%JAVA_HOME%\bin" na kraj. Bez navodnika, naravno! Kliknite Ok, Ok...""",
          br,
          "To je to! Uspješno ste instalirali Javu! :)",
          br,
          "Stanje bi trebalo biti otprilike ovako:",
          image(relTo(Images.os.winSysVars), "System Properties")
        )
      )
    )

  def provjeraSection = Section(
    "Provjera",
    div(
      "Da bi provjerili jesmo li uspješno obavili zadatak, otvorićemo Command Prompt (kod Linuxaša se rekne Shell).",
      br,
      """Otvorite Start, ukucajte "cmd" i kliknite Enter. Ukucajte """,
      chl.batch.inline("java -version"),
      ". Ako dobijete poruku ",
      br,
      chl.batch.inline(
        "'java' is not recognized as an internal or external command, operable program or batch file."
      ),
      br,
      " nešto nije uredu, provjerite sve korake sekcije ",
      hyperlink(relTo(this) + "#" + dodavanjePATHSection.id, false)(
        dodavanjePATHSection.name
      ),
      " ponovo!",
      br,
      "Ako dobijete nešto slično sljedećoj slici, sve je OK:",
      image(relTo(Images.os.winJavaVer), "Java verzija")
    )
  )

}
