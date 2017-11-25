package hepek.posts.programiranje.java

import java.time.LocalDate

import scalatags.Text.all._

import hepek.templates.Section
import hepek.utils.html.HTMLUtils._
import hepek.images.Images

object Index extends ProgramiranjeTemplate {

  /* PAGE SETTINGS */
  override def pageTitle = "Uvod u programiranje"
  override def pageLabel = "Početna"
  override def pageDescription = Option("Uvod u programiranje.")

  override def dateCreated = LocalDate.of(2017, 7, 1)

  val uvodSectionContent = div(
    p(
      "Koristeći računar želimo da riješimo neki problem.", br,
      "Bilo to kačenje selfija na FB ili računanje inverzne matrice, to je neki problem.", br,
      "Da bi riješili neki problem moramo razmišljati (koristiti mozak) ili naći kako je neko drugi riješio taj problem pa kopirati."
    ),
    p(
      """Pošto računari nisu inteligentni kao ljudi, moramo im nekako "reći" šta da rade da bi nam pomogli.""", br,
      "To radimo pisanjem ", b("programa"), " (računarskih naravno).", br,
      "Program je ", b("niz naredbi"), " koje računar treba izvršiti, u cilju dobijanja nekog rezultata.", br,
      "Kako svi ljudi razmišljaju na sebi svojstven način, postoji teoretski beskonačno mnogo rješenja (r. programa) za jedan te isti problem!"
    ),
    p(
      "Detalji su bitni, međutim, postoji nekoliko zajedničkih stvari koje sadrži većina programa:",
      ul(
        li(b("ulaz"), " - bio to neki fajl, broj koji unese korisnik pomoću tastature, pokret miša, svejedno..."),
        li(b("izlaz"), " - ispis na ekran ili printer, zvuk zvučnika, vibracija džojstika..."),
        li(b("algoritmi i matematičke funkcije")),
        li(b("odluke"), " - ako je nešto istina uradi jedno - ako nije uradi drugo itd..."),
        li(b("ponavljanja instrukcija"), " - for petlje, while petlje itd.")
      )
    ),
    p(
      b("Algoritam"), " je niz precizno definisanih koraka za dobijanje nekog rezultata.", br,
      "Laički rečeno, to je recept za implementaciju neke funkcije."
    ),
    rowDiv(
      leftDiv(
        p(
          "U toku pisanja koda nekog programa često će nam se pojavljivati logičke greške.", br,
          "Tj. program se izvršava ali ne radi kako bismo željeli. Te greške se nazivaju bagovi. (engl. bug - buba, insekt)", br,
          "Za program koji ima takve greške kaže se da je ", i("bagovit"), ".", br,
          "Proces u kojem tražimo greške i ispravljamo ih naziva se debagovanje."
        )
      ),
      rightDiv(image(relTo(Images.programming.error), "To je to."))
    )
  )

  val uvodSection = Section("Zašto?", uvodSectionContent)

  override def sections = Seq(uvodSection)
}
