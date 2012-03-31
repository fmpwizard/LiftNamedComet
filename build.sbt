organization := "fmpwizard"

name         := "Lift Named Comet"

organization := "com.fmpwizard"

version      := "0.3"

crossScalaVersions := Seq("2.9.1", "2.9.0-1", "2.8.2", "2.8.1")

scalaVersion <<= (crossScalaVersions) { versions => versions.head }

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "UTF-8", "-optimise")

libraryDependencies := Seq(
  "net.liftweb"    %% "lift-webkit"    % "2.4"   % "compile",
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "compile",
  "org.slf4j"      % "jcl-over-slf4j"  % "1.6.1" % "compile"
)

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

pomIncludeRepository := { _ => false }

licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("https://github.com/fmpwizard/LiftNamedComet"))

pomExtra := (
  <scm>
    <url>git@github.com:fmpwizard/LiftNamedComet.git</url>
    <connection>scm:git:git@github.com:fmpwizard/LiftNamedComet.git</connection>
  </scm>
  <developers>
    <developer>
      <id>fmpwizard</id>
      <name>Diego Medina</name>
      <url>http://www.fmpwizard.com</url>
    </developer>
  </developers>)
