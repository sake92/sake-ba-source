resolvers += Resolver.typesafeRepo("releases")
resolvers += Resolver.sonatypeRepo("snapshots") // sbt-hepek is SNAPSHOT

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.7.0")

addSbtPlugin("ba.sake" % "sbt-hepek" % "0.0.1-SNAPSHOT")

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.0")
