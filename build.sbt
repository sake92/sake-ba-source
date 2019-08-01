import com.typesafe.sbt.web.Import.WebKeys

scalaVersion in ThisBuild := "2.12.8"

scalafmtOnCompile in ThisBuild := true

lazy val commonSettings = Seq(
  (hepek in Compile) := {
    WebKeys.assets.value
    (hepek in Compile).value
  },
  // move SbtWeb stuff to "site/lib", default is "lib"
  WebKeys.webModulesLib := "site/lib",
  resolvers += Resolver.sonatypeRepo("snapshots"),
  libraryDependencies ++= Seq(
    "ba.sake" %% "hepek" % "0.4.1+0-c3a028d0+20190801-0029-SNAPSHOT" changing ()
  ),
  openIndexPage := openIndexPageTask.value
)

// sake.ba
lazy val sakeBa = (project in file("sake-ba"))
  .settings(commonSettings)
  .enablePlugins(HepekPlugin, SbtWeb)

// blog.sake.ba
lazy val sakeBaBlog = (project in file("sake-ba-blog"))
  .settings(commonSettings)
  .settings(pdfGenerate := pdfGenerateTask.value)
  .enablePlugins(HepekPlugin, SbtWeb)

// custom handy tasks
val pdfGenerate  = taskKey[Unit]("Generate PDFs")
val openIndexPage = taskKey[Unit]("Open index.html")

val pdfGenerateTask = Def.taskDyn {
  (hepek in Compile).value // pages must be generated
  val targetFolder = hepekTarget.value
  Def.task {
    (runMain in Compile).toTask(" hepek.PdfGenApp " + targetFolder).value
  }
}

val openIndexPageTask = Def.taskDyn {
  Def.task {
    java.awt.Desktop
      .getDesktop()
      .browse(new File(hepekTarget.value + "/site/index.html").toURI)
  }
}
