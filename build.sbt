import com.typesafe.sbt.web.Import.WebKeys

inThisBuild(
  List(
    scalaVersion := "3.1.0",
    scalafmtOnCompile := true,
    resolvers +=
      "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  )
)

lazy val sakeBa = (project in file("sake-ba"))
  .settings(
    libraryDependencies ++= Seq(
      "ba.sake" %% "hepek" % "0.0.0+1-0114d0a3-SNAPSHOT"
    ),
    (hepek in Compile) := {
      WebKeys.assets.value
      (hepek in Compile).value
    },
    WebKeys.webModulesLib := "site/lib",
    openIndexPage := openIndexPageTask.value
  )
  .enablePlugins(HepekPlugin, SbtWeb)

// custom handy tasks
val openIndexPage = taskKey[Unit]("Open index.html")

val openIndexPageTask = Def.taskDyn {
  Def.task {
    java.awt.Desktop.getDesktop
      .browse(new File(hepekTarget.value + "/site/index.html").toURI)
  }
}
