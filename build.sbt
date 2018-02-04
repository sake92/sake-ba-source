import com.typesafe.sbt.web.Import.WebKeys

scalaVersion in ThisBuild := "2.12.4"

scalafmtOnCompile in ThisBuild := true

lazy val commonSettings = Seq(
  organization := "ba.sake",
  version := "0.0.0-SNAPSHOT",
  resolvers += Resolver.sonatypeRepo("snapshots"),
  (hepek in Compile) := {
    WebKeys.assets.value // run 'assets' task also after compiling... :)
    (hepek in Compile).value
  },
  libraryDependencies ++= Seq(
    "ba.sake" %% "hepek" % "0.0.0-SNAPSHOT",
    "org.webjars" % "jquery" % "3.2.1",
    "org.webjars" % "bootswatch-cyborg" % "3.3.7",
    "org.webjars" % "anchorjs" % "3.2.2"
  ),
  // move SbtWeb stuff to "site/lib", default is "lib"
  WebKeys.webModulesLib := "site/lib"

  // enable this to see more verbose output
  // logLevel in hepek := Level.Debug
)

lazy val sakeBa = (project in file("sake-ba"))
  .settings(commonSettings)
  .enablePlugins(HepekPlugin, SbtWeb)

lazy val sakeBaBlog = (project in file("sake-ba-blog"))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Seq(
      "org.webjars" % "prismjs" % "1.6.0"
    )
  )
  .enablePlugins(HepekPlugin, SbtWeb)
