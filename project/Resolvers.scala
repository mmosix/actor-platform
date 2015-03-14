import sbt._

object Resolvers {
  lazy val seq = Seq(
    DefaultMavenRepository,
    Resolver.sonatypeRepo("snapshots"),
    Resolver.sonatypeRepo("releases"),
    Resolver.bintrayRepo("scalaz", "releases"),
    Resolver.bintrayRepo("dnvriend", "maven"),
    "actor snapshots" at "http://repos.81port.com/nexus/content/repositories/snapshots",
    "actor releases" at "http://repos.81port.com/nexus/content/repositories/releases"
  )
}
