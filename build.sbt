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
    "ba.sake" %% "hepek" % "0.4.0+16-3d9eecba-SNAPSHOT"
  )
)

// sake.ba
lazy val sakeBa = (project in file("sake-ba"))
  .settings(commonSettings)
  .enablePlugins(HepekPlugin, SbtWeb)

// blog.sake.ba
lazy val sakeBaBlog = (project in file("sake-ba-blog"))
  .settings(commonSettings)
  .settings(generatePdfs := genPdfs.value)
  .enablePlugins(HepekPlugin, SbtWeb)

val generatePdfs = taskKey[Unit]("Generate PDFs.")

val genPdfs = Def.taskDyn {
  (hepek in Compile).value // pages must be generated
  val targetFolder = hepekTarget.value
  Def.task {
    (runMain in Compile).toTask(" hepek.PdfGenApp " + targetFolder).value
  }
}
