import com.typesafe.sbt.web.Import.WebKeys
import scalariform.formatter.preferences._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys

lazy val commonSettings = Seq(
  organization := "ba.sake",
  version := "0.0.0-SNAPSHOT",
  scalaVersion := "2.11.8",
  libraryDependencies ++= Seq(
    "com.lihaoyi" %% "scalatags" % "0.6.3"
  ),
  ScalariformKeys.preferences := ScalariformKeys.preferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(DanglingCloseParenthesis, Force)
    .setPreference(NewlineAtEndOfFile, true)
)

lazy val commonSiteSettings = Seq(
  (hepek in Compile) := {
    WebKeys.assets.value     // run 'assets' task also after compiling... :)
    (hepek in Compile).value
  },
  libraryDependencies ++= Seq(
    "org.webjars" % "jquery" % "3.1.1-1",
    "org.webjars" % "bootswatch-cyborg" % "3.3.7"
  ),
  // override for easier relative referencing, default is "lib"
  WebKeys.webModulesLib := "hepek/lib"

  // enable this to see more verbose output
  //logLevel in hepek := Level.Debug
) ++ commonSettings

/* PROJECTS-MODULES */
lazy val core = (project in file("core"))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "ba.sake" % "hepek-core" % "0.0.1"
    )
  )

lazy val sakeBa = (project in file("sake-ba"))
  .settings(
    commonSiteSettings,
    name := "sake-ba"
  )
  .dependsOn(core)
  .enablePlugins(HepekPlugin, SbtWeb)

lazy val sakeBaBlog = (project in file("sake-ba-blog"))
  .settings(
    commonSiteSettings,
    name := "sake-ba-blog",
    libraryDependencies ++= Seq(
      "org.webjars" % "prismjs" % "1.0.0",  // code highlight
      "org.webjars" % "anchorjs" % "3.2.2"  // pretty anchor links
    )
  )
  .dependsOn(core)
  .enablePlugins(HepekPlugin, SbtWeb)
