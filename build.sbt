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
    "ba.sake" %% "hepek" % "0.4.0+41-9c846b8a-SNAPSHOT" changing ()
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
  .settings(generatePdfs := generatePdfsTask.value)
  .enablePlugins(HepekPlugin, SbtWeb)

// custom handy tasks
val generatePdfs  = taskKey[Unit]("Generate PDFs")
val openIndexPage = taskKey[Unit]("Opens index.html")

val generatePdfsTask = Def.taskDyn {
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
