organization := "fmpwizard"

name         := "Lift Named Comet"

version      := "0.2"

crossScalaVersions := Seq("2.9.1", "2.9.0-1", "2.9.0", "2.8.2", "2.8.1", "2.8.0")

scalaVersion <<= (crossScalaVersions) { versions => versions.head }

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "UTF-8", "-optimise")

libraryDependencies := Seq(
  "net.liftweb" %% "lift-webkit" % "2.4" % "compile"
, "ch.qos.logback" % "logback-classic" % "1.0.0" % "compile->default"
, "org.slf4j" % "jcl-over-slf4j" % "1.6.1" % "compile->default"
)

resolvers   := Seq("Element Nexus"     at "http://maven.element.hr/nexus/content/groups/public")

publishTo   := Some("Element 3rd party" at "http://maven.element.hr/nexus/content/repositories/thirdparty/")

credentials += Credentials(Path.userHome / ".publish" / "element.credentials")

publishArtifact in (Compile, packageDoc) := false
