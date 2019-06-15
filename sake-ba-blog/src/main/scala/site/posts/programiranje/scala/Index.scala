package site.posts.programiranje.scala

import java.time.LocalDate
import scalatags.Text.all._
import utils.Imports._

object Index extends ScalaTemplate {

  override def pageSettings =
    super.pageSettings
      .withTitle("Scala")
      .withLabel("Početna")

  override def blogSettings =
    super.blogSettings
      .withCreateDate(LocalDate.of(2018, 4, 23))
      .withSections(scalaSection)

  def scalaSection = Section(
    "Scala",
    div(
      md("""
        Scala je programski jezik (vrlo) visokog nivoa.  
        Ime je dobila iz opisnog izraza "SCAlable LAnguage". Ubrzo ćemo vidjeti i zašto! :D

        Objedinjuje koncepte iz **objektno orijentisanog programiranja** (OOP) i 
          **funkcionalnog programiranja** (FP).  
        Pošto na raspolaganju imamo cijelu lepezu mogućnosti, 
          treba znati pametno odabrati pravi skup "alata" za dati problem koji rješavamo.

        Primarna platforma na kojoj se izvršava je **Java Virtuelna Mašina** (JVM), 
          pa se mogu koristiti svi library iz Jave.

        Scala ima **statičke tipove**, kao npr. C# ili Java, 
          ali ima podršku čak i za dinamičke (Javascript, Ruby) i strukturalne tipove (kao Typescript)!
        Ovako je npr. podržana interoperabilnost sa Javascriptom, pogledajte ScalaJS projekat.

        Ima vrlo **fleksibilnu i lijepu sintaksu**, pa je pogodna i za pisanje **DSL**-ova (Domain-Specific Language).

        Postoje brojni library i frameworci za **konkurentno i distribuirano programiranje**.  
        Neki od tih su `Future` (u standardnoj library), Akka `Actor`s, Apache Spark, Kafka i dr.
      """)
    )
  )

}
