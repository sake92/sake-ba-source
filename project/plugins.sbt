resolvers += Resolver.typesafeRepo("releases")
resolvers += Resolver.sonatypeRepo("public")

addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.14")

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.3")

addSbtPlugin("ba.sake" % "sbt-hepek" % "0.0.4")
