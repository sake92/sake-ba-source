import com.typesafe.sbt.web.Import.WebKeys

inThisBuild(
  List(
    scalaVersion := "2.13.4",
    scalafmtOnCompile := true
  )
)

lazy val sakeBa = (project in file("sake-ba"))
  .settings(
    libraryDependencies ++= Seq(
      "ba.sake"                %% "hepek"                    % "0.8.8",
      "org.scala-lang.modules" %% "scala-collection-contrib" % "0.2.1"
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
