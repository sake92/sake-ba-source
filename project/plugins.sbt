
resolvers += Resolver.typesafeRepo("releases")
resolvers += Resolver.sonatypeRepo("public")

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.3")
addSbtPlugin("ba.sake" % "sbt-hepek" % "0.0.4")
