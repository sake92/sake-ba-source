resolvers += Resolver.typesafeRepo("releases")
resolvers += Resolver.sonatypeRepo("public")

addSbtPlugin("org.scalameta"    % "sbt-scalafmt" % "2.4.5")
addSbtPlugin("com.typesafe.sbt" % "sbt-web"      % "1.4.3")
addSbtPlugin("ba.sake"          % "sbt-hepek"    % "0.2.1")
